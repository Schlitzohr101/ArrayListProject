
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
        resetController();
    }


    public void startGame() {
        System.out.println(
            "Welcome to WAR!"
        );
        canPlay = (player1.drawCard() && player2.drawCard());

        while (canPlay) {
            int val = compareHands(inWar);
            //System.out.println(val);
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
        if (player1.getSize() > 0) {
            System.out.println(player1.getName()+" wins the game!");
        } else {
            System.out.println(player2.getName()+" wins the game!");
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
        int printer = (!inWar ? 0 : player1.hand.size()-1);
        return player1.getCard(printer).Compare(player2.getCard(printer));
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
        int strSize = player1.hand.size();
        int i = 0;
        canPlay = player1.drawCard() && player2.drawCard();
        while (canPlay && i < 3) {
            if (i != 2) {
                player1.getCard(i + strSize ).flip();
                player2.getCard(i + strSize ).flip();
            }
            System.out.println(player1.display(i + strSize,inWar));
            System.out.println(player2.display(i + strSize,inWar));

            if (i != 2) {
                canPlay = player1.drawCard() && player2.drawCard();
            }
            i++;
        }
    }

    /**
     * p1Wins
     * player1 puts all cards in hand into deck 
     * player2 hands over all cards in hand
     * @param n/a
     * @return n/a
     */
    public void p1Wins() {
        System.out.println(player1.getName() + " wins the " +(inWar ? "War" : "round"));
        player1.putInDeck();
        player2.handOver(player1);
    }

    /**
     * p2Wins
     * player2 puts all cards in hand into deck 
     * player1 hands over all cards in hand
     * @param n/a
     * @return n/a
     */
    public void p2Wins() {
        System.out.println(player2.getName() + " wins the " +(inWar ? "War" : "round") );
        //vice versa 
        player2.putInDeck();
        player1.handOver(player2);
    }

    public void resetController() {
        player1 = new Hand("player 1");
        player1.shuffle();
        player2 = new Hand("player 2",player1.split());
        canPlay = false;
        inWar = false;
    }
}