package blackjack.game;

import static blackjack.game.BlackjackDeck.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Represents a player in a {@link BlackjackGame game of blackjack}.
 * </p>
 *
 * @author Nordryd
 */
@Component
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
    @Autowired
    public BlackjackPlayer(final BlackjackGame game) {
        this.game = game;
        this.hand = new ArrayList<>();
        this.state = PlayerState.AWAITING_TURN;
        deal();
    }

    public void hit() {
        draw();
    }

    public void stay() {
        this.state = PlayerState.STAYING;
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

    private enum PlayerState
    {
        AWAITING_TURN,
        PLAYING_TURN,
        STAYING,
        BUSTED,
        BLACKJACK
    }
}
