import java.util.Random;
import java.util.Scanner;

public class Text2Life_Main {
    private static int age = 0;
    private static Random random = new Random();
    private static boolean Alive = true;
    private static int deathnumber = 0;

    public static void main(String args[]) {

        startGame();
        mainGame();
    }

    private static void startGame() {
        System.out.println("age " + age + ": You have been born");
    }

    private static void mainGame() {
        while (Alive == true) {
            everyYear();
            deathChances();
        }
    }

    private static void everyYear() {
        String test = "dude";
        Scanner checkEnter = new Scanner(System.in);
        test = checkEnter.nextLine();
        if (test.equals("")) {
            age++;
            System.out.println("you are " + age + " years old");
            deathnumber = random.nextInt(10);
        }
    }

    private static void deathChances() {

        if(deathnumber == 1) {
            Alive = false;
            System.out.println(" ☠ you are dead of cancer ☠ ");
        }
        else if(deathnumber == 2) {
            Alive = false;
            System.out.println(" ☠ you are dead of covid-19 ☠ ");
        }
        else if(deathnumber == 3) {
            Alive = false;
            System.out.println(" ☠ you are dead of old age ☠ ");
        }
        else if(deathnumber == 4) {
            Alive = false;
            System.out.println(" ☠ you are dead of an overdose ☠ ");
        }
        else if(deathnumber == 5) {
            Alive = false;
            System.out.println(" ☠ you are dead due to falling off a cliff ☠ ");
        }
        else {
            Alive = true;
        }
    }
}
