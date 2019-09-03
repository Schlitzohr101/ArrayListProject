import java.util.*;

public class Hand extends Deck {
    public ArrayList<Card> hand;
    private String name;
    /**
     * Default Constructor
     * Builds the instance of the object
     * Inputs: n/a
     * Outputs: instance of Hand object
     */
    Hand() {
        hand = new ArrayList<Card>();
        name = "player";
    }

    /**
     * Non-default Constructor
     * @param deckCard
     * @return
     */
    Hand(String newName) {
        hand = new ArrayList<Card>();
        name = newName;
    }

    /**
     * drawCard
     * takes card given and puts into hand
     * Inputs: @param deckCard
     * Outputs: boolean of it the operation was a success
     */
    public boolean drawCard(Card deckCard) {
        boolean outOfCards = false;
        outOfCards = deckCard == null; 
        if (!outOfCards) {
            hand.add(deckCard);
        }
        return outOfCards;
    }

//     /**
//      * 
//      */
//     public String showCard(boolean facedown, boolean isWar) {
//         StringBuilder builder = new StringBuilder();
//         //depending on if in war, format changes
//         builder.append((isWar ? "war card for " + name + " " : name + " plays "));
//         //if card is facedown, dispaly only xx else display the top card in the hand
//         builder.append((facedown ? "Card is xx" : hand.get(0).toString()));
//         return builder.toString();
        
//     }
 }