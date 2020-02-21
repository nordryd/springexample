package com.nordryd.springexample.gameobjects.deck;

import static com.nordryd.springexample.gameobjects.Card.Rank;
import static com.nordryd.springexample.gameobjects.Card.Suit;
import static java.util.Arrays.asList;

import java.util.List;

import com.nordryd.springexample.gameobjects.Card;

/**
 * <p>
 * A standard 52-{@link Card card} {@link Deck}. This deck will cycle through all 52 cards at least one
 * </p>
 *
 * @author Nordryd
 */
public class StandardDeck implements Deck
{
    private static final List<Card> ALL_POSSIBLE_CARDS;

    // for just one of each, use a list and remove each time you draw a card, and reset when the list is empty
    // for multiple instances of each, use a map and decrement each time you pull from it
    @Override
    public Card draw() {
        return null;
    }

    static {
        //@formatter:off
        ALL_POSSIBLE_CARDS = asList(
            Card.get(Rank.TWO).of(Suit.CLUBS),
            Card.get(Rank.THREE).of(Suit.CLUBS),
            Card.get(Rank.FOUR).of(Suit.CLUBS),
            Card.get(Rank.FIVE).of(Suit.CLUBS),
            Card.get(Rank.SIX).of(Suit.CLUBS),
            Card.get(Rank.SEVEN).of(Suit.CLUBS),
            Card.get(Rank.EIGHT).of(Suit.CLUBS),
            Card.get(Rank.NINE).of(Suit.CLUBS),
            Card.get(Rank.TEN).of(Suit.CLUBS),
            Card.get(Rank.JACK).of(Suit.CLUBS),
            Card.get(Rank.QUEEN).of(Suit.CLUBS),
            Card.get(Rank.KING).of(Suit.CLUBS),
            Card.get(Rank.ACE).of(Suit.CLUBS),
            Card.get(Rank.TWO).of(Suit.HEARTS),
            Card.get(Rank.THREE).of(Suit.HEARTS),
            Card.get(Rank.FOUR).of(Suit.HEARTS),
            Card.get(Rank.FIVE).of(Suit.HEARTS),
            Card.get(Rank.SIX).of(Suit.HEARTS),
            Card.get(Rank.SEVEN).of(Suit.HEARTS),
            Card.get(Rank.EIGHT).of(Suit.HEARTS),
            Card.get(Rank.NINE).of(Suit.HEARTS),
            Card.get(Rank.TEN).of(Suit.HEARTS),
            Card.get(Rank.JACK).of(Suit.HEARTS),
            Card.get(Rank.QUEEN).of(Suit.HEARTS),
            Card.get(Rank.KING).of(Suit.HEARTS),
            Card.get(Rank.ACE).of(Suit.HEARTS),
            Card.get(Rank.TWO).of(Suit.DIAMONDS),
            Card.get(Rank.THREE).of(Suit.DIAMONDS),
            Card.get(Rank.FOUR).of(Suit.DIAMONDS),
            Card.get(Rank.FIVE).of(Suit.DIAMONDS),
            Card.get(Rank.SIX).of(Suit.DIAMONDS),
            Card.get(Rank.SEVEN).of(Suit.DIAMONDS),
            Card.get(Rank.EIGHT).of(Suit.DIAMONDS),
            Card.get(Rank.NINE).of(Suit.DIAMONDS),
            Card.get(Rank.TEN).of(Suit.DIAMONDS),
            Card.get(Rank.JACK).of(Suit.DIAMONDS),
            Card.get(Rank.QUEEN).of(Suit.DIAMONDS),
            Card.get(Rank.KING).of(Suit.DIAMONDS),
            Card.get(Rank.ACE).of(Suit.DIAMONDS),
            Card.get(Rank.TWO).of(Suit.SPADES),
            Card.get(Rank.THREE).of(Suit.SPADES),
            Card.get(Rank.FOUR).of(Suit.SPADES),
            Card.get(Rank.FIVE).of(Suit.SPADES),
            Card.get(Rank.SIX).of(Suit.SPADES),
            Card.get(Rank.SEVEN).of(Suit.SPADES),
            Card.get(Rank.EIGHT).of(Suit.SPADES),
            Card.get(Rank.NINE).of(Suit.SPADES),
            Card.get(Rank.TEN).of(Suit.SPADES),
            Card.get(Rank.JACK).of(Suit.SPADES),
            Card.get(Rank.QUEEN).of(Suit.SPADES),
            Card.get(Rank.KING).of(Suit.SPADES),
            Card.get(Rank.ACE).of(Suit.SPADES)
        );
        //@formatter:on
    }
}
