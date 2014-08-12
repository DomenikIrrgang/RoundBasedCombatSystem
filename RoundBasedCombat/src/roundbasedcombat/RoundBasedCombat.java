/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundbasedcombat;

import java.util.ArrayList;
import java.util.List;
import roundbasedcombat.Spells.Acceleration;
import roundbasedcombat.Spells.Dispell;
import roundbasedcombat.Spells.DivineShield;
import roundbasedcombat.Spells.DominationOfLife;
import roundbasedcombat.Spells.Fireball;
import roundbasedcombat.Spells.FlashHeal;
import roundbasedcombat.Spells.Lullaby;
import roundbasedcombat.Spells.MagicMirror;
import roundbasedcombat.Spells.Shrink;
import roundbasedcombat.Spells.SpellSteel;
import static sun.audio.AudioPlayer.player;

/**
 *
 * @author Domenik
 */
public class RoundBasedCombat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StatSet statsPlayer = new StatSet();
        StatSet buff = new StatSet();

        buff.setIntellect(500);
        buff.setDamageDoneModificator(0.1);
        buff.setDamageTakenModificator(0.1);
        buff.setFireResistance(0.2);
        buff.setLightResistance(1);
        buff.setStamina(10);

        statsPlayer.setIntellect(5);
        statsPlayer.setMiss(10);

        Ability ability = new Fireball();
        Ability heal = new FlashHeal();
        Ability rezz = new DominationOfLife();
        Ability divineShield = new DivineShield();
        Ability dispell = new Dispell();

        Unit player = new Unit("Domenik", 10, 5, statsPlayer);
        Unit player1 = new Unit("Christopher", 10, 10, statsPlayer);
        Unit target = new Unit("Endgegner", 200, 200, statsPlayer);
        Unit target2 = new Unit("Endgegner1", 200, 200, statsPlayer);

        player.applyBuff(new StatBuff("OP_STATBUFF", 10, BuffType.BUFF, buff, player));
        //player1.applyBuff(new StatBuff("Stamina", 10, BuffType.BUFF, buff, player));
        List<Unit> group = new ArrayList<Unit>();
        List<Unit> enemies = new ArrayList<Unit>();

        group.add(player);
        group.add(player1);
        enemies.add(target);
        enemies.add(target2);

        Combat combat = new Combat(group, enemies);
        
        combat.queueAbility(target, player, new Lullaby());
        combat.doRound();
        combat.queueAbility(player, target, ability);
        combat.doRound();

        System.out.println("Health: " + player.getCurrentHealth() + "/" + player.getHealth());
        System.out.println("Health: " + player1.getCurrentHealth() + "/" + player1.getHealth());
        System.out.println("Health: " + target.getCurrentHealth() + "/" + target.getHealth());
        combat.queueAbility(player, player, heal);
        combat.doRound();
        System.out.println("Health: " + player.getCurrentHealth() + "/" + player.getHealth());
        System.out.println("Health: " + player1.getCurrentHealth() + "/" + player1.getHealth());
        System.out.println("Health: " + target.getCurrentHealth() + "/" + target.getHealth());
    }

    private static void doRound(Unit player, Unit target) {
        //System.out.println("NEW ROUND:");

        player.updateBuffs();
        for (UnitStatus status : target.getStati()) {
            System.out.println(status);
        }
        // System.out.println("");
        //   System.out.println("Health: " + player.getCurrentHealth() + "/" + player.getHealth());
        System.out.println("Health: " + target.getCurrentHealth() + "/" + target.getHealth());
        //    System.out.println("");
    }

    public void testUnit() {
        player.applyBuff(new StatBuff("Stamina", 10, BuffType.BUFF, buff, player));
        //target.applyBuff(new StatBuff("intbuff", 1, BuffType.BUFF, buff, player));

        //target.applyBuff(new StatusBuff("IMMUNE", 1, BuffType.BUFF, UnitStatus.POISEND, player));
        //player.applyBuff(new StatusBuff("IMMUNE", 1, BuffType.BUFF, UnitStatus.UNHEALABLE, player));
        target.cast(player, ability);
        target.cast(player, rezz);
        doRound(player, target);
        target.cast(player, ability);
        doRound(player, target);
        doRound(player, target);
        doRound(player, target);
        doRound(player, target);
        target.damage(player, ability);
        doRound(player, target);
    }

}
