package com.nordryd.springexample.factorydepinj.internal.agent;

import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;

/**
 * <p>
 * Agent that does basic math calculations.
 * </p>
 *
 * @author Nordryd
 */
public class CalculatorBasicMathAgent
{
    private final CalculatorDependencyInjector depInjector;

    /**
     * Constructor.
     *
     * @param depInjector a {@link CalculatorDependencyInjector}.
     */
    public CalculatorBasicMathAgent(final CalculatorDependencyInjector depInjector) {
        this.depInjector = depInjector;
    }
}
