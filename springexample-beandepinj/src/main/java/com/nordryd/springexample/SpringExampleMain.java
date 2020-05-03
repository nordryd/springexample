package com.nordryd.springexample;

import com.nordryd.springexample.beandepinj.GreetingController;
import com.nordryd.springexample.beandepinj.config.GreetingConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * Main class for the Factory Dependency Injection version of this app.
 * </p>
 * <p>
 * This incarnation uses the {@link GreetingConfig dependency factory} that we use now, passing a class
 * around that contains the dependencies.
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
        final ApplicationContext config = new AnnotationConfigApplicationContext(GreetingConfig.class);
        SpringApplication.run(new Class[] { SpringExampleMain.class }, args);
    }
}
