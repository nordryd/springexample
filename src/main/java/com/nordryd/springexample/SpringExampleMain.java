package com.nordryd.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
        final ApplicationContext config = new AnnotationConfigApplicationContext(Config.class);
        SpringApplication.run(SpringExampleMain.class, args);
    }

    /**
     * <p>
     * Stores manually created {@link Bean beans} and adds them to the factory to be injected elsewhere.
     * </p>
     */
    @Configuration
    @EnableAutoConfiguration
    @ComponentScan
    public static class Config
    {
        @Bean
        public String test() {
            return "If this printed out, it means the bean was successfully retrieved.";
        }
    }
}
