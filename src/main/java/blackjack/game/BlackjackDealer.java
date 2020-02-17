package blackjack.game;

/**
 * <p>
 * Represents a dealer in a {@link BlackjackGame game of blackjack}.
 * </p>
 *
 * @author Nordryd
 */
public class BlackjackDealer extends BlackjackPlayer
{
    /**
     * Constructor.
     *
     * @param game the {@link BlackjackGame game} this player is participating in.
     */
    public BlackjackDealer(final BlackjackGame game) {
        super(game);
    }

    @Override
    protected void deal() {
        draw();
    }
}
