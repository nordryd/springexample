package blackjack;

import static java.lang.String.format;

import java.util.Random;

/**
 * <p>
 * Represents a single card for {@link BlackjackController blackjack}.
 * </p>
 *
 * @author Nordryd
 */
public final class Card
{
    private static final Random RNG = new Random();

    private final Rank rank;
    private final Suit suit;

    private Card(final Rank rank, final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * @return a random {@link Card card}.
     */
    public static Card draw() {
        return new Card(Rank.getRandomRank(), Suit.getRandomSuit());
    }

    @Override
    public String toString() {
        return format("%s of %ss", rank, suit);
    }

    /**
     * Represents a card rank.
     */
    public enum Rank
    {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10),
        ACE(11);

        private int strength;

        Rank(final int strength) {
            this.strength = strength;
        }

        @Override
        public String toString() {
            return name();
        }

        private static Rank getRandomRank() {
            return values()[RNG.nextInt(values().length)];
        }
    }

    /**
     * Represents a card suit.
     */
    public enum Suit
    {
        CLUB,
        DIAMOND,
        HEART,
        SPADE;

        private static Suit getRandomSuit() {
            return values()[RNG.nextInt(values().length)];
        }
    }
}
