/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Spells;

import java.util.ArrayList;
import java.util.List;
import roundbasedcombat.Ability;
import roundbasedcombat.AbilityType;
import roundbasedcombat.AttackResult;
import roundbasedcombat.Buff;
import roundbasedcombat.Combat;
import roundbasedcombat.SpellType;
import roundbasedcombat.TargetType;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class SpellSteel extends Ability {

    public SpellSteel() {
        super("Spell steel", AbilityType.DAMAGE, TargetType.AOE, SpellType.DARK, 0, 0, 5);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        List<Buff> tmp = new ArrayList<Buff>();
        for (Buff buff : target.getBuffs()) {
            tmp.add(buff);
        }
        combat.clearAllBuffs(target);
        for (Buff buff: tmp) {
            combat.buff(source, source, buff);
        }          
    }

    @Override
    public double calculateValue(Unit source) {
        return 3;
    }
    
}
