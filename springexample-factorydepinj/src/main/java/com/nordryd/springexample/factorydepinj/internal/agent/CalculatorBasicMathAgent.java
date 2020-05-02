package com.nordryd.springexample.factorydepinj.internal.agent;

import static java.util.Arrays.stream;

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

    public int add(final int... values) {
        return stream(values).sum();
    }

    public int subtract(final int... values) {
        return Integer.MAX_VALUE;
    }

    public int multiply(final int... values) {
        // shift by 2 for mult by 2
        return Integer.MAX_VALUE;
    }

    public int average(final int... values) {
        // average in stream
        return Integer.MAX_VALUE;
    }
}
