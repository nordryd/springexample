package blackjack.game;

import static blackjack.game.BlackjackDeck.Card.Rank;
import static blackjack.game.BlackjackDeck.Card.Suit;
import static java.lang.String.format;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * <p>
 * Represents a deck of {@link Card cards}.
 * </p>
 *
 * @author Nordryd
 */
@Component
public class BlackjackDeck
{
    private static final Random RNG = new Random();

    /**
     * @return a random {@link Card}.
     */
    public Card draw() {
        return new Card(Rank.getRandomRank(), Suit.getRandomSuit());
    }

    public static class Card
    {
        private final Rank rank;
        private final Suit suit;

        private Card(final Rank rank, final Suit suit) {
            this.rank = rank;
            this.suit = suit;
        }

        /**
         * @return this {@link Card card's} {@link Rank}.
         */
        public Rank getRank() {
            return rank;
        }

        /**
         * @return this {@link Card card's} {@link Suit}.
         */
        public Suit getSuit() {
            return suit;
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

            /**
             * @return the strength of the current {@link Rank}.
             */
            public int getStrength() {
                return strength;
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
}
