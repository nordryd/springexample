package com.nordryd.springexample.blackjack.game;

import static java.util.Arrays.asList;
import static java.util.stream.IntStream.range;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.nordryd.springexample.gameobjects.Card;
import org.junit.Test;

/**
 * <p>
 * Unit tests for {@link BlackjackDeck}.
 * </p>
 *
 * @author Nordryd
 */
public class BlackjackDeckTest
{
    private static final List<Card.Rank> POSSIBLE_RANKS = asList(Card.Rank.values());
    private static final List<Card.Suit> POSSIBLE_SUITS = asList(Card.Suit.values());
    private static final int STD_DECK_SIZE = 52;

    private static final BlackjackDeck DECK = new BlackjackDeck();

    @Test
    public void testDraw() {
        final int testRuns = STD_DECK_SIZE * 5;
        range(0, testRuns).mapToObj(i -> DECK.draw()).forEach(testCard -> assertTrue(
                POSSIBLE_RANKS.contains(testCard.getRank()) && POSSIBLE_SUITS.contains(testCard.getSuit())));
    }
}
