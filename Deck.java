/*  William Murray, Adrian Seth
    September 9th, 2019
    Purpose: Program is designed play the card game war till a player wins
*/
import java.util.*;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    /*
     * Default Constructor 
     * Creates a full 52 card deck from Hearts to Spades 
     * Inputs: n/a 
     * Outputs: cards attribute will hold the new full deck
     */
    Deck() {
        String[] suits = { "H", "C", "D", "S" };
        for (String str : suits) {
            for (int i = 1; i < 14; i++) {
                cards.add(new Card(i, str));
            }
        }
    }

    /*
     * Non - Default Constructor 
     * Instantiates the Deck with the parameter list of cards
     * Inputs: req -> ArrayList<Card> newCards
     * Outputs: Deck attribute of cards is the same as the parameter list
     */
    Deck(ArrayList<Card> newCards) {
        cards = newCards;
    }

    /**
     * getSize
     * returns int of the deck size
     * Input: n/a
     * @return the size of the deck
     */
    public int getSize() {
        return cards.size();
    }

    /**
     *  addCard
     *  adds a new Card to the back of the deck
     *  @param newCard
     *  Output: newCard is in back of the deck
     */
    public void addCard(Card newCard) {
        cards.add(cards.size() ,newCard);
    }

    /**
     * removeCard
     * takes the top card from the hand
     * Inputs: n/a
     * @return the card that was removed;
     *          will return null if there are no cards in the hand
     */
    public Card removeCard() {
        return (cards.size() > 0 ? cards.remove(0) : null);
    }

    /**
     * showTopCard
     * gives a reference to the card on the top of the deck
     * Inputs: n/a
     * @return Card on top
     */
    public Card showTopCard() {
        return cards.get(0);
    }

    /**
     * shuffle
     * shuffles deck based on predetermined randomness of the Collections tool
     * Inputs: n/a
     * Outputs: n/a
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * split
     * divides the deck into half the original amount
     * Input: n/a
     * Output: @return half of the orginal deck
     */
    public ArrayList<Card> split() {
        ArrayList<Card> returner = new ArrayList<Card>(cards.subList(cards.size()/2, cards.size()));
        cards = new ArrayList<Card>(cards.subList(0, cards.size()/2));

        return returner;
    }

    /**
     * toString 
     * Converts the deck object into a string formated to
     * 5 cards in a row
     * Inputs: n/a
     * @return string of all Cards in Deck
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int fiveMax = 0;
        builder.append("Deck:\n");
        for (Card card : cards) {
            builder.append(card.toString()+", ");
            fiveMax++;
            if (fiveMax > 5) {
                builder.append("\n");
                fiveMax = 0;
            }
        }
        return builder.toString();
    }
}