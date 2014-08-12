/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Spells;

import roundbasedcombat.AbilityType;
import roundbasedcombat.AttackResult;
import roundbasedcombat.Buff;
import roundbasedcombat.BuffAbility;
import roundbasedcombat.BuffType;
import roundbasedcombat.Combat;
import roundbasedcombat.SpellType;
import roundbasedcombat.StatBuff;
import roundbasedcombat.StatSet;
import roundbasedcombat.TargetType;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class Shrink extends BuffAbility {

    public Shrink() {
        super("Shrink", AbilityType.DEBUFF, TargetType.SINGLE, SpellType.DARK, 0, 0, 5);
    }

    @Override
    public Buff getBuff(Unit source) {
        StatSet stats = new StatSet();
        stats.setDamageDoneModificator(-0.2);
        return new StatBuff("Shrinked!", 1, BuffType.DEBUFF, stats, source);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {

    }

    @Override
    public double calculateValue(Unit source) {
        return 0;
    }
    
}
