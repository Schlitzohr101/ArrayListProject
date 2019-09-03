

public class WarController {
    private Hand player1;
    private Hand player2;
    private Deck deck1;
    private Deck deck2;

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
    }

    /**
     * 
     */
    public void startGame() {
        System.out.println(
            "Welcome to WAR!"
        );
        while ( //while each of decks can have a card removed
        player1.drawCard(deck1.removeCard()) && player2.drawCard(deck2.removeCard()) ) {
            
        }
        
    }
}