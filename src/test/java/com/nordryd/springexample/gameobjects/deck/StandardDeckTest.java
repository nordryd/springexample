package com.nordryd.springexample.gameobjects.deck;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * <p>
 * Unit tests for {@link StandardDeck}.
 * </p>
 *
 * @author Nordryd
 */
public class StandardDeckTest {
    private static final int STD_DECK_SIZE = 52;

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testConstructor() {
        assertThat(new StandardDeck().remainingCards(), is(STD_DECK_SIZE));
    }

    @Test
    public void testDrawSingle() {
        final Deck deck = new StandardDeck();
        deck.draw();
        assertThat(deck.remainingCards(), is(STD_DECK_SIZE - 1));
    }

    @Test
    public void testDrawSingleUsingArgOverload() {
        final Deck deck = new StandardDeck();
        assertThat(deck.draw(1).size(), is(1));
        assertThat(deck.remainingCards(), is(STD_DECK_SIZE - 1));
    }

    @Test
    public void testDrawMultiple() {
        final Deck deck = new StandardDeck();
        final int wantedCards = 5;
        assertThat(deck.draw(wantedCards).size(), is(wantedCards));
        assertThat(deck.remainingCards(), is(STD_DECK_SIZE - wantedCards));
    }

    @Test
    public void testDrawMultipleOverdrawLooparound() {
        final Deck deck = new StandardDeck(true);
        final int wantedCards = 5;
        final int initialRemaining = 4;
        final int expectedNetRemaining = 51;
        deck.draw(STD_DECK_SIZE - initialRemaining);
        assertThat(deck.remainingCards(), is(initialRemaining));
        assertThat(deck.draw(wantedCards).size(), is(wantedCards));
        assertThat(deck.remainingCards(), is(expectedNetRemaining));
    }

    @Test
    public void testDrawMultipleOverdrawNoLooparound() {
        thrown.expect(DeckException.class);
        thrown.expectMessage("5 cards were requested, but only 4 remain. Use reset() to reset the deck.");
        final Deck deck = new StandardDeck(false);
        final int wantedCards = 5;
        final int initialRemaining = 4;
        deck.draw(STD_DECK_SIZE - initialRemaining);
        assertThat(deck.remainingCards(), is(initialRemaining));
        deck.draw(wantedCards);
    }

    @Test
    public void testDrawMultipleOverdrawNoLooparound1Left() {
        thrown.expect(DeckException.class);
        thrown.expectMessage("2 cards were requested, but only 1 remains. Use reset() to reset the deck.");
        final Deck deck = new StandardDeck(false);
        final int wantedCards = 2;
        final int initialRemaining = 1;
        deck.draw(STD_DECK_SIZE - 1);
        assertThat(deck.remainingCards(), is(initialRemaining));
        deck.draw(wantedCards);
    }

    @Test
    public void testDrawMultipleOver52Looparound() {
        final Deck deck = new StandardDeck(true);
        final int wantedCards = 53;
        final int expectedNetRemaining = 51;
        assertThat(deck.draw(wantedCards).size(), is(wantedCards));
        assertThat(deck.remainingCards(), is(expectedNetRemaining));
    }

    @Test
    public void testDrawMultipleOver52NoLooparound() {
        thrown.expect(DeckException.class);
        thrown.expectMessage("53 cards were requested when there can be no more than 52.");
        new StandardDeck(false).draw(53);
    }

    @Test
    public void testDrawMultipleExactly52Looparound() {
        final Deck deck = new StandardDeck(true);
        assertThat(deck.draw(STD_DECK_SIZE).size(), is(STD_DECK_SIZE));
        assertThat(deck.remainingCards(), is(0));
    }

    @Test
    public void testDrawMultipleExactly52NoLooparound() {
        final Deck deck = new StandardDeck(true);
        assertThat(deck.draw(STD_DECK_SIZE).size(), is(STD_DECK_SIZE));
        assertThat(deck.remainingCards(), is(0));
    }

    @Test
    public void testDrawDeckIsEmpty() {
        thrown.expect(DeckException.class);
        thrown.expectMessage("There are no more cards to draw! Use reset() to reset the deck.");
        final Deck deck = new StandardDeck(false);
        deck.draw(STD_DECK_SIZE);
        deck.draw();
    }

    @Test
    public void testDrawMultipleDeckIsEmpty() {
        thrown.expect(DeckException.class);
        thrown.expectMessage("There are no more cards to draw! Use reset() to reset the deck.");
        final Deck deck = new StandardDeck(false);
        deck.draw(STD_DECK_SIZE);
        deck.draw(2);
    }

    @Test
    public void testDrawMultipleZero() {
        thrown.expect(DeckException.class);
        thrown.expectMessage("Cannot draw 0 cards.");
        final Deck deck = new StandardDeck();
        deck.draw(0);
    }

    @Test
    public void testDrawMultipleNegative() {
        thrown.expect(DeckException.class);
        thrown.expectMessage("Cannot draw a negative number of cards.");
        final Deck deck = new StandardDeck();
        deck.draw(-1);
    }
}
