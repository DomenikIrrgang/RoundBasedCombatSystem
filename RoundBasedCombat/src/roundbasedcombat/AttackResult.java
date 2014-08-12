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
public class AttackResult extends CombatAction {
    private double value;
    private boolean critical;
    private Ability ability;

    public AttackResult(Ability ability, AttackLanded result, double value, boolean critical) {
        super(result);
        this.ability = ability;
        this.value = value;
        this.critical = critical;
    }
    
    public boolean isCritical() {
        return critical;
    }

    public AttackLanded getResult() {
        return result;
    }

    public double getValue() {
        return value;
    }    
    
}
