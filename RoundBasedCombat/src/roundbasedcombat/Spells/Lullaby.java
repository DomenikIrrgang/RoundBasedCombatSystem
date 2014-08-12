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
import roundbasedcombat.StatusBuff;
import roundbasedcombat.TargetType;
import roundbasedcombat.Unit;
import roundbasedcombat.UnitStatus;

/**
 *
 * @author Domenik
 */
public class Lullaby extends BuffAbility {

    public Lullaby() {
        super("Lullaby", AbilityType.DEBUFF, TargetType.SINGLE, SpellType.NEUTRAL, 15, 0, 0);
    }

    @Override
    public Buff getBuff(Unit source) {
        return new StatusBuff("Your heard a Lullaby. You sleep like a little baby!", 2, BuffType.DEBUFF, UnitStatus.ASLEEP, source);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {

    }

    @Override
    public double calculateValue(Unit source) {
        return 0;
    }
    
}
