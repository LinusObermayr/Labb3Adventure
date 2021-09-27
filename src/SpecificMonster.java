import java.util.Random;

public class SpecificMonster extends Creature {

    int expGainedByKillingMonster;
    int crit;
    String whenDeadPrint = null;


    public SpecificMonster(String name, int currentHP, int damage, int expGainedByKillingMonster,  int crit) {
        super(name, currentHP, damage, crit);
        this.expGainedByKillingMonster = expGainedByKillingMonster;
        this.crit = crit;
        this.whenDeadPrint = "Monster is Dead!";
    }

    @Override
    public String toString() {
        return "SpecifikMonster{" +
                "name='" + name + '\'' +
                ", currentHP=" + currentHP +
                ", maxHP=" + maxHP +
                ", damage=" + damage +
                ", expGainedByKillingMonster=" + expGainedByKillingMonster +
                '}';
    }


    public int getExpGainedByKillingMonster() {
        return expGainedByKillingMonster;
    }

    public void setExpGainedByKillingMonster(int expGainedByKillingMonster) {
        this.expGainedByKillingMonster = expGainedByKillingMonster;
    }
}

