/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Spells;

import roundbasedcombat.Ability;
import roundbasedcombat.AbilityType;
import roundbasedcombat.AttackResult;
import roundbasedcombat.Buff;
import roundbasedcombat.BuffAbility;
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
public class FireballDOT extends BuffAbility {

    public FireballDOT() {
        super("FireballDOT", AbilityType.DEBUFF, TargetType.SINGLE, SpellType.FIRE, -10000, 50, 0);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {

    }

    @Override
    public double calculateValue(Unit source) {
        return source.getStats().getIntellect() * 0.3;
    }

    @Override
    public Buff getBuff(Unit source) {
        return new HealthBuff("Fireball DOT", 3, BuffType.DEBUFF, 3, source, this);
    }
    
}
