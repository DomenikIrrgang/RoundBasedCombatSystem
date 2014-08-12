/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Spells;

import java.util.List;
import roundbasedcombat.AbilityType;
import roundbasedcombat.AttackResult;
import roundbasedcombat.Buff;
import roundbasedcombat.BuffAbility;
import roundbasedcombat.BuffType;
import roundbasedcombat.Combat;
import roundbasedcombat.CombatAction;
import roundbasedcombat.SpellType;
import roundbasedcombat.StatBuff;
import roundbasedcombat.StatSet;
import roundbasedcombat.TargetType;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class Acceleration extends BuffAbility {

    public Acceleration() {
        super("Accelration", AbilityType.BUFF, TargetType.SINGLE, SpellType.NEUTRAL, 0, 0, 5);
    }

    @Override
    public Buff getBuff(Unit source) {
        StatSet stats = new StatSet();
        stats.setSpeed(10);
        return new StatBuff("Make haste!", 3, BuffType.BUFF, stats, source);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        
    }

    @Override
    public double calculateValue(Unit source) {
        return 0;
    }
    
}
