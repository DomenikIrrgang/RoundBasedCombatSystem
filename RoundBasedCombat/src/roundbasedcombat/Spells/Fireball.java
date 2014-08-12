/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Spells;

import roundbasedcombat.Ability;
import roundbasedcombat.AbilityType;
import roundbasedcombat.AttackLanded;
import roundbasedcombat.AttackResult;
import roundbasedcombat.BuffType;
import roundbasedcombat.Combat;
import roundbasedcombat.CombatMath;
import roundbasedcombat.HealthBuff;
import roundbasedcombat.SpellType;
import roundbasedcombat.TargetType;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class Fireball extends Ability {

    public Fireball() {
        super("Fireball", AbilityType.DAMAGE, TargetType.AOE, SpellType.FIRE, 0, 5, 2);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
            combat.cast(source, target, new FireballDOT());
    }
    
    public double calculateDamageDone(Unit source) {
        double tmp;
        
        tmp = 5 + source.getStats().getIntellect() * 0.57;
        
        return tmp;
    }

    @Override
    public double calculateValue(Unit source) {
        return 1 + source.getStats().getIntellect() * 0.57;
    }
    
}
