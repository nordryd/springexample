package com.nordryd.springexample.gameobjects.deck;

/**
 * <p>
 * A bigger collective {@link StandardDeck standard deck} that can be scaled at-will.
 * </p>
 */
public class BigStandardDeck {
    // for just one of each, use a list and remove each time you draw a card, and reset when the list is empty
    // for multiple instances of each, use a map and decrement each time you pull from it
    // maybe make a BigStandardDeck that's a composition of StandardDecks? randomly call each standard deck (have bool for auto reset)
}
