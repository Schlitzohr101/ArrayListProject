import java.util.ArrayList;
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
     * addToHand
     * adds the given card to the hand
     * @param cardToAdd
     * @return n/a
     */
    public void addToHand(Card cardToAdd) {
        hand.add(cardToAdd);
    }

    /**
     * getTopCard
     * see the top Card in the hand
     * Input: n/a
     * Output: @return Card on top
     */
    public Card getTopCard() {
        return hand.get(0);
    }

    public Card getCard(int num) {
        return hand.get(num);
    }

    /**
     * 
     */
    public void putInDeck() {
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
    public void handOver(Hand otherHand) {

        for (Card card : hand) {
            if (!card.isFaceup()) {
                card.flip();
            }
            otherHand.addCard(card);
        }

        while(hand.size() > 0) {
            hand.remove(0);
        }
        otherHand.putInDeck();
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
        builder.append((inWar ? "war card for " + name + " " : name + " plays "));
        //if card is facedown, dispaly only xx else display the top card in the hand
        builder.append( (getCard(num).isFaceup() ? getCard(num).toString() : "Card is xx") );
        return builder.toString();
        
    }
 }