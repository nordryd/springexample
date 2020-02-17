package blackjack.game;

/**
 * <p>
 * Represents a single game of blackjack.
 * </p>
 *
 * @author Nordryd
 */
public class BlackjackGame
{
    private final BlackjackDeck deck;
    private GameState gameState;

    public BlackjackGame() {
        this.deck = new BlackjackDeck();
        this.gameState = GameState.PLAYER_TURN;
    }

    /**
     * @return the {@link BlackjackDeck deck} the current game is using.
     */
    public BlackjackDeck getDeck() {
        return deck;
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
