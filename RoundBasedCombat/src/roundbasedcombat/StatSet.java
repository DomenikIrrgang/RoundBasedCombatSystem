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
public class StatSet {
    private double intellect;
    private double strenght;
    private double agility;
    private double stamina;
    private double armor;
    private double speed;
    private double accuracy;
    private double dodge;
    private double miss;
    private double crit;
    private double lightResistance;
    private double darkResistance;
    private double fireResistance;
    private double waterResistance;
    private double damageTakenModificator;
    private double damageDoneModificator;

    public double getIntellect() {
        return intellect;
    }

    public void setIntellect(double intellect) {
        this.intellect = intellect;
    }

    public double getStrenght() {
        return strenght;
    }

    public void setStrenght(double strenght) {
        this.strenght = strenght;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getDodge() {
        return dodge;
    }

    public void setDodge(double dodge) {
        this.dodge = dodge;
    }

    public double getMiss() {
        return miss;
    }

    public void setMiss(double miss) {
        this.miss = miss;
    }

    public double getCrit() {
        return crit;
    }

    public void setCrit(double crit) {
        this.crit = crit;
    }

    public double getLightResistance() {
        return lightResistance;
    }

    public void setLightResistance(double lightResistance) {
        this.lightResistance = lightResistance;
    }

    public double getDarkResistance() {
        return darkResistance;
    }

    public void setDarkResistance(double darkResistance) {
        this.darkResistance = darkResistance;
    }

    public double getFireResistance() {
        return fireResistance;
    }

    public void setFireResistance(double fireResistance) {
        this.fireResistance = fireResistance;
    }

    public double getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(double waterResistance) {
        this.waterResistance = waterResistance;
    }

    public double getDamageTakenModificator() {
        return damageTakenModificator;
    }

    public void setDamageTakenModificator(double damageTakenModificator) {
        this.damageTakenModificator = damageTakenModificator;
    }

    public double getDamageDoneModificator() {
        return damageDoneModificator;
    }

    public void setDamageDoneModificator(double damageDoneModificator) {
        this.damageDoneModificator = damageDoneModificator;
    }
    
    public double getResistance(SpellType spellType) {
        switch (spellType) {
            case DARK: 
                return darkResistance;
            case LIGHT:
                return lightResistance;
            case FIRE:
                return fireResistance;
            case WATER:
                return waterResistance;
            default:
                return 0;
        }
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }
    
    public StatSet add(StatSet statSet) {
        StatSet tmp = new StatSet();
        tmp.setIntellect(intellect + statSet.getIntellect());
        tmp.setStrenght(strenght + statSet.getStrenght());
        tmp.setAgility(agility + statSet.getAgility());
        tmp.setArmor(armor + statSet.getArmor());
        tmp.setSpeed(speed + statSet.getSpeed());
        tmp.setAccuracy(accuracy + statSet.getAccuracy());
        tmp.setDodge(dodge + statSet.getDodge());
        tmp.setMiss(miss + statSet.getMiss());
        tmp.setCrit(crit + statSet.getCrit());
        tmp.setLightResistance(lightResistance + statSet.getLightResistance());
        tmp.setDarkResistance(darkResistance + statSet.getDarkResistance());
        tmp.setFireResistance(fireResistance + statSet.getFireResistance());
        tmp.setWaterResistance(waterResistance + statSet.getWaterResistance());
        tmp.setDamageTakenModificator(damageTakenModificator + statSet.getDamageTakenModificator());
        tmp.setDamageDoneModificator(damageDoneModificator + statSet.getDamageDoneModificator());
        tmp.setStamina(stamina + statSet.getStamina());
         
        return tmp;
    }
}
