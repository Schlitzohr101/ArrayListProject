/*  William Murray 
    August 27th, 2019
    Purpose: Program is designed play the card game war till a player wins
    Inputs: Req -> n/a
            Opt -> space to continue the game after a round has been played
    Output: Each of the cards played, round winner, and game winner
*/

public class ArrayListProject {
    public static void main(String[] args) {
        WarController War = new WarController();
        War.startGame();
    }
}