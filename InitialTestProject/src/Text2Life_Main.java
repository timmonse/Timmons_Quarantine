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
            deathnumber = random.nextInt(500);
            if (age > 50) {
                deathnumber = random.nextInt(1000);
                deathnumber++;
            }
        }
    }

    private static void deathChances() {

        if (deathnumber == 100) {
            Alive = false;
            System.out.println(" ☠ you are dead of cancer ☠ ");
        } else if (deathnumber == 200) {
            Alive = false;
            System.out.println(" ☠ you are dead of covid-19 ☠ ");
        } else if (deathnumber == 300) {
            Alive = false;
            System.out.println(" ☠ you are dead due to falling off a cliff ☠ ");
        } else if (deathnumber == 400) {
            Alive = false;
            System.out.println(" ☠ you are dead of an overdose ☠ ");
        } else if (deathnumber >=500 && deathnumber <=800 ) {
            Alive = false;
            System.out.println(" ☠ you are dead of old age ☠ ");
        } else {
            Alive = true;
        }
    }
}
