package com.nordryd.springexample;

import com.nordryd.springexample.blackjack.config.BlackjackConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * Root application class for {@code springexample}.
 * </p>
 *
 * @author Nordryd
 */
@SpringBootApplication
public class SpringExampleMain
{
    /**
     * Main method.
     *
     * @param args command line arguments.
     */
    public static void main(final String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BlackjackConfig.class);
        SpringApplication.run(SpringExampleMain.class, args);
    }
}
