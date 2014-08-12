/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat;

import java.util.Random;

/**
 *
 * @author Domenik
 */
public class CombatMath {
    
    private static Random random = new Random();
    
    public static boolean calculateCrit(Unit source, Unit target, Ability ability, double value) {
        if (isInRange(source.getStats().getCrit() + ability.getCritChance())) {
            return true;
        }
        return false;
    }
    
    public static boolean spellMissed(Unit source, Unit target, Ability ability) {
        double chanceToMiss = ability.getMissChance() + target.getStats().getMiss();
        chanceToMiss = chanceToMiss - source.getStats().getAccuracy();
        return isInRange(chanceToMiss);
    }
    
    public static boolean attackMissed(Unit source, Unit target) {
        double chanceToDodge = target.getStats().getDodge();
        chanceToDodge = chanceToDodge - source.getStats().getAccuracy();
        
        return isInRange(chanceToDodge);
    }
    
    private static boolean isInRange(double value) {
        if (random.nextInt(1001) <= value * 10) {
            return true;
        }
        return false;
    }
    
    private static double increaseDamageByModificator(Unit source, double value) {
        return value * (source.getStats().getDamageDoneModificator() + 1);
    }
    
    private static double reduceDamageByResistance(Unit target, Ability ability, double value) {
        return value * (1 - target.getStats().getResistance(ability.getSpellType()));
    }
    
    private static double reduceDamageByModificator(Unit target, double value) {
        return value * (1 - target.getStats().getDamageTakenModificator());
    }
    
    public static AttackResult executeDamage(Unit source, Unit target, Ability ability) {
        if (!spellMissed(source, target, ability)) {
            boolean critical = false;
            double value = ability.calculateValue(source);
            value = increaseDamageByModificator(source, value);
            value = reduceDamageByResistance(target, ability, value);
            value = reduceDamageByModificator(target, value);
            if (calculateCrit(source, target, ability, value)) {
                value = value * 2;
                critical = true;
            }
            return new AttackResult(ability, AttackLanded.LANDED, value, critical);
        } else {
            return new AttackResult(ability, AttackLanded.MISS, 0, false);
        }
    }
    
    public static double increaseHealingByResistance(Unit target, Ability ability, double value) {
        return value * (1 + target.getStats().getResistance(ability.getSpellType()));
    }
    
    public static AttackResult executeHeal(Unit source, Unit target, Ability ability) {
        if (!spellMissed(source, target, ability)) {
            boolean critical = false;
            double value = ability.calculateValue(source);
            value = increaseDamageByModificator(source, value);
            value = increaseHealingByResistance(target, ability, value);
            if (calculateCrit(source, target, ability, value)) {
                value = value * 2;
                critical = true;
            }
            return new AttackResult(ability, AttackLanded.LANDED, value, critical);
        } else {
            return new AttackResult(ability, AttackLanded.MISS, 0, false);
        }
    }
}
