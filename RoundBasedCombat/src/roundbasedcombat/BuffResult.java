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
public class BuffResult extends CombatAction {
    
    private Buff buff;

    public BuffResult(AttackLanded result, Buff buff) {
        super(result);
        this.buff = buff;
    }

    public Buff getBuff() {
        return buff;
    }
    
}
