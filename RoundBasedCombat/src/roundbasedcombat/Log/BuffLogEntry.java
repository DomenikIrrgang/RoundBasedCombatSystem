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
public class BuffLogEntry extends CombatLogEntry {
    protected Buff buff;

    public BuffLogEntry(Unit source, Unit target, Buff buff) {
        super(source, target);
        this.buff = buff;
    }
    
    public Buff getBuff() {
        return buff;
    }
}
