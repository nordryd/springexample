package com.nordryd.springexample.gameobjects;

import static com.nordryd.springexample.gameobjects.Card.Rank;
import static com.nordryd.springexample.gameobjects.Card.Suit;
import static java.lang.String.format;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.nordryd.springexample.gameobjects.Card.BattleResult;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

/**
 * <p>
 * Unit tests for {@link Card}.
 * </p>
 *
 * @author Nordryd
 */
public class CardTest
{
    @Rule
    public final ExpectedException thrown = ExpectedException.none();
    @Rule
    public final ErrorCollector multiAssert = new ErrorCollector();

    @Test
    public void testBuilder() {
        final Rank expectedRank = Rank.NINE;
        final Suit expectedSuit = Suit.SPADES;
        final Card card = Card.get(expectedRank).of(expectedSuit);
        multiAssert.checkThat(card.getRank(), is(expectedRank));
        multiAssert.checkThat(card.getRank(), is(expectedSuit));
    }

    @Test
    public void testBattle() {
        final Card expectedHigherCard = Card.get(Rank.KING).of(Suit.CLUBS);
        final Card expectedLowerCard = Card.get(Rank.QUEEN).of(Suit.SPADES);
        multiAssert.checkThat(getBattleString(expectedHigherCard, expectedLowerCard),
                expectedHigherCard.battle(expectedLowerCard), is(BattleResult.WIN));
        multiAssert.checkThat(getBattleString(expectedLowerCard, expectedHigherCard),
                expectedLowerCard.battle(expectedHigherCard), is(BattleResult.LOSE));
    }

    @Test
    public void testBattleSameRank() {
        final Card expectedHigherCard = Card.get(Rank.KING).of(Suit.HEARTS);
        final Card expectedLowerCard = Card.get(Rank.KING).of(Suit.DIAMONDS);
        multiAssert.checkThat(getBattleString(expectedHigherCard, expectedLowerCard),
                expectedHigherCard.battle(expectedLowerCard), is(BattleResult.WIN));
        multiAssert.checkThat(getBattleString(expectedLowerCard, expectedHigherCard),
                expectedLowerCard.battle(expectedHigherCard), is(BattleResult.LOSE));
    }

    @Test
    public void testBattleSameSuit() {
        final Card expectedHigherCard = Card.get(Rank.KING).of(Suit.SPADES);
        final Card expectedLowerCard = Card.get(Rank.QUEEN).of(Suit.SPADES);
        multiAssert.checkThat(getBattleString(expectedHigherCard, expectedLowerCard),
                expectedHigherCard.battle(expectedLowerCard), is(BattleResult.WIN));
        multiAssert.checkThat(getBattleString(expectedLowerCard, expectedHigherCard),
                expectedLowerCard.battle(expectedHigherCard), is(BattleResult.LOSE));
    }

    @Test
    public void testBattleAcesHigh() {
        final Card expectedHigherCard = Card.get(Rank.ACE).of(Suit.CLUBS);
        final Card expectedLowerCard = Card.get(Rank.TWO).of(Suit.SPADES);
        multiAssert.checkThat(getBattleString(expectedHigherCard, expectedLowerCard),
                expectedHigherCard.battle(expectedLowerCard), is(BattleResult.WIN));
        multiAssert.checkThat(getBattleString(expectedLowerCard, expectedHigherCard),
                expectedLowerCard.battle(expectedHigherCard), is(BattleResult.LOSE));
    }

    @Test
    public void testBattleAcesHighOverloaded() {
        final Card expectedHigherCard = Card.get(Rank.ACE).of(Suit.CLUBS);
        final Card expectedLowerCard = Card.get(Rank.TWO).of(Suit.SPADES);
        multiAssert.checkThat(getBattleString(expectedHigherCard, expectedLowerCard),
                expectedHigherCard.battle(expectedLowerCard, true), is(BattleResult.WIN));
        multiAssert.checkThat(getBattleString(expectedLowerCard, expectedHigherCard),
                expectedLowerCard.battle(expectedHigherCard, true), is(BattleResult.LOSE));
    }

    @Test
    public void testBattleAcesLow() {
        final Card expectedHigherCard = Card.get(Rank.TWO).of(Suit.CLUBS);
        final Card expectedLowerCard = Card.get(Rank.ACE).of(Suit.SPADES);
        multiAssert.checkThat(getBattleString(expectedHigherCard, expectedLowerCard),
                expectedHigherCard.battle(expectedLowerCard, false), is(BattleResult.WIN));
        multiAssert.checkThat(getBattleString(expectedLowerCard, expectedHigherCard),
                expectedLowerCard.battle(expectedHigherCard, false), is(BattleResult.LOSE));
    }

    @Test
    public void testBattleAcesHighSameSuit() {
        final Card expectedHigherCard = Card.get(Rank.ACE).of(Suit.SPADES);
        final Card expectedLowerCard = Card.get(Rank.QUEEN).of(Suit.SPADES);
        multiAssert.checkThat(getBattleString(expectedHigherCard, expectedLowerCard),
                expectedHigherCard.battle(expectedLowerCard), is(BattleResult.WIN));
        multiAssert.checkThat(getBattleString(expectedLowerCard, expectedHigherCard),
                expectedLowerCard.battle(expectedHigherCard), is(BattleResult.LOSE));
    }

    @Test
    public void testBattleAcesHighSameSuitOverload() {
        final Card expectedHigherCard = Card.get(Rank.ACE).of(Suit.SPADES);
        final Card expectedLowerCard = Card.get(Rank.QUEEN).of(Suit.SPADES);
        multiAssert.checkThat(getBattleString(expectedHigherCard, expectedLowerCard),
                expectedHigherCard.battle(expectedLowerCard, true), is(BattleResult.WIN));
        multiAssert.checkThat(getBattleString(expectedLowerCard, expectedHigherCard),
                expectedLowerCard.battle(expectedHigherCard, true), is(BattleResult.LOSE));
    }

    @Test
    public void testBattleAcesLowSameSuit() {
        final Card expectedHigherCard = Card.get(Rank.TWO).of(Suit.CLUBS);
        final Card expectedLowerCard = Card.get(Rank.ACE).of(Suit.CLUBS);
        multiAssert.checkThat(getBattleString(expectedHigherCard, expectedLowerCard),
                expectedHigherCard.battle(expectedLowerCard, false), is(BattleResult.WIN));
        multiAssert.checkThat(getBattleString(expectedLowerCard, expectedHigherCard),
                expectedLowerCard.battle(expectedHigherCard, false), is(BattleResult.LOSE));
    }

    @Test
    public void testBattleTie() {
        final Card card = Card.get(Rank.EIGHT).of(Suit.CLUBS);
        assertThat(card.battle(card), is(BattleResult.TIE));
    }

    @Test
    public void testBattleTieAcesHigh() {
        final Card card = Card.get(Rank.ACE).of(Suit.HEARTS);
        assertThat(getBattleString(card, card), card.battle(card, true), is(BattleResult.TIE));
    }

    @Test
    public void testBattleTieAcesHighOverloaded() {
        final Card card = Card.get(Rank.ACE).of(Suit.HEARTS);
        assertThat(getBattleString(card, card), card.battle(card), is(BattleResult.TIE));
    }

    @Test
    public void testBattleTieAcesLow() {
        final Card card = Card.get(Rank.ACE).of(Suit.HEARTS);
        assertThat(getBattleString(card, card), card.battle(card, false), is(BattleResult.TIE));
    }

    @Test
    public void testToString() {
        assertThat(Card.get(Rank.JACK).of(Suit.HEARTS).toString(), is("JACK of HEARTS"));
    }

    @Test
    public void testEqualsAndHashCode() {
        final Card baseCard = Card.get(Rank.TWO).of(Suit.CLUBS);
        final Card cardSame = Card.get(Rank.TWO).of(Suit.CLUBS);
        final Card cardDiffRank = Card.get(Rank.THREE).of(Suit.CLUBS);
        final Card cardDiffSuit = Card.get(Rank.TWO).of(Suit.SPADES);
        final Card cardCompletelyDiff = Card.get(Rank.THREE).of(Suit.SPADES);
        multiAssert.checkThat(baseCard.equals(cardSame) && cardSame.equals(baseCard), is(true));
        multiAssert.checkThat(baseCard.hashCode() == cardSame.hashCode(), is(true));
        multiAssert.checkThat(baseCard.equals(cardDiffRank), is(false));
        multiAssert.checkThat(baseCard.equals(cardDiffSuit), is(false));
        multiAssert.checkThat(baseCard.equals(cardCompletelyDiff), is(false));
    }

    private static String getBattleString(final Card attacking, final Card defending) {
        return format("BATTLE[%s -> %s]", attacking, defending);
    }
}
