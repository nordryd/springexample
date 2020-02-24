package com.nordryd.springexample.gameobjects.deck;

/**
 * <p>
 * Exceptions for everything involving {@link Deck} interactions.
 * </p>
 */
public class DeckException extends RuntimeException {

    /**
     * Constructor with message.
     *
     * @param message the message to display with the exception.
     */
    public DeckException(final String message) {
        super(message);
    }
}
