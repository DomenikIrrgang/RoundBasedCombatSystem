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
public class BuffFadedLogEntry extends BuffLogEntry {

    public BuffFadedLogEntry(Unit source, Unit target, Buff buff) {
        super(source, target, buff);
    }
    
    @Override
    public String toString() {
        return buff.getName() + " on " + target.getName() + " applied by " + source.getName() + " faded.";
    }
}
