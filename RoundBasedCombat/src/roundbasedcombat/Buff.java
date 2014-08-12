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
public abstract class Buff {
    private final String name;
    private int duration;
    private final BuffType type;
    protected Unit source;

    public Buff(String name, int duration, BuffType type, Unit source) {
        this.duration = duration;
        this.name = name;
        this.type = type;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public BuffType getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }
    
    public void update(Combat combat, Unit unit) {
        duration--;
    }
}
