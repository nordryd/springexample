package com.nordryd.springexample.factorydepinj;

import com.nordryd.springexample.factorydepinj.controller.CalculatorController;
import org.springframework.boot.SpringApplication;

/**
 * <p>
 * Application that calculates various calculations that must be calculatingly calculated in a calculated manner.
 * </p>
 *
 * @author Nordryd
 */
public class CalculatorMain
{
    /**
     * Main method.
     *
     * @param args command line arguments.
     */
    public static void main(final String... args) {
        SpringApplication.run(CalculatorController.class, args);
    }
}
