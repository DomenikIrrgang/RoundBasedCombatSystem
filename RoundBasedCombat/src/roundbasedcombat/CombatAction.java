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
public abstract class CombatAction {
    protected AttackLanded result;

    public CombatAction(AttackLanded result) {
        this.result = result;
    }

    public AttackLanded getResult() {
        return result;
    }

}
