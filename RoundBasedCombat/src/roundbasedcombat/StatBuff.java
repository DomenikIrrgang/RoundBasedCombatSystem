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
public class StatBuff extends Buff {
    private StatSet statSet;

    public StatBuff(String name, int duration, BuffType type, StatSet statSet, Unit source) {
        super(name, duration, type, source);
        this.statSet = statSet;
    }
    
    public StatSet getStatSet() {
        return statSet;
    }
    
}
