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
        return 0;
    }

    public int multiply(final int... values) {
        // shift by 2 for mult by 2
        return 0;
    }

    public int average(final int... values) {
        // average in stream
        return 0;
    }
}
