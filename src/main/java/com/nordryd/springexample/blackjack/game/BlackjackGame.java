package com.nordryd.springexample.blackjack.game;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Represents a single game of blackjack.
 * </p>
 *
 * @author Nordryd
 */
@Component
public class BlackjackGame implements ApplicationContextAware
{
    private ApplicationContext context;

    private final BlackjackDeck deck;
    private final BlackjackPlayer player, dealer;
    private GameState gameState;

    /**
     * Constructor.
     *
     * @param deck the {@link BlackjackDeck deck} to be used for this particular game.
     * @param player the {@link BlackjackPlayer player} for this particular game.
     * @param dealer the {@link BlackjackDealer dealer} for this particular game.
     */
    @Autowired
    public BlackjackGame(final BlackjackDeck deck, final BlackjackPlayer player, final BlackjackDealer dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
        this.gameState = GameState.PLAYER_TURN;
    }

    /**
     * @return the {@link BlackjackDeck deck} the current game is using.
     */
    public BlackjackDeck getDeck() {
        return deck;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    private enum GameState
    {
        // player has 21 but dealer REVEALS 21, dealer wins
        // player has 21 but dealer DRAWS 21, it's a tie
        PLAYER_TURN,
        DEALER_TURN,
        FINISHED;
    }
}
