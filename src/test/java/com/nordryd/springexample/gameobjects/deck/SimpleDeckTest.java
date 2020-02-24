package com.nordryd.springexample.gameobjects.deck;

import static com.nordryd.springexample.gameobjects.Card.Rank;
import static com.nordryd.springexample.gameobjects.Card.Suit;
import static java.util.Arrays.asList;
import static java.util.stream.IntStream.range;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.nordryd.springexample.gameobjects.Card;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * <p>
 * Unit tests for {@link SimpleDeck}.
 * </p>
 *
 * @author Nordryd
 */
public class SimpleDeckTest {
    private static final List<Rank> POSSIBLE_RANKS = asList(Rank.values());
    private static final List<Suit> POSSIBLE_SUITS = asList(Suit.values());
    private static final int STD_DECK_SIZE = 52;

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    public Deck deck;

    @Before
    public void setup() {
        deck = new SimpleDeck();
    }

    @Test
    public void testDraw() {
        final int testRuns = STD_DECK_SIZE * 5;
        range(0, testRuns).mapToObj(i -> deck.draw()).forEach(card -> {
            assertThat(isCardValid(card), is(true));
            assertThat(deck.remainingCards(), is(Integer.MAX_VALUE));
        });
    }

    @Test
    public void testDrawMultiple() {
        deck.draw(16).forEach(card -> assertThat(isCardValid(card), is(true)));
    }

    @Test
    public void testDrawMultipleZero() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot draw 0 cards.");
        deck.draw(0);
    }

    @Test
    public void testDrawMultipleNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot draw a negative number of cards.");
        deck.draw(-1);
    }

    private boolean isCardValid(final Card card) {
        return POSSIBLE_RANKS.contains(card.getRank()) && POSSIBLE_SUITS.contains(card.getSuit());
    }
}
