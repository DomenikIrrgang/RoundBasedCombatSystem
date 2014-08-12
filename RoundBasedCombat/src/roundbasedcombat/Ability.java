/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundbasedcombat;

import java.util.List;

/**
 *
 * @author Domenik
 */
public abstract class Ability {
    private AbilityType abilityType;
    private TargetType targetType;
    private SpellType spellType;
    
    private double missChance;
    private double critChance;
    
    private int manaCosts;
    private String name = "";

    public Ability(String name, AbilityType abilityType, TargetType targetType, SpellType spellType, double missChance, double critChance, int manaCosts) {
        this.name = name;
        this.abilityType = abilityType;
        this.targetType = targetType;
        this.spellType = spellType;
        this.missChance = missChance;
        this.critChance = critChance;
        this.manaCosts = manaCosts;
    }
    
    public String getName() {
        return name;
    }

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(AbilityType abilityType) {
        this.abilityType = abilityType;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public void setSpellType(SpellType spellType) {
        this.spellType = spellType;
    }

    public double getMissChance() {
        return missChance;
    }

    public void setMissChance(double missChance) {
        this.missChance = missChance;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public int getManaCosts() {
        return manaCosts;
    }

    public void setManaCosts(int manaCosts) {
        this.manaCosts = manaCosts;
    }
    
    public abstract void execute(Combat combat, Unit source, Unit target, AttackResult result);
    public abstract double calculateValue(Unit source);
    
}
