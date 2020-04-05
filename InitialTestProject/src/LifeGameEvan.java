import java.util.Scanner;

public class LifeGameEvan {
    private static int playerAge = 0;
    private static String playerName = "";

    public static void main(String args[]) {
        startGame();
    }

    private static void startGame() {
        displayStartArt();
        Scanner scan = new Scanner(System.in);
        Human mainCharacter = new Human(playerAge, playerName);

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
