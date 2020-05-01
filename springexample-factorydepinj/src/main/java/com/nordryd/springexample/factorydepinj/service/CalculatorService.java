package com.nordryd.springexample.factorydepinj.service;

import com.nordryd.springexample.factorydepinj.CalculatorMain;
import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;

/**
 * <p>
 * Service layer for the {@link CalculatorMain Calculator app}.
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
}
