
public class EnumConverter {
    enum ranks {ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING;}
    enum suits {CLUBS, DIAMONDS, SPADES, HEARTS;}

    /**
     * toRank
     * converts int to the enumerated ranks type
     * Inputs: @param num
     * Outputs: ranks enumerated equivalent of the int
     */

    public static ranks toRank(int num) {
            switch (num) {
                case 0: return ranks.ACE;
                case 1: return ranks.TWO;
                case 2: return ranks.THREE;
                case 3: return ranks.FOUR;
                case 4: return ranks.FIVE;
                case 5: return ranks.SIX;
                case 6: return ranks.SEVEN;
                case 7: return ranks.EIGHT;
                case 8: return ranks.NINE;
                case 9: return ranks.TEN;
                case 10: return ranks.JACK;
                case 11: return ranks.QUEEN;
                case 12: return ranks.KING;
                default: return null;
            }
    }

    /**
     * toSuits
     * converts a character to enum suits
     * Inputs: @param first
     * Outputs: suits enumerated equivelent of the charcter
     */
    public static suits toSuit(char first) {
        first = Character.toUpperCase(first);
        switch(first) {
            case 'H' : return suits.HEARTS;
            case 'D' : return suits.DIAMONDS;
            case 'S' : return suits.SPADES;
            case 'C' : return suits.CLUBS;
            default: return null;
        }
    }

}