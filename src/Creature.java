import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public abstract class Creature {
    String name;
    int currentHP;
    final int maxHP;
    int damage;
    int crit;
    int allDamage;


    public Creature(String name, int currentHP, int damage, int crit) {
        this.name = name;
        this.currentHP = currentHP;
        this.maxHP = currentHP;
        this.damage = damage;
        this.crit = crit;

    }

    public void attack(Creature attackedCreature) {
        extraAttackdamage();
        attackedCreature.currentHP -= allDamage;
    }

    public void extraAttackdamage() {
        Random random = new Random();
        allDamage = this.damage + random.nextInt(this.crit);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAllDamage() {
        return allDamage;
    }

    public void setAllDamage(int allDamage) {
        this.allDamage = allDamage;
    }
}

