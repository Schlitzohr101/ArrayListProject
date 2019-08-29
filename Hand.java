import java.util.*;

public class Hand {
    List<Card> cards = new ArrayList<Card>();

    /*
     * Default Constructor 
     * Creates a full 52 card deck from Hearts to Spades 
     * Inputs: n/a 
     * Outputs: cards attribute will hold the new full deck
     */
    Hand() {
        String[] suits = { "Hearts", "Clubs", "Diamonds", "Spades" };
        for (String str : suits) {
            for (int i = 0; i < 13; i++) {
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
    Hand(ArrayList<Card> newCards) {
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
     */
    public Card removeCard() {
        return (cards.size() > 0 ? cards.remove(0) : null);
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
            if (tenMax > 4) {
                builder.append("\n");
                tenMax = 0;
            }
        }
        return builder.toString();
    }
}