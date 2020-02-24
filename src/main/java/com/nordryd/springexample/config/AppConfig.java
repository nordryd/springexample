package com.nordryd.springexample.config;

import java.util.Random;

import com.nordryd.springexample.gameobjects.deck.Deck;
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
    public Deck deck() {
        return new StandardDeck(rng());
    }

    @Bean
    public Random rng() {
        return new Random();
    }
}
