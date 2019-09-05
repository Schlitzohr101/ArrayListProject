public class Hand extends Deck {
    // public ArrayList<Card> hand;
    private String name;
    /**
     * Default Constructor
     * Builds the instance of the object
     * Inputs: n/a
     * Outputs: instance of Hand object
     */
    Hand() {
        // hand = new ArrayList<Card>();
        name = "player";
    }

    /**
     * Non-default Constructor
     * @param deckCard
     * @return
     */
    Hand(String newName) {
        // hand = new ArrayList<Card>();
        name = newName;
    }

    /**
     * drawCard
     * takes card given and puts into hand
     * @param deckCard
     * @return boolean of it the operation was a success
     */
    public boolean drawCard(Card deckCard) {
        boolean hasCards = false;
        hasCards = deckCard != null; 
        if (!hasCards) {
            super.addCard(deckCard);
        }
        return hasCards;
    }

    /**
     * getTopCard
     * see the top Card in the hand
     * Input: n/a
     * Output: @return Card on top
     */
    public Card getTopCard() {
        return super.showTopCard();
    }


    /**
     * display
     * Handles the displaying of the cards in the hand
     * @param null
     * @return string of the Card to be displayed in either war or regular form
     */
    public String display() {
        StringBuilder builder = new StringBuilder();
        //depending on if in war, format changes
        builder.append((getTopCard().isFaceup() ? "war card for " + name + " " : name + " plays "));
        //if card is facedown, dispaly only xx else display the top card in the hand
        builder.append( (getTopCard().isFaceup() ? getTopCard().toString() : "Card is xx") );
        return builder.toString();
        
    }
 }