/*  William Murray, Adrian Seth
    September 9th, 2019
    Purpose: Program is designed play the card game war till a player wins
    Inputs: Req -> n/a
    Output: Each of the cards played, round winner, and game winner
*/
import java.util.Scanner;

public class ArrayListProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(
            "Welcome to WAR!\nWould you like to use names? (Y/N): "
        );
        char reply = Character.toUpperCase(input.nextLine().charAt(0));
        switch (reply) {
            case 'Y': withNames(input);
                break;
        
            default: System.out.println("did it do this one?");
            withoutNames(input);
                break;
        }
        System.out.println("\nThanks for playing!");       
    }

    /**
     * withNames
     * method to start game with players names included
     * @param in Scanner to read in names and reply
     */
    public static void withNames(Scanner in) {
        System.out.print("\n\nPlayer 1: ");
        String player1 = in.nextLine();
        System.out.print("\n\nPlayer 2: ");
        String player2 = in.nextLine();
        System.out.println("\n");
        WarController War = new WarController(player1, player2);
        boolean wantToPlay = true;
        while(wantToPlay) {
            War.startGame();
            System.out.println("\n\nHard fought War!\nWould you like to fight again? (Y/N): ");
            char reply = Character.toUpperCase(in.nextLine().charAt(0));
            switch (reply) {
                case 'Y': 
                    War.resetController(player1, player2); 
                    War.startGame();
                break;
                default: wantToPlay = false; 
                break;
            }
        }
    }

    /**
     * withoutNames
     * method to start game with default player names
     * @param in Scanner to read in reply
     */
    public static void withoutNames(Scanner in) {
        WarController War = new WarController();
        boolean wantToPlay = true;
        while(wantToPlay) {
            War.startGame();
            System.out.println("\n\nHard fought War!\nWould you like to fight again? (Y/N): ");
            char reply = Character.toUpperCase(in.nextLine().charAt(0));
            switch (reply) {
                case 'Y': 
                    War.resetController("player1", "player2"); 
                    War.startGame();
                break;
                default: wantToPlay = false; 
                break;
            }
        }
    }
}