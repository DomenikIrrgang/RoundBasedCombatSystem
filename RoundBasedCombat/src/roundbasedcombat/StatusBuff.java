/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat;

/**
 *
 * @author Domenik
 */
public class StatusBuff extends Buff {
    private final UnitStatus status;

    public StatusBuff(String name, int duration, BuffType type, UnitStatus status, Unit source) {
        super(name, duration, type, source);
        this.status = status;
    }
    
    public UnitStatus getStatus() {
        return status;
    }
}
