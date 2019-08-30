import java.util.*;

public class Hand extends Deck {
    public ArrayList<Card> hand;
    /**
     * Default Constructor
     * Builds the instance of the object
     * Inputs: n/a
     * Outputs: instance of Hand object
     */
    Hand() {
        hand = new ArrayList<Card>();
    }

    /**
     * drawCard
     * takes a card from its deck and puts it into its hand
     * Inputs: n/a
     * Outputs: hand contains the removed card from the deck
     */
    public void drawCard() {
        hand.add(removeCard());
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Hand\n");
        builder.append("this is the hand");
        return builder.toString();
        
    }
}