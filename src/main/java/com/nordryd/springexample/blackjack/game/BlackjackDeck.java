package com.nordryd.springexample.blackjack.game;

import static com.nordryd.springexample.gameobjects.Card.Rank;
import static com.nordryd.springexample.gameobjects.Card.Suit;

import java.util.Random;

import com.nordryd.springexample.gameobjects.Card;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Represents a deck of {@link Card cards}.
 * </p>
 *
 * @author Nordryd
 */
@Component
public class BlackjackDeck
{
    private static final Random RNG = new Random();

    /**
     * @return a random {@link Card}.
     */
    public Card draw() {
        return Card.get(Rank.values()[RNG.nextInt(Rank.values().length)])
                .of(Suit.values()[RNG.nextInt(Suit.values().length)]);
    }
}
