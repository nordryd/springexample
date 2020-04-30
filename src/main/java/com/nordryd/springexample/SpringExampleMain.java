package com.nordryd.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        SpringApplication.run(SpringExampleMain.class, args);
    }
}
