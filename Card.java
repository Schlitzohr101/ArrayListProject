public class Card {

    private int rank;
    private EnumConverter.suits suit;
    private boolean faceup;

    /*
     * Default Constructor Creates a blank card Inputs: n/a Outputs: rank will be 0
     * and suit will be null
     */
    Card() {
        rank = 0;
        suit = null;
        faceup = true;
    }

    /*
     * Non - Default Constructor Creates a card based on the parameters Inputs: Req
     * -> ranker - int value of the rank of the card -> suit - String of the card's
     * suit Outputs: card is instantiated with the parameters values
     */
    Card(int ranker, String suiter) {
        rank = ranker;
        suit = EnumConverter.toSuit(suiter.charAt(0));
        faceup = true;
    }

    /**
     * setRank Inputs: @param rank the rank to set Output: rank is set for the card
     * object
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * getRank Inputs: n/a Outputs: the rank of the player as a int
     */
    public int getRank() {
        return rank;
    }

    /**
     * setSuit Inputs: @param suit the suit to set Output: sets the suit of the card
     * object
     */
    public void setSuit(String suit) {
        this.suit = EnumConverter.toSuit(suit.charAt(0));
    }

    /**
     * getSuit Inputs: n/a Outputs: suit of the card as an enum
     */
    public EnumConverter.suits getSuit() {
        return suit;
    }

    /**
     * isFaceup
     * returns boolean if the card is faceup
     * Input: n/a
     * Output: @return true if faceup and false if facedown
     */
    public boolean isFaceup() {
        return faceup;
    }

    /**
     * flip
     * takes the faceup or facedown card and flips
     * Input: n/a
     * Output: reverse of faceup or facedown
     */
    public void flip() {
        faceup = !faceup;
    }

    /**
     * Compare compares the rank of the param card to the one that calls
     * Input: @param diffCard Output: -1 for if callCard is lower, 0 if equal, and 1
     * for if higher
     */
    public int Compare(Card diffCard) {
        return (rank - diffCard.getRank());
    }

    /*
     * toString Converts card object to string Inputs: n/a Outputs: String of card
     * in format "Card is ____ of _____"
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("Card is ");
        switch (rank) {
            case 0: builder.append("NULL");
            break;
            case 1: builder.append("Ace");
            break;
            case 11: builder.append("Jack");
            break;
            case 12: builder.append("Queen");
            break;
            case 13: builder.append("King");
            break;
            default: builder.append(rank);
            break;
        }
        builder.append(" of " + (suit == null ? "null" : suit.toString()));
        
        return builder.toString();
    }
}