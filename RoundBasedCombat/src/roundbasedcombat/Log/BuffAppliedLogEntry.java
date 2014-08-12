/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Log;

import roundbasedcombat.Buff;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class BuffAppliedLogEntry extends BuffLogEntry {
    

    public BuffAppliedLogEntry(Unit source, Unit target, Buff buff) {
        super(source, target, buff);
    }
    
    @Override
    public String toString() {
        return source.getName() + " applies " + buff.getName() + " on " + target.getName() + ".";
    }
    
}
