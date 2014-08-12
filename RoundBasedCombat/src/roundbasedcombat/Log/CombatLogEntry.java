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
public abstract class CombatLogEntry {
    protected Unit source;
    protected Unit target;

    public CombatLogEntry(Unit source, Unit target) {
        this.source = source;
        this.target = target;
    }

    public Unit getSource() {
        return source;
    }

    public Unit getTarget() {
        return target;
    }   
    
}
