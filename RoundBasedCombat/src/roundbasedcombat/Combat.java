/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundbasedcombat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import roundbasedcombat.Log.CombatLog;

/**
 *
 * @author Domenik
 */
public class Combat {

    private List<Unit> enemies = new ArrayList<Unit>();
    private List<Unit> group = new ArrayList<Unit>();

    private List<CombatTurnEntry> turnActions = new ArrayList<CombatTurnEntry>();

    public Combat(List<Unit> group, List<Unit> enemies) {
        this.enemies = enemies;
        this.group = group;
    }

    public List<CombatAction> cast(Unit source, Unit target, Ability abiltiy) {
        List<CombatAction> tmp = new ArrayList<CombatAction>();

        if (!source.hasStatus(UnitStatus.ASLEEP)) {
            if (source.reduceMana(abiltiy.getManaCosts())) {
                if (abiltiy.getTargetType().equals(TargetType.AOE)) {
                    for (Unit unit : getGroup(target)) {
                        tmp.add(castAbility(source, unit, abiltiy));
                    }

                } else {
                    tmp.add(castAbility(source, target, abiltiy));
                }
            } else {
                AttackResult result = new AttackResult(abiltiy, AttackLanded.NOMANA, 0, false);
                tmp.add(result);
                CombatLog.logAbility(source, target, abiltiy, result);
            }
        } else {
            AttackResult result = new AttackResult(abiltiy, AttackLanded.DISABLED, 0, false);
            tmp.add(result);
            CombatLog.logAbility(source, target, abiltiy, result);
        }

        return tmp;
    }

    public List<Unit> getGroup(Unit unit) {
        if (group.contains(unit)) {
            return group;
        } else {
            return enemies;
        }
    }

    public AttackResult damage(Unit source, Unit target, Ability ability) {
        if (target.hasStatus(UnitStatus.REFLECT)) {
            target = source;
        }

        AttackResult result = CombatMath.executeDamage(source, target, ability);
        if (!target.hasStatus(UnitStatus.UNATTACKABLE) && !target.hasStatus(UnitStatus.DEAD)) {
            if (result.getResult().equals(AttackLanded.LANDED)) {
                target.damage(result.getValue());
                CombatLog.logAbility(source, target, ability, result);
                ability.execute(this, source, target);
                if (target.hasStatus(UnitStatus.DEAD)) {
                    clearAllBuffs(target);
                }
                return result;
            } else {
                CombatLog.logAbility(source, target, ability, result);
                return result;
            }

        }
        AttackResult tmp = new AttackResult(ability, AttackLanded.IMMUNE, result.getValue(), result.isCritical());
        CombatLog.logAbility(source, target, ability, tmp);
        return tmp;

    }

    public List<BuffResult> clearAllBuffs(Unit target) {
        List<BuffResult> tmp = new ArrayList<BuffResult>();
        int i = 0;
        Buff buff;
        List<Buff> tmpBuffs = new ArrayList<Buff>();
        for (Buff tmpBuff : target.getBuffs()) {
            tmpBuffs.add(tmpBuff);
        }
        while (i < tmpBuffs.size()) {
            buff = tmpBuffs.get(i);
            if (buff instanceof StatusBuff) {
                target.getStati().remove(((StatusBuff) buff).getStatus());
            }
            tmp.add(target.removeBuff(buff));
            CombatLog.logBuffFaded(buff.source, target, buff);
            i++;
        }
        return tmp;
    }

    public AttackResult heal(Unit source, Unit target, Ability ability) {
        if (target.hasStatus(UnitStatus.REFLECT)) {
            target = source;
        }
        AttackResult result = CombatMath.executeDamage(source, target, ability);
        if (!target.hasStatus(UnitStatus.UNHEALABLE) && !target.hasStatus(UnitStatus.DEAD)) {

            if (result.getResult().equals(AttackLanded.LANDED)) {
                target.heal(result.getValue());
                CombatLog.logAbility(source, target, ability, result);
                ability.execute(this, source, target);
                if (target.hasStatus(UnitStatus.DEAD)) {
                    clearAllBuffs(target);
                }
                return result;
            } else {
                CombatLog.logAbility(source, target, ability, result);
                return result;
            }

        }
        AttackResult tmp = new AttackResult(ability, AttackLanded.IMMUNE, result.getValue(), result.isCritical());
        CombatLog.logAbility(source, target, ability, tmp);
        return tmp;
    }

    public AttackResult rezz(Unit source, Unit target, Ability ability) {
        AttackResult result = CombatMath.executeDamage(source, target, ability);
        if (!target.hasStatus(UnitStatus.UNHEALABLE) && target.hasStatus(UnitStatus.DEAD)) {
            if (result.getResult().equals(AttackLanded.LANDED)) {
                target.heal(result.getValue());
                CombatLog.logAbility(source, target, ability, result);
                ability.execute(this, source, target);
                return result;
            } else {
                CombatLog.logAbility(source, target, ability, result);
                return result;
            }
        }
        AttackResult tmp = new AttackResult(ability, AttackLanded.IMMUNE, result.getValue(), result.isCritical());
        CombatLog.logAbility(source, target, ability, tmp);
        return tmp;
    }

    public BuffResult buff(Unit source, Unit target, Ability ability) {
        BuffAbility tmp = (BuffAbility) ability;
        if (!target.hasStatus(UnitStatus.DEAD)) {

            target.applyBuff(tmp.getBuff(source));
            CombatLog.logBuff(source, target, tmp.getBuff(source));
            return new BuffResult(AttackLanded.LANDED, tmp.getBuff(source));
        }
        return new BuffResult(AttackLanded.IMMUNE, tmp.getBuff(source));
    }

    public BuffResult buff(Unit source, Unit target, Buff buff) {
        if (!target.hasStatus(UnitStatus.DEAD)) {

            target.applyBuff(buff);
            CombatLog.logBuff(source, target, buff);
            return new BuffResult(AttackLanded.LANDED, buff);
        }
        return new BuffResult(AttackLanded.IMMUNE, buff);
    }

    private CombatAction castAbility(Unit source, Unit target, Ability ability) {
        switch (ability.getAbilityType()) {
            case DAMAGE:
                return damage(source, target, ability);
            case HEAL:
                return heal(source, target, ability);
            case REZZ:
                return rezz(source, target, ability);
            case BUFF:
                return buff(source, target, ability);
            case DEBUFF:
                return buff(source, target, ability);
            default:
                return null;
        }
    }

    public List<BuffResult> updateBuffs(Unit unit) {
        List<BuffResult> tmp = new ArrayList<BuffResult>();
        tmp.addAll(updateBuffType(unit, HealthBuff.class));
        tmp.addAll(updateBuffType(unit, StatusBuff.class));
        tmp.addAll(updateBuffType(unit, StatBuff.class));
        return tmp;
    }

    private <T> List<BuffResult> updateBuffType(Unit unit, Class<T> clazz) {
        int i = 0;
        Buff buff;
        List<BuffResult> tmp = new ArrayList<BuffResult>();
        while (i < unit.getBuffs().size()) {
            buff = unit.getBuffs().get(i);
            if (clazz.isAssignableFrom(buff.getClass())) {
                buff.update(this, unit);
                if (buff.getDuration() <= 0) {
                    if (buff instanceof StatusBuff) {
                        unit.getStati().remove(((StatusBuff) buff).getStatus());
                    }
                    unit.removeBuff(buff);
                    tmp.add(new BuffResult(AttackLanded.FADED, buff));
                    CombatLog.logBuffFaded(buff.source, unit, buff);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return tmp;
    }

    public boolean queueAbility(Unit source, Unit target, Ability ability) {
        if (!hasAbilityInQueue(source)) {
            turnActions.add(new CombatTurnEntry(source, target, ability));
            return true;
        }
        return false;
    }

    public List<CombatAction> doRound() {
        List<CombatAction> tmp = new ArrayList<CombatAction>();
        CombatTurnEntry entry;
        int i;
        while (!turnActions.isEmpty()) {
            i = 0;
            entry = turnActions.get(i);
            while (i < turnActions.size()) {
                if (turnActions.get(i).getSource().getStats().getSpeed() > entry.getSource().getStats().getSpeed()) {
                    entry = turnActions.get(i);
                }
                i++;
            }
            tmp.addAll(cast(entry.getSource(), entry.getTarget(), entry.getAbility()));
            turnActions.remove(entry);
        }

        updateBuffsInGroup(enemies);
        updateBuffsInGroup(group);

        return tmp;
    }

    private List<BuffResult> updateBuffsInGroup(List<Unit> units) {
        List<BuffResult> tmp = new ArrayList<BuffResult>();
        for (Unit unit : units) {
            tmp.addAll(updateBuffs(unit));
        }
        return tmp;
    }

    private boolean hasAbilityInQueue(Unit unit) {
        for (CombatTurnEntry entry : turnActions) {
            if (entry.getSource().equals(unit)) {
                return true;
            }
        }
        return false;
    }
}
