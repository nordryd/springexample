package com.nordryd.springexample.config;

import com.nordryd.springexample.blackjack.game.BlackjackPlayer;
import com.nordryd.springexample.gameobjects.deck.Deck;
import com.nordryd.springexample.gameobjects.deck.SimpleDeck;
import com.nordryd.springexample.gameobjects.deck.StandardDeck;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * Config for the blackjack game service.
 * </p>
 *
 * @author Nordryd
 */
@Configuration
@EnableAutoConfiguration
public class AppConfig
{
    @Bean
    public Deck simpleDeck() {
        return new SimpleDeck();
    }

    @Bean
    public Deck standardDeck() {
        return new StandardDeck();
    }
}
