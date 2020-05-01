package com.nordryd.springexample.factorydepinj;

import com.nordryd.springexample.factorydepinj.controller.CalculatorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * Application that calculates various calculations that must be calculatingly calculated in a calculated manner.
 * </p>
 *
 * @author Nordryd
 */
@SpringBootApplication
public class CalculatorMain
{
    /**
     * Main method.
     *
     * @param args command line arguments.
     */
    public static void main(final String... args) {
        SpringApplication.run(new Class[] { CalculatorMain.class, CalculatorController.class }, args);
    }
}
