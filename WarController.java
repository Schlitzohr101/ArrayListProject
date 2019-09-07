
public class WarController {
    private Hand player1;
    private Hand player2;
    // private Deck deck1;
    // private Deck deck2;
    private boolean canPlay;
    private boolean inWar;

    /**
     * Default Constructor
     * Builds both the decks and hands for each of the players
     * Input: n/a
     * Output: deck1 and deck2 are shuffled and split, hands are ready
     */
    WarController() {
        player1 = new Hand("player 1");
        player1.shuffle();
        player2 = new Hand("player 2",player1.split());
        canPlay = false;
        inWar = false;
    }


    public void startGame() {
        System.out.println(
            "Welcome to WAR!"
        );
        canPlay = (player1.drawCard() && player2.drawCard());

        while (canPlay) {
            int val = compareHands(inWar);
            System.out.println(val);
            switch(val) {
                case 0 : beginWar();
                break;
                default: if (val > 0) {p1Wins();} else {p2Wins();} inWar = false;
                break;
            }
            if (!inWar){
                canPlay = (player1.drawCard() && player2.drawCard()) ;
            }
            
        }
        
    }

    /**
     * compareHands
     * compares the top card of each hand, with player 1 being the baseline
     * @return 0 if equal, >1 if greater than, <1 if less
     */
    public int compareHands(boolean inWar) {
        if(!inWar) {
            System.out.println(player1.display(0,inWar));
            System.out.println(player2.display(0,inWar));
        }
        return (!inWar ? player1.getTopCard().Compare(player2.getTopCard()) 
                        :player1.getCard(3).Compare(player2.getCard(2)) );
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
            inWar = true;
        }
        int i = 1;
        while (canPlay && i < 4) {
            canPlay = player1.drawCard();
            player1.getCard(i).flip();
            canPlay = player2.drawCard();
            player2.getCard(i).flip();
            if (i == 3) {
                player1.getCard(i).flip();
                player2.getCard(i).flip();
            }
            System.out.println(player1.display(i,inWar));
            System.out.println(player2.display(i,inWar));
            i++;
        }
    }

    public void p1Wins() {
        System.out.println("Player 1 wins the round");
        //We need to handle if player one wins
        //in this case we take all the cards out of the hand of 
        //player 2 and put them into the deck of player one at the end
        //NOTE: need to check if each card is facedown before putting into
        //the new deck. as well as reseting the face down cards for player one
        player1.putInDeck();
        player2.handOver(player1);
    }

    public void p2Wins() {
        System.out.println("Player 2 wins the round");
        //vice versa 
        player2.putInDeck();
        player1.handOver(player2);
    }
}