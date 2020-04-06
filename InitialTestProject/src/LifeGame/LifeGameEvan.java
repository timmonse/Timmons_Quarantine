package LifeGame;

import java.util.Scanner;

public class LifeGameEvan {
    private enum Command {
        empty, help, exit, getInfo, next, setSavings,
        getSavings, setInvestment, getInvestment,
         setRate, transferStoI, transferItoS
    }

    private static Human mainCharacter;

    public static void main(String args[]) {
        startGame();
        runGame();
    }

    private static void startGame() {
        displayStartArt();
        displayLine();
        getNames();
        initialAccountValue();
    }

    private static void runGame(){
        boolean exit = false;

        //Loop through user input until the user exits
        while(!exit){
            exit = getUserInput();
        }
    }

    private static void advanceYear() {
        mainCharacter.advanceAge();
        mainCharacter.investmentAccount.advanceYear();
        displayLine();
        if(mainCharacter.getAge() != 1){
            System.out.println("You are now: " + mainCharacter.getAge() + " years old.");
        }
        else{
            //Change to "1 year old" vs "1 years old"
            System.out.println("You are now: " + mainCharacter.getAge() + " year old.");
        }
        System.out.printf("Investment Account: $%.2f\n", mainCharacter.investmentAccount.getValue());
        System.out.printf("Savings Account: $%.2f\n", mainCharacter.savingsAccount.getValue());
        displayLine();

    }

    //TODO Debugging tool
    private static void setSavings(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a value: ");
        String valueString = scan.nextLine();
        float value = Integer.parseInt(valueString);
        mainCharacter.savingsAccount.setValue(value);
    }

    //TODO Debugging tool
    private static void setInvestment(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a value: ");
        String valueString = scan.nextLine();
        float value = Integer.parseInt(valueString);
        mainCharacter.investmentAccount.setValue(value);
    }

    //TODO Debugging tool
    private static void setRate(){
        System.out.println("Please enter a value: ");
        Scanner scan = new Scanner(System.in);
        String valueString = scan.nextLine();
        float floatValue = Float.parseFloat(valueString);
        mainCharacter.investmentAccount.setRate(floatValue);
    }

    //TODO
    private static void displayAccountValue(){
        displayLine();
        System.out.println("The value of your savings is: " + mainCharacter.savingsAccount.getValue());
        displayLine();
    }

    //TODO
    private static void initialAccountValue(){
        System.out.println("Please enter an initial account value: ");
        Scanner scan = new Scanner(System.in);
        int value = Integer.parseInt(scan.nextLine());
        mainCharacter.investmentAccount.changeValue(value);
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

    private static void transferStoI(){
        System.out.println("Please enter a value to transfer from savings to investment: ");
        Scanner scan = new Scanner(System.in);
        String amountString = scan.nextLine();
        float amount = Integer.parseInt(amountString);
        //Cant transfer negative amounts
        if(amount < 0){
            System.out.println("Transfer Failed: You can not transfer negative amounts (try transferItoS)");
            return;
        }
        else if(amount > mainCharacter.savingsAccount.getValue()){
            System.out.println("Transfer Failed: You can not transfer more than the value of your savings account.");
            return;
        }
        mainCharacter.investmentAccount.changeValue(amount);
        mainCharacter.savingsAccount.changeValue(amount * -1);
    }

    private static void transferItoS(){
        System.out.println("Please enter a value to transfer from investment to savings: ");
        Scanner scan = new Scanner(System.in);
        String amountString = scan.nextLine();
        float amount = Integer.parseInt(amountString);
        if(amount < 0){
            System.out.println("Transfer Failed: You can not transfer negative amounts (try transferStoI)");
            return;
        }
        else if(amount > mainCharacter.investmentAccount.getValue()){
            System.out.println("Transfer Failed: You can not transfer more than the value of your investment account.");
            return;
        }
        mainCharacter.savingsAccount.changeValue(amount);
        mainCharacter.investmentAccount.changeValue(amount * -1);
    }

    /**
     * Prompts user and executes actions based on given commands
     */
    private static boolean getUserInput() {
        boolean exit = false;
        Command command = Command.empty;
        String input;

        String valueString;
        int value;
        float floatValue;

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
                case("next"):
                    command = Command.next;
                    advanceYear();
                    break;
                case("help"):
                    //Same as showCommands for now
                    command = Command.help;
                    displayCommands();
                    break;
                case("setSavings"):
                    command = Command.setSavings;
                    setSavings();
                    break;
                case("setInvestment"):
                    command = Command.setInvestment;
                    setInvestment();
                    break;
                case("getSavings"):
                    command = Command.getSavings;
                    displayAccountValue();
                    break;
                case("getInvestment"):
                    command = Command.getInvestment;
                    displayAccountValue();
                    break;
                case("transferStoI"):
                    command = Command.transferStoI;
                    transferStoI();
                    break;
                case("transferItoS"):
                    command = Command.transferItoS;
                    transferItoS();
                    break;
                case("setRate"):
                    command = Command.setRate;
                    setRate();
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
        System.out.println("Savings Value: " + mainCharacter.savingsAccount.getValue());
        System.out.println("Investment Value: " + mainCharacter.investmentAccount.getValue());
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
            //This happens automatically when no inputs are passed into LifeGame.Human class
            mainCharacter = new Human();
        } else {
            //Scanner for user input
            Scanner scan = new Scanner(System.in);

            //Get first and last name for user
            System.out.println("Please enter your first name: ");
            String playerFirstName = scan.nextLine();
            while (!playerFirstName.matches("[A-Za-z0-9]+")) {
                System.out.println("Please only enter alphanumeric characters: ");
                playerFirstName = scan.nextLine();
            }

            System.out.println("Please enter your last name: ");
            String playerLastName = scan.nextLine();
            while (!playerLastName.matches("[A-Za-z0-9]+")) {
                System.out.println("Please only enter alphanumeric characters: ");
                playerLastName = scan.nextLine();
            }

            //Create new human with the given parameters
            mainCharacter = new Human(playerFirstName, playerLastName);
        }

        displayLine();

        //Ask user to confirm their name or restart
        System.out.println("Your name is: " + mainCharacter.getFirstName() + " " + mainCharacter.getLastName());
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
