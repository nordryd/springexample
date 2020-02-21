package com.nordryd.springexample.gameobjects.deck;

import static com.nordryd.springexample.gameobjects.Card.Rank;
import static com.nordryd.springexample.gameobjects.Card.Suit;
import static com.nordryd.springexample.gameobjects.Card.get;

import java.util.Random;

import com.nordryd.springexample.gameobjects.Card;
import com.nordryd.springexample.gameobjects.deck.Deck;

/**
 * <p>
 * A {@link Deck} that has no smart way of how it draws. It just gives a random card of all possible 52.
 * </p>
 *
 * @author Nordryd
 */
public class SimpleDeck implements Deck
{
    private static final Random RNG = new Random();

    @Override
    public Card draw() {
        return get(Rank.values()[RNG.nextInt(Rank.values().length)])
                .of(Suit.values()[RNG.nextInt(Suit.values().length)]);
    }
}
