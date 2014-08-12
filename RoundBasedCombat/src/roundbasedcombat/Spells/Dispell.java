/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Spells;

import java.util.List;
import roundbasedcombat.Ability;
import roundbasedcombat.AbilityType;
import roundbasedcombat.AttackResult;
import roundbasedcombat.Combat;
import roundbasedcombat.CombatAction;
import roundbasedcombat.SpellType;
import roundbasedcombat.TargetType;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class Dispell extends Ability {

    public Dispell() {
        super("Dispell", AbilityType.HEAL, TargetType.SINGLE, SpellType.LIGHT, 0, 0, 5);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        combat.clearAllBuffs(target);
    }

    @Override
    public double calculateValue(Unit source) {
        return 5;
    }
    
}
