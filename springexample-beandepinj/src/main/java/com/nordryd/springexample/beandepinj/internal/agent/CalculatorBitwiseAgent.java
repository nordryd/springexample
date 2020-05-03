package com.nordryd.springexample.beandepinj.internal.agent;

import com.nordryd.springexample.beandepinj.internal.injector.CalculatorDependencyInjector;

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

    public int leftShift(final int value, final int places) {
        return value << places;
    }

    public int rightShift(final int value, final int places) {
        return value >> places;
    }
}
