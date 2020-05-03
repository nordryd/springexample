package com.nordryd.springexample;

import com.nordryd.springexample.factorydepinj.internal.injector.GreetingDependencyInjector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * Main class for the Factory Dependency Injection version of this app.
 * </p>
 * <p>
 * This incarnation uses the {@link GreetingDependencyInjector dependency factory} that we use now, passing a class
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
        final GreetingDependencyInjector depInjector = new GreetingDependencyInjector();
        SpringApplication.run(new Class[] { SpringExampleMain.class, depInjector.getController().getClass() }, args);
    }
}
