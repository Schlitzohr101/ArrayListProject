/*  William Murray, Adrian Seth
    September 9th, 2019
    Purpose: Program is designed play the card game war till a player wins
*/
import java.util.ArrayList;
public class Hand extends Deck {
    private ArrayList<Card> hand;
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
     * Non-defualt Constructor
     * @param newName
     */
    Hand(String newName) {
        hand = new ArrayList<Card>();
        name = newName;
    }

    /**
     * Non-default Constructor
     * @param newName, @param newDeck
     * @return
     */
    Hand(String newName, ArrayList<Card> newDeck) {
        super(newDeck);
        name = newName;
        hand = new ArrayList<Card>();
        
    }

    /**
     * getName
     * sends string back of the name of the player
     * @param none
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * getHandSize
     * @param none
     * @return the size of hand
     */
    public int getHandSize() {
        return hand.size();
    }


    /**
     * drawCard
     * takes card given and puts into hand
     * @param deckCard
     * @return boolean of it the operation was a success
     */
    public boolean drawCard() {
        Card deckCard = super.removeCard();
        boolean hasCards = false;
        hasCards = deckCard != null; 
        if (hasCards) {
            hand.add(deckCard);
        }
        return hasCards;
    }

    /**
     * getCard
     * see the top Card in the hand
     * @param num index of card to be returned
     * @return Card at index
     */
    public Card getCard(int num) {
        return hand.get(num);
    }

    /**
     * putHandIneck
     * hand is added to deck, with each card that is flipped being flipped to faceup
     * @param n/a
     * @return n/a
     */
    public void putHandInDeck() {
        while(hand.size() > 0 ) {
            Card toAdd = hand.remove(0);
            if (!toAdd.isFaceup()) {
                toAdd.flip();
            }
            addCard(toAdd);
        }
    }

    /**
     * handOver
     * gives all the cards in the calling objects hand
     * @param otherHand
     * @return the otherHand will contain all this hands cards
     */
    public void handOverTo(Hand otherHand) {

        for (Card card : hand) {
            if (!card.isFaceup()) {
                card.flip();
            }
            otherHand.addCard(card);
        }

        while(hand.size() > 0) {
            hand.remove(0);
        }
        otherHand.putHandInDeck();
        otherHand.shuffle();
        shuffle();
    }

    /**
     * display
     * Handles the displaying of the cards in the hand
     * @param null
     * @return string of the Card to be displayed in either war or regular form
     */
    public String display(int num, boolean inWar) {
        StringBuilder builder = new StringBuilder();
        //depending on if in war, format changes
        builder.append((inWar ? "war card for " + name + " " : name + "\'s "));
        //if card is facedown, dispaly only xx else display the top card in the hand
        builder.append( (getCard(num).isFaceup() ? getCard(num).toString() : "Card is xx") );
        return builder.toString();
        
    }
 }