package com.nordryd.springexample.blackjack.game;

import static com.nordryd.springexample.gameobjects.Card.Rank;
import static com.nordryd.springexample.gameobjects.Card.Suit;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nordryd.springexample.gameobjects.Card;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * <p>
 * Unit tests for {@link BlackjackPlayer}.
 * </p>
 *
 * @author Nordryd
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class BlackjackPlayerTest
{
    private static final Card INIT_CARD = Card.get(Rank.NINE).of(Suit.HEARTS);

    @Mock
    private BlackjackGame mockGame;
    @Mock
    private BlackjackDeck mockDeck;

    private BlackjackPlayer player;

    @Before
    public void setup() {
        when(mockGame.getDeck()).thenReturn(mockDeck);
        setNextDraw(INIT_CARD);
        player = new BlackjackPlayer(mockGame);
    }

    @Test
    public void testCreatingPlayer() {
        assertThat(player.getHand(), is(asList(INIT_CARD, INIT_CARD)));
        assertThat(player.getPlayerState(), is(BlackjackPlayer.PlayerState.AWAITING_TURN));
        verify(mockDeck, times(2)).draw();
    }

    @Test
    public void testPlayerHitNoBust() {
        Card cardFromHit = Card.get(Rank.TWO).of(Suit.SPADES);
        setNextDraw(cardFromHit);
        player.hit();
        assertThat(player.getHand(), is(asList(INIT_CARD, INIT_CARD, cardFromHit)));
        assertThat(player.getPlayerState(), is(BlackjackPlayer.PlayerState.PLAYING_TURN));
        verify(mockDeck, times(3)).draw();
    }

    @Test
    public void testPlayerHitBust() {

    }

    @Test
    public void testPlayerHitThenStay() {

    }

    @Test
    public void testPlayerHitNoBustThenHitAndBust() {

    }

    private void setNextDraw(final Card card) {
        when(mockDeck.draw()).thenReturn(card);
    }
}
