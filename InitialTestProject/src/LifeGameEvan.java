import java.util.Scanner;

public class LifeGameEvan {
    private static int playerAge = 0;
    private static String playerFirstName = "";
    private static String playerLastName = "";

    public static void main(String args[]) {
        displayStartArt();
        displayLine();
        startGame();
    }

    private static void startGame() {



        getNames();

        //Scanner for user input
        Scanner scan = new Scanner(System.in);

        //Get first and last name for user
        System.out.println("Please enter your first name: ");
        playerFirstName = scan.nextLine();
        while(!playerFirstName.matches("[A-Za-z0-9]+")){
            System.out.println("Please only enter alphanumeric characters: ");
            playerFirstName = scan.nextLine();
        }

        System.out.println("Please enter your last name: ");
        playerLastName = scan.nextLine();
        while(!playerLastName.matches("[A-Za-z0-9]+")){
            System.out.println("Please only enter alphanumeric characters: ");
            playerLastName = scan.nextLine();
        }

        //Create new human with the given parameters
        Human mainCharacter = new Human(playerAge, playerFirstName, playerLastName);

        //Ask user to confirm their name or restart
        System.out.println("Your name is: " + playerFirstName +  " " + playerLastName + ". Really?.....");

        //If user does not say yes, have the name process repeat
        if(!askYes()){
            startGame();
        }

    }

    private static String[] getNames(boolean isRandom){
        System.out.println("Do you want a random name?");
        if(askYes()){
            
        }
    }

    private static boolean askYes(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Y/N");
        String yesOrNo = scan.nextLine();
        yesOrNo = yesOrNo.toLowerCase();
        while(!yesOrNo.equals("y") && !yesOrNo.equals("n")){
            System.out.println("Please enter \"Y\" or \"N\"");
            yesOrNo = scan.nextLine();
            yesOrNo= yesOrNo.toLowerCase();
        }
        if(yesOrNo.equals("y")){
            return true;
        }
        else return false;
    }

    private static void displayLine(){
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    private static void displayStartArt() {
        StringBuilder sb = new StringBuilder();

        sb.append(" /$$      /$$           /$$                                                     /$$                    \r\n");
        sb.append("| $$  /$ | $$          | $$                                                    | $$                    \r\n");
        sb.append("| $$ /$$$| $$  /$$$$$$ | $$  /$$$$$$$  /$$$$$$  /$$$$$$/$$$$   /$$$$$$        /$$$$$$    /$$$$$$       \r\n");
        sb.append("| $$/$$ $$ $$ /$$__  $$| $$ /$$_____/ /$$__  $$| $$_  $$_  $$ /$$__  $$      |_  $$_/   /$$__  $$      \r\n");
        sb.append("| $$$$_  $$$$| $$$$$$$$| $$| $$      | $$  \\ $$| $$ \\ $$ \\ $$| $$$$$$$$        | $$    | $$  \\ $$      \r\n");
        sb.append("| $$$/ \\  $$$| $$_____/| $$| $$      | $$  | $$| $$ | $$ | $$| $$_____/        | $$ /$$| $$  | $$      \r\n");
        sb.append("| $$/   \\  $$|  $$$$$$$| $$|  $$$$$$$|  $$$$$$/| $$ | $$ | $$|  $$$$$$$        |  $$$$/|  $$$$$$/      \r\n");
        sb.append("|__/     \\__/ \\_______/|__/ \\_______/ \\______/ |__/ |__/ |__/ \\_______/         \\___/   \\______/       \r\n");
        sb.append("                                                                                                       \r\n");
        sb.append("                                                                                                       \r\n");
        sb.append("                                                                                                       \r\n");
        sb.append(" /$$$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$$        /$$$$$$        /$$       /$$$$$$ /$$$$$$$$ /$$$$$$$$   \r\n");
        sb.append("|__  $$__/| $$_____/| $$  / $$|__  $$__/       /$$__  $$      | $$      |_  $$_/| $$_____/| $$_____/   \r\n");
        sb.append("   | $$   | $$      |  $$/ $$/   | $$         |__/  \\ $$      | $$        | $$  | $$      | $$         \r\n");
        sb.append("   | $$   | $$$$$    \\  $$$$/    | $$           /$$$$$$/      | $$        | $$  | $$$$$   | $$$$$      \r\n");
        sb.append("   | $$   | $$__/     >$$  $$    | $$          /$$____/       | $$        | $$  | $$__/   | $$__/      \r\n");
        sb.append("   | $$   | $$       /$$/\\  $$   | $$         | $$            | $$        | $$  | $$      | $$         \r\n");
        sb.append("   | $$   | $$$$$$$$| $$  \\ $$   | $$         | $$$$$$$$      | $$$$$$$$ /$$$$$$| $$      | $$$$$$$$   \r\n");
        sb.append("   |__/   |________/|__/  |__/   |__/         |________/      |________/|______/|__/      |________/ \r\n");


        System.out.println(sb);

    }

}
