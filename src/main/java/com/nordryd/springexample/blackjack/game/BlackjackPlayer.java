package com.nordryd.springexample.blackjack.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.nordryd.springexample.gameobjects.Card;

/**
 * <p>
 * Represents a player in a {@link BlackjackGame game of blackjack}.
 * </p>
 *
 * @author Nordryd
 */
public class BlackjackPlayer
{
    private static final int BLACKJACK_NO = 21;

    protected final BlackjackGame game;
    protected final List<Card> hand;
    private PlayerState state;

    /**
     * Constructor.
     *
     * @param game the {@link BlackjackGame game} this player is participating in.
     */
    public BlackjackPlayer(final BlackjackGame game) {
        this.game = game;
        this.hand = new ArrayList<>();
        this.state = PlayerState.AWAITING_TURN;
        deal();
    }

    /**
     * Draw a card for this {@link BlackjackPlayer player}.
     */
    public void hit() {
        if (state != PlayerState.PLAYING_TURN) {
            state = PlayerState.PLAYING_TURN;
        }
        draw();
    }

    /**
     * Mark this {@link BlackjackPlayer player} as being finished with their turn.
     */
    public void stay() {
        this.state = PlayerState.STAYING;
    }

    /**
     * @return the {@link BlackjackPlayer player's} current {@link PlayerState game state}.
     */
    public PlayerState getPlayerState() {
        return state;
    }

    /**
     * @return the {@link BlackjackPlayer player's} current hand. Will be immutable.
     */
    public List<Card> getHand() {
        return Arrays.asList(hand.toArray(new Card[0]));
    }

    /**
     * Deal this player a hand.
     */
    protected void deal() {
        draw();
        draw();
    }

    /**
     * Draw a card for this player.
     */
    protected void draw() {
        hand.add(game.getDeck().draw());
        tick();
    }

    /**
     * Update this player's state.
     */
    private void tick() {
        int handValue = 0;
        final Iterator<Card> handIter = hand.iterator();
        while ((handValue < BLACKJACK_NO) && handIter.hasNext()) {
            handValue += handIter.next().getRank().getStrength();
        }

        if (handValue >= BLACKJACK_NO) {
            state = (handValue == BLACKJACK_NO) ? PlayerState.BLACKJACK : PlayerState.BUSTED;
        }
    }

    enum PlayerState
    {
        AWAITING_TURN,
        PLAYING_TURN,
        STAYING,
        BUSTED,
        BLACKJACK
    }
}
