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
public class HealthBuff extends Buff {
    private Ability ability;

    public HealthBuff(String name, int duration, BuffType type, double value, Unit source, Ability ability) {
        super(name, duration, type, source);
        this.ability = ability;
    }
    
    @Override
    public void update(Combat combat, Unit unit) {
        super.update(combat, unit);
        switch (ability.getAbilityType()) {
            case BUFF:
                combat.heal(source, unit, ability);
                break;
            case DEBUFF:
                combat.damage(source, unit, ability);
        }
    }
    
}
