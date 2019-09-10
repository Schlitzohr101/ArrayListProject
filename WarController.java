/*  William Murray, Adrian Seth
    September 9th, 2019
    Purpose: Program is designed play the card game war till a player wins
*/
public class WarController {
    private Hand player1;
    private Hand player2;
    private boolean canPlay;
    private boolean inWar;

    /**
     * Default Constructor
     * Builds both the decks and hands for each of the players
     * default names are given to the players
     * Input: n/a
     * Output: deck1 and deck2 are shuffled and split, hands are ready
     */
    WarController() {
        resetController("player1","player2");
    }

    /**
     * Non - Default Constructor
     * Builds both the decks and hands for each of the players with parameter names
     * @param name1 name of the first player
     * @param name2 name of the second player
     * Output: deck1 and deck2 are shuffled and split, hands are ready
     */
    WarController(String name1, String name2) {
        resetController(name1, name2);
    }

    /**
     * startGame
     * Starts the logic for the game
     * Input: n/a
     * Output: n/a
     */
    public void startGame() {
        //each player draws a card form their deck
        canPlay = (player1.drawCard() && player2.drawCard());

        //canPlay is linked to players ability to draw cards
        //if a player can no longer draw cards then the game is over
        while (canPlay) {
            // we compare the int values of each card and put the difference in val
            int val = compareHands(inWar);
            //switch for if cards are equal or not
            //default case handles the not equal
            switch(val) {
                case 0 : beginWar();
                break;
                //if not equal then which player won?
                //greater than 0, player1 wins else its player two
                //reset inWar to be false
                default: if (val > 0) {p1Wins();} else {p2Wins();} inWar = false;
                break;
            }
            //draw card for the next round
            canPlay = (player1.drawCard() && player2.drawCard()) ;
        }
        //check to see who still has cards
        if (player1.getSize() > 0) {
            System.out.println(player2.getName() + " is out of Cards!");
            System.out.println(player1.getName()+" wins the game!");
        } else {
            System.out.println(player1.getName() + " is out of Cards!");
            System.out.println(player2.getName()+" wins the game!");
        }

    }

    /**
     * compareHands
     * compares the most recent card of each hand, with player 1 being the baseline
     * @param inWar boolean to determine print and compare index
     * @return 0 if equal, >1 if greater than, <1 if less
     */
    public int compareHands(boolean inWar) {
        //set printer to index of the card to be printer and compared
        int printer = (!inWar ? 0 : player1.getHandSize()-1);
        System.out.println(player1.display(printer,inWar));
        System.out.println(player2.display(printer,inWar));
        return player1.getCard(printer).Compare(player2.getCard(printer));
    }

    /**
     * beginWar
     * pull out 2 cards from each deck and flip to facedown
     * Input: n/a
     * Output: Players hands with the cards flipped 
     */
    public void beginWar() {
        //if a sequencial war, then don't reprint that we are in war
        if (!inWar) {
            System.out.println("war");
            inWar = true;
        }
        //array size is dynamic, so put current array size into strSize
        int strSize = player1.getHandSize();
        int i = 0;
        //draw cards for both players hand
        canPlay = player1.drawCard() && player2.drawCard();
        while (canPlay && i < 2) {
            //flip both players cards
            player1.getCard(i + strSize ).flip();
            player2.getCard(i + strSize ).flip();
            //print both players cards
            System.out.println(player1.display(i + strSize,inWar));
            System.out.println(player2.display(i + strSize,inWar));
            //draw more cards
            if (i < 2) {
                canPlay = player1.drawCard() && player2.drawCard();
            }
            i++;
        }
    }

    /**
     * p1Wins
     * player1 puts all cards in hand into deck 
     * player2 hands over all cards in hand
     * Input: n/a
     * Output: n/a
     */
    public void p1Wins() {
        System.out.println(player1.getName() + " wins the " +(inWar ? "War" : "round"));
        player1.putHandInDeck();
        player2.handOverTo(player1);
    }

    /**
     * p2Wins
     * player2 puts all cards in hand into deck 
     * player1 hands over all cards in hand
     * Input: n/a
     * Output: n/a
     */
    public void p2Wins() {
        System.out.println(player2.getName() + " wins the " +(inWar ? "War" : "round") );
        player2.putHandInDeck();
        player1.handOverTo(player2);
    }

    /**
     * resetController
     * resets all attributes of the controller to a new set
     * Input: n/a
     * Output: n/a
     */
    public void resetController(String name1, String name2) {
        player1 = new Hand(name1);
        player1.shuffle();
        player2 = new Hand(name2,player1.split());
        canPlay = false;
        inWar = false;
    }

    /**
     * toString
     * prints the current state of the war controller
     * Input: n/a
     * @return string of WarController state
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WarController state:\n");
        builder.append("Are both players able to play: " + canPlay);
        builder.append("Are players in war: "+ inWar);
        return builder.toString();
    }
}