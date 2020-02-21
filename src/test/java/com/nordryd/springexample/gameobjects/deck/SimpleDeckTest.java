package com.nordryd.springexample.gameobjects.deck;

import static com.nordryd.springexample.gameobjects.Card.Rank;
import static com.nordryd.springexample.gameobjects.Card.Suit;
import static java.util.Arrays.asList;
import static java.util.stream.IntStream.range;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * <p>
 * Unit tests for {@link SimpleDeck}.
 * </p>
 *
 * @author Nordryd
 */
public class SimpleDeckTest
{
    private static final List<Rank> POSSIBLE_RANKS = asList(Rank.values());
    private static final List<Suit> POSSIBLE_SUITS = asList(Suit.values());
    private static final int STD_DECK_SIZE = 52;

    private static final Deck DECK = new SimpleDeck();

    @Test
    public void testDraw() {
        final int testRuns = STD_DECK_SIZE * 5;
        range(0, testRuns).mapToObj(i -> DECK.draw()).forEach(testCard -> assertTrue(
                POSSIBLE_RANKS.contains(testCard.getRank()) && POSSIBLE_SUITS.contains(testCard.getSuit())));
    }
}
