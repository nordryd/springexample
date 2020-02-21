package com.nordryd.springexample.gameobjects.deck;

import com.nordryd.springexample.gameobjects.Card;

/**
 * <p>
 * Represents a standard deck of playing cards.
 * </p>
 *
 * @author Nordryd
 */
public interface Deck
{
    /**
     * @return a single {@link Card].
     */
    Card draw();
}
