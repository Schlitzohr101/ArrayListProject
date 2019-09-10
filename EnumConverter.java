/*  William Murray, Adrian Seth
    September 9th, 2019
    Purpose: Program is designed play the card game war till a player wins
*/
public class EnumConverter {
    enum suits {CLUBS, DIAMONDS, SPADES, HEARTS;}

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