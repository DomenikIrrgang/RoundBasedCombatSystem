/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundbasedcombat.Log;

import roundbasedcombat.Ability;
import roundbasedcombat.AttackResult;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class DamageLogEntry extends CombatLogEntry {

    private Ability ability;
    private AttackResult result;

    public DamageLogEntry(Ability ability, AttackResult result, Unit source, Unit target) {
        super(source, target);
        this.ability = ability;
        this.result = result;
    }

    public Ability getAbility() {
        return ability;
    }

    public AttackResult getResult() {
        return result;
    }
    
    
    @Override
    public String toString() {
        String string = source.getName() + " casts " + ability.getName() + " on " + target.getName() + ". Result: " + result.getResult() + " Value: " + result.getValue();
        if (result.isCritical()) {
            string = string + " (critical)";
        }
        return string;
    }
}
