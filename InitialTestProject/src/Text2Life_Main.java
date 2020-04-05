import java.util.Random;
import java.util.Scanner;

public class Text2Life_Main {
    private static int age = 0;
    private static Random random = new Random();
    private static boolean Alive = true;
    private static int deathnumber = 0;
    private static int deathMath = 0;
    private static int loopz = 0;
    private static boolean x = true;
    private static int sickstuntz = 0;
    private static int cancer = 0;
    private static int overdose = 0;
    private static int old = 0;
    private static int cliff = 0;

    public static void main(String args[]) {
        while (loopz <= 70000000) {
            age = 0;
            Alive = true;
            //startGame();
            mainGame();
        }
        System.out.println("Cancer " + cancer);
        System.out.println("Overdose " + overdose);
        System.out.println("Sick stuntz " + sickstuntz);
        System.out.println("Falling off cliff " + cliff);
        System.out.println("Old age " + old);
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
        String input = "dude";
        //Scanner checkEnter = new Scanner(System.in);
        //input = checkEnter.nextLine();
        //if (input.equals("")) {
            age++;
            //System.out.println("you are " + age + " years old");
            deathnumber = random.nextInt(1000);
            deathnumber++;
            if (age <= 95) {
                deathMath = age;
            } else {
                deathMath = 95;
            }
        //}
    }

    private static void deathChances() {


        if (deathnumber == 100) {// && deathnumber <= 100.25) {
            Alive = false;
            //System.out.println(" ☠ you are dead of cancer ☠ ");
            loopz++;
            cancer++;
            //math to calc percent chance of specific death
            //System.out.println(((105 + deathMath) - (100 - deathMath)) / 1000.0 * 100 + "%");
        } else if (deathnumber == 200) {// && deathnumber <= 200.25) {
            Alive = false;
            //System.out.println(" ☠ you are dead of sick stuntz ☠ ");
            loopz++;
            //System.out.println(((205 + deathMath) - (200 - deathMath)) / 1000.0 * 100 + "%");
            sickstuntz++;
        } else if (deathnumber == 300) {// && deathnumber <= 300.25) {
            Alive = false;
            //System.out.println(" ☠ you are dead due to falling off a cliff ☠ ");
            loopz++;
            cliff++;
            //  System.out.println(((305 + deathMath) - (300 - deathMath)) / 1000.0 * 100 + "%");
        } else if (deathnumber == 400) {// && deathnumber <= 400.25) {
            Alive = false;
            //System.out.println(" ☠ you are dead of an overdose ☠ ");
            loopz++;
            overdose++;
            //System.out.println(((405 + deathMath) - (400 - deathMath)) / 1000.0 * 100 + "%");
        } else if (deathnumber >= 500 && deathnumber <= 530 + (age / 9.0) && age >= 90) {
            Alive = false;
            //System.out.println(" ☠ you are dead of old age ☠ ");
            loopz++;
            old++;
        } else {
            Alive = true;
        }
    }
}
