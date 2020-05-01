package com.nordryd.springexample.factorydepinj.internal.agent;

import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;

/**
 * <p>
 * Agent that does bitwise calculations.
 * </p>
 *
 * @author Nordryd
 */
public class CalculatorBitwiseAgent
{
    private final CalculatorDependencyInjector depInjector;

    /**
     * Constructor.
     *
     * @param depInjector a {@link CalculatorDependencyInjector}.
     */
    public CalculatorBitwiseAgent(final CalculatorDependencyInjector depInjector) {
        this.depInjector = depInjector;
    }
}
