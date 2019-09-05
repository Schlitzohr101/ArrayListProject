
public class WarController {
    private Hand player1;
    private Hand player2;
    private Deck deck1;
    private Deck deck2;
    private boolean gameOver;
    private boolean inWar;

    /**
     * Default Constructor
     * Builds both the decks and hands for each of the players
     * Input: n/a
     * Output: deck1 and deck2 are shuffled and split, hands are ready
     */
    WarController() {
        deck1 = new Deck();
        deck1.shuffle();
        deck1.shuffle();
        deck2 = new Deck(deck1.split());
        player1 = new Hand("player 1");
        player2 = new Hand("player 2");
        gameOver = false;
        inWar = false;
    }


    public void startGame() {
        System.out.println(
            "Welcome to WAR!"
        );
        gameOver = (player1.drawCard(deck1.removeCard()) && player2.drawCard(deck2.removeCard()));
        while (!gameOver) {
            int val = compareHands();
            switch(val) {
                case 0 : beginWar();
                break;
                default: if (val > 0) {p1Wins();} else {p2Wins();}
                break;
            }
        }
        
    }

    /**
     * compareHands
     * compares the top card of each hand, with player 1 being the baseline
     * @return 0 if equal, >1 if greater than, <1 if less
     */
    public int compareHands() {
        return player1.getTopCard().Compare(player2.getTopCard());
    }

    /**
     * beginWar
     * war mode logic, pulls 3 cards from each of the players decks
     * and flip the first 2
     * @param null
     * @return Players hands with the cards flipped except the last one for each player 
     */
    public void beginWar() {
        if (!inWar) {
            System.out.println("war");
        }
        int i = 0;
        while (!gameOver && i < 3) {
            gameOver = player1.drawCard(deck1.removeCard());
            player1.getTopCard().flip();
            System.out.println(player1.display());
            gameOver = player2.drawCard(deck2.removeCard());
            player2.getTopCard().flip();
            System.out.println(player1.display());
            if (i == 2) {
                player1.getTopCard().flip();
                player2.getTopCard().flip();
                System.out.println(player1.display());
                System.out.println(player2.display());
            }
        }
    }

    public void p1Wins() {
        //We need to handle if player one wins
        //in this case we take all the cards out of the hand of 
        //player 2 and put them into the deck of player one at the end
        //NOTE: need to check if each card is facedown before putting into
        //the new deck. as well as reseting the face down cards for player one
    }

    public void p2Wins() {
        //vice versa 
    }
}