import java.util.Random;

public class Player extends Creature {
    int level;
    int exp;
    int crit;
    int maxExp = 200;

    public Player(String name, int currentHP, int damage, int exp, int level, int crit) {
        super(name, currentHP, damage, crit);
        this.exp = exp;
        this.level = level;
        this.crit = crit;

    }

    @Override
    public String toString() {
        return "*******************" +
                "\n* Name: " + super.getName() +
                "\n* Level: " + level +
                "\n* hp: " + currentHP + "/" + maxHP +
                "\n* exp: " + exp + "/" + maxExp +
                "\n*******************";
    }





    public void increaseLevel(){
    Random random = new Random();
    if (exp >= maxExp) {
        this.exp = 0;
        this.level++;
        int gainedHP = (random.nextInt(100) + 81);
        this.currentHP += gainedHP;
        System.out.println("You leveled up to lv " + this.level + " , you gained " + gainedHP + " HP!");
    }

}

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = this.exp + exp;
    }
}







