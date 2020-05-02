package com.nordryd.springexample.factorydepinj;

import com.nordryd.springexample.factorydepinj.controller.CalculatorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * Main class for spring modules.
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
        SpringApplication.run(new Class[] { SpringExampleMain.class, CalculatorController.class }, args);
    }
}
