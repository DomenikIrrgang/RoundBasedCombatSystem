/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Spells;

import roundbasedcombat.Ability;
import roundbasedcombat.AbilityType;
import roundbasedcombat.AttackResult;
import roundbasedcombat.BuffType;
import roundbasedcombat.Combat;
import roundbasedcombat.HealthBuff;
import roundbasedcombat.SpellType;
import roundbasedcombat.TargetType;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class FlashHeal extends Ability {

    public FlashHeal() {
        super("Flashheal", AbilityType.HEAL, TargetType.SINGLE, SpellType.LIGHT, 0, 50, 2);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        combat.cast(source, target, new Renew());
    }

    @Override
    public double calculateValue(Unit source) {
        return source.getStats().getIntellect() * 0.3 + 1;
    }
    
}
