import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Random staticRandom = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean Adventure = true;
        int round = 0;

        Player player1 = new Player("", 500, 60, 0, 1, 50);

        welcomeToTheGame();
        player1.setName(sc.nextLine());


        ArrayList<SpecificMonster> monsterArray = new ArrayList<>();
        SpecificMonster monster1 = new SpecificMonster("Evelynn", 150,30,50, 20);
        SpecificMonster monster2 = new SpecificMonster("Kha'Zix", 200, 35, 65, 25);
        SpecificMonster monster3 = new SpecificMonster("Rengar", 250, 40, 100, 30);

        monsterArray.add(monster1);
        monsterArray.add(monster2);
        monsterArray.add(monster3);


        do {
            SpecificMonster currentMonster = randomMonster(monsterArray, round);  //slumpa vilket monster som dyker upp efter runda 3.

            showMenu();

            boolean nothingHappens = staticRandom.nextInt(10) <= 0;
            boolean menuRepeat = false;

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Adventure = true;
                    break;

                case 2:
                    System.out.println("Character Statistics");
                    System.out.println(player1.toString());
                    menuRepeat = true;
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose a number between 1-3!");
                    menuRepeat = true;
            }

            if (!menuRepeat) {
                if (nothingHappens) {
                    smallChanceNoFight();  //10% chans att ingen fiende dyker upp.
                } else {
                    System.out.println("This is the " + (round + 1) + "th time you meet a monster");  //
                    while (currentMonster.getCurrentHP() > 0 || player1.getCurrentHP() > 0) {
                        fight();
                        enterKey();
                        player1.attack(currentMonster);
                        System.out.println(player1.getName() + " attacks " + currentMonster.getName());
                        delayAttack(player1.getName());
                        System.out.println(player1.getName() + " did " + player1.getAllDamage() + "damage on " + currentMonster.getName());
                        System.out.println(); // ny rad
                        if (currentMonster.getCurrentHP() < 1) { //om monstret dör
                            System.out.println("Monster is dead");

                            player1.setExp(currentMonster.getExpGainedByKillingMonster());
                            System.out.println("You got exp: " + currentMonster.getExpGainedByKillingMonster());
                            player1.increaseLevel();
                            restoreMonsterForReuse(currentMonster);
                            break;
                        }
                        System.out.println();
                        System.out.println(currentMonster.getName() + " attacks you");
                        currentMonster.attack(player1);
                        delayAttack(currentMonster.getName());

                        if (player1.getCurrentHP() <= 0) {
                            System.out.println("Your Hp is 0 after the attack"); //Sätter ett bottenvärde på 0.

                        } else {
                            System.out.println("Your Hp is " + player1.getCurrentHP() + " after the attack");
                        }

                        if (player1.getCurrentHP() < 1) {
                            System.out.println("You were killed by the monster");
                            Adventure = false;
                            break;
                        }
                        if (player1.getLevel() >= 10) {
                            System.out.println("You reached max-level, congratulations!");
                            Adventure = false;
                            System.exit(0);
                            break;
                        }
                    }
                    round++;
                }
            }
        } while (Adventure);


    } //Main



    public static void showMenu() {
        System.out.println("\n1. Go adventure");
        System.out.println("2. Show details");
        System.out.println("3. Exit Game.");
        System.out.print("\nChoice? ");
    }

    public static void fight(){
        System.out.println("Fight!");
    }

    public static void enterKey(){
        System.out.println("Press \"Enter\" to attack");
        sc.nextLine();
    }

    public static void delayAttack(String creature) {
        int randomHits = staticRandom.nextInt(5 ) + 1;
        System.out.print("Attacking");
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(200);
                System.out.print(".");
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    public static SpecificMonster randomMonster(ArrayList<SpecificMonster> arr, int round) {
        if (round >= arr.size())  {
            int randomIndex = staticRandom.nextInt(arr.size() - 1);
            System.out.println(randomIndex);
            return arr.get(randomIndex);
        } else {
            return arr.get(round);
        }
    }





    public static void welcomeToTheGame(){
        System.out.println("************************");
        System.out.println("* Welcome To The Game! *");
        System.out.println("************************");
        System.out.println("Enter your name:");
    }


    public static void menuChoices(){
        System.out.println("1. Go adventuring");
        System.out.println("2. Show details about your character");
        System.out.println("3. Exit game");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1. Go adventuring");
            case 2:
                System.out.println("2. Show details about your character");

            case 3:
                System.out.println("3. Exit game");
        }
    }

    public static void smallChanceNoFight (){
        Random random = new Random();
        int oneOutOfTen = random.nextInt(10);
        if(oneOutOfTen <= 0){
            System.out.println("No enemies in sight, keep walking soldier!");
        }
    }
    public static void restoreMonsterForReuse(SpecificMonster monster) {
        monster.setCurrentHP(monster.getMaxHP());
        System.out.println("Im coming back to hunt you player, see you soon!");
    }
}

