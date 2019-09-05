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
            for (int i = 1; i <= 13; i++) {
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

    /*
     *  addCard
     *  adds a new Card to the deck
     *  Inputs: @param newCard
     *  Outputs: Deck contains the Card @param newCard
     */
    public boolean addCard(Card newCard) {
        return cards.add(newCard);
    }

    /**
     * removeCard
     * takes the top card from the hand
     * Inputs: n/a
     * Outputs: @return the card that was removed
     *          will return null if there are no cards in the hand
     */
    public Card removeCard() {
        return (cards.size() > 0 ? cards.remove(0) : null);
    }

    /**
     * showTopCard
     * gives a reference to the card on the top of the deck
     * @param n/a
     * @return Card on top
     */
    public Card showTopCard() {
        return cards.get(0);
    }

    /**
     * shuffle
     * shuffles deck based on predetermined randomness
     * @param n/a
     * @return shuffled deck
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
        return new ArrayList<Card>(cards.subList(cards.size()/2, cards.size()));
    }

    /*
     * toString 
     * Converts the deck object into a string 
     * Inputs: n/a 
     * Outputs: displays all cards in rows of 10
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int tenMax = 0;
        builder.append("Deck:\n");
        for (Card card : cards) {
            builder.append(card.toString()+", ");
            tenMax++;
            if (tenMax > 5) {
                builder.append("\n");
                tenMax = 0;
            }
        }
        return builder.toString();
    }
}