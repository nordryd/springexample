package com.nordryd.springexample.factorydepinj.service;

import com.nordryd.springexample.factorydepinj.SpringExampleMain;
import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;

/**
 * <p>
 * Service layer for the {@link SpringExampleMain Calculator app}.
 * </p>
 *
 * @author Nordryd
 */
public class CalculatorService
{
    private final CalculatorDependencyInjector depInjector;

    /**
     * Constructor.
     *
     * @param depInjector a {@link CalculatorDependencyInjector}.
     */
    public CalculatorService(final CalculatorDependencyInjector depInjector) {
        this.depInjector = depInjector;
    }

    public int add(final int... values) {
        return depInjector.getMathAgent().add(values);
    }

    public int subtract(final int... values) {
        return depInjector.getMathAgent().subtract(values);
    }

    public int multiply(final int... values) {
        // shift by 2 for mult by 2
        return depInjector.getMathAgent().multiply(values);
    }

    public int square(final int value) {
        return depInjector.getMathAgent().square(value);
    }

    public int exponent(final int value, final int exponent) {
        return depInjector.getMathAgent().exponent(value, exponent);
    }
}
