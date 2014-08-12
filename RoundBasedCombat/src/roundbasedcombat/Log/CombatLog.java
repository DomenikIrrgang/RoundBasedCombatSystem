/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat.Log;

import java.util.ArrayList;
import java.util.List;
import roundbasedcombat.Ability;
import roundbasedcombat.AttackResult;
import roundbasedcombat.Buff;
import roundbasedcombat.Unit;

/**
 *
 * @author Domenik
 */
public class CombatLog {
    private static List<CombatLogEntry> entries = new ArrayList<CombatLogEntry>();
    
    public static void logAbility(Unit source, Unit target, Ability ability, AttackResult result) {
        CombatLogEntry entry = new DamageLogEntry(ability, result, source, target);
        entries.add(entry);
        System.out.println(entry);
    }
    
    public static void logBuff(Unit source, Unit target, Buff buff) {
        CombatLogEntry entry = new BuffAppliedLogEntry(source, target, buff); 
        entries.add(entry);
        System.out.println(entry);
    }
    
    public static void logBuffFaded(Unit source, Unit target, Buff buff) {
        CombatLogEntry entry = new BuffFadedLogEntry(source, target, buff);
        entries.add(entry);
        System.out.println(entry);
    }
 
}
