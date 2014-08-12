/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Spells;

import roundbasedcombat.Ability;
import roundbasedcombat.AbilityType;
import roundbasedcombat.AttackResult;
import roundbasedcombat.Buff;
import roundbasedcombat.BuffAbility;
import roundbasedcombat.BuffType;
import roundbasedcombat.Combat;
import roundbasedcombat.HealthBuff;
import roundbasedcombat.SpellType;
import roundbasedcombat.TargetType;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class Renew extends BuffAbility {

    public Renew() {
        super("Renew", AbilityType.BUFF, TargetType.SINGLE, SpellType.LIGHT, -1000, 50, 0);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {

    }

    @Override
    public double calculateValue(Unit source) {
        return source.getStats().getIntellect() * 0.3;
    }

    @Override
    public Buff getBuff(Unit source) {
        return new HealthBuff("Renew", 3, BuffType.BUFF, 3, source, this);
    }
    
}
