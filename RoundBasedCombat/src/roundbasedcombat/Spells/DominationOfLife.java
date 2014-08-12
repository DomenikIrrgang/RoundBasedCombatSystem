/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Spells;

import roundbasedcombat.Ability;
import roundbasedcombat.AbilityType;
import roundbasedcombat.AttackResult;
import roundbasedcombat.Combat;
import roundbasedcombat.SpellType;
import roundbasedcombat.TargetType;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class DominationOfLife extends Ability {

    public DominationOfLife() {
        super("Domination of Life", AbilityType.REZZ, TargetType.SINGLE, SpellType.DARK, 0, 50, 5);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        
    }

    @Override
    public double calculateValue(Unit source) {
        return source.getStats().getIntellect() * 1.3;
    }
    
}
