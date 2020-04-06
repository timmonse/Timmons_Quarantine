import java.util.Scanner;

public class LifeGameEvan {
    private enum Command {
        empty, exit, getInfo, advanceYear, showCommands
    }

    private static int playerAge = 0;
    private static String playerFirstName = "";
    private static String playerLastName = "";
    private static Human mainCharacter;

    public static void main(String args[]) {
        startGame();
    }

    private static void startGame() {
        boolean exit = false;

        displayStartArt();
        displayLine();
        getNames();
        //Loop through user input until the user exits
        while(!exit){
            exit = getUserInput();
        }
    }

    private static void advanceYear() {
        mainCharacter.advanceAge();
    }

    /**
     * Used to show user the commands available
     */
    private static void displayCommands(){
        for (Command command : Command.values()) {
            if(command != Command.empty){
                System.out.println(command);
            }
        }
    }

    /**
     * Prompts user and executes actions based on given commands
     */
    private static boolean getUserInput() {
        boolean exit = false;
        Command command = Command.empty;
        String input;

        Scanner scan = new Scanner(System.in);
        System.out.print(">>");

        //Loop until a valid command is given
        while(command == Command.empty && !exit){
            input = scan.nextLine();
            switch (input){
                case("getInfo"):
                    command = Command.getInfo;
                    displayInfo();
                    break;
                case("advanceYear"):
                    command = Command.advanceYear;
                    advanceYear();
                    break;
                case("showCommands"):
                    command = Command.showCommands;
                    displayCommands();
                    break;
                case("exit"):
                    command = command.exit;
                    break;
                default:
                    command = Command.empty;
            }
            if(command == command.empty){
                System.out.println("\"" + input + "\" is not a valid input.");
                System.out.print(">>");
            }

        }
        //Return true if command is "exit"
        return (command == command.exit);
    }

    /**
     * Display current human info to console
     */
    private static void displayInfo() {
        displayLine();
        System.out.println("Name: " + mainCharacter.getFirstName() + " " + mainCharacter.getLastName());
        System.out.println("Age: " + mainCharacter.getAge());
        System.out.println("Life Stage: " + mainCharacter.getLifeStage());
        displayLine();
    }

    /**
     * Prompts user to create a name either randomly or custom
     * Creates a new human and assigns the name value
     */
    private static void getNames() {
        System.out.println("Do you want a random name?");
        if (askYes()) {
            //Create human with random first and last name
            //This happens automatically when no inputs are passed into Human class
            mainCharacter = new Human();
            playerFirstName = mainCharacter.getFirstName();
            playerLastName = mainCharacter.getLastName();
        } else {
            //Scanner for user input
            Scanner scan = new Scanner(System.in);

            //Get first and last name for user
            System.out.println("Please enter your first name: ");
            playerFirstName = scan.nextLine();
            while (!playerFirstName.matches("[A-Za-z0-9]+")) {
                System.out.println("Please only enter alphanumeric characters: ");
                playerFirstName = scan.nextLine();
            }

            System.out.println("Please enter your last name: ");
            playerLastName = scan.nextLine();
            while (!playerLastName.matches("[A-Za-z0-9]+")) {
                System.out.println("Please only enter alphanumeric characters: ");
                playerLastName = scan.nextLine();
            }

            //Create new human with the given parameters
            mainCharacter = new Human(playerAge, playerFirstName, playerLastName);
        }

        displayLine();

        //Ask user to confirm their name or restart
        System.out.println("Your name is: " + playerFirstName + " " + playerLastName);
        System.out.println("Would you like to change it?");

        //If user says yes, have the name process repeat
        if (askYes()) {
            getNames();
        }
    }

    /**
     * Requests yes or no from user
     *
     * @return True for yes and false for no
     */
    private static boolean askYes() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Y/N");
        String yesOrNo = scan.nextLine();
        yesOrNo = yesOrNo.toLowerCase();
        while (!yesOrNo.equals("y") && !yesOrNo.equals("n")) {
            System.out.println("Please enter \"Y\" or \"N\"");
            yesOrNo = scan.nextLine();
            yesOrNo = yesOrNo.toLowerCase();
        }
        if (yesOrNo.equals("y")) {
            return true;
        } else return false;
    }

    /**
     * Displays a simple line to split up output
     */
    private static void displayLine() {
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    /**
     * Displays a starting graphic to user
     */
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
