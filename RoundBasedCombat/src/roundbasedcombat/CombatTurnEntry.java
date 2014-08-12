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
public class CombatTurnEntry {
    private Unit source;
    private Unit target;
    private Ability ability;

    public CombatTurnEntry(Unit source, Unit target, Ability ability) {
        this.source = source;
        this.target = target;
        this.ability = ability;
    }

    public Unit getSource() {
        return source;
    }

    public Unit getTarget() {
        return target;
    }

    public Ability getAbility() {
        return ability;
    }
    
}
