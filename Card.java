public class Card {
    
    private EnumConverter.ranks rank;
    private EnumConverter.suits suit;

    /*
     * Default Constructor 
     * Creates a blank card
     * Inputs: n/a 
     * Outputs: rank will be 0 and suit will be null
     */
    Card() {
        rank = null;
        suit = null;
    }

    /*
     * Non - Default Constructor 
     * Creates a card based on the parameters
     * Inputs: Req -> ranker - int value of the rank of the card
     *             -> suit - String of the card's suit
     * Outputs: card is instantiated with the parameters values
     */
    Card(int ranker, String suiter) {
        rank = EnumConverter.toRank(ranker);
        suit = EnumConverter.toSuit(suiter.charAt(0));
    }

    /**
     * setRank
     * Inputs: @param rank the rank to set
     * Output: rank is set for the card object
     */
    public void setRank(int rank) {
        this.rank = EnumConverter.toRank(rank);
    }

    /**
     * setSuit
     * Inputs: @param suit the suit to set
     * Output: sets the suit of the card object
     */
    public void setSuit(String suit) {
        this.suit = EnumConverter.toSuit(suit.charAt(0));
    }

    /*
     * toString 
     * Converts card object to string 
     * Inputs: n/a 
     * Outputs: String of card in format "Card is ____ of _____"
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Card is " + (rank == null ? "null" : rank.toString()) + " of " + (suit == null ? "null" : suit.toString()));
        return builder.toString();
    }
}