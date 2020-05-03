package com.nordryd.springexample.beandepinj.internal.agent;

import static java.util.Arrays.stream;

import com.nordryd.springexample.beandepinj.internal.injector.CalculatorDependencyInjector;

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
        int difference = values[0];
        for (int i = 1; i < values.length; i++) {
            difference -= values[i];
        }
        return difference;
    }

    public int multiply(final int... values) {
        if (values[0] == 0) {
            return 0;
        }
        int product = values[0];
        for (int i = 1; i < values.length; i++) {
            int value = values[i];
            if (value == 0) {
                return 0;
            }
            product *= value;
        }
        return product;
    }

    public int square(final int value) {
        return exponent(value, 2);
    }

    public int exponent(final int value, final int exponent) {
        if ((value == 0) || (exponent == 0)) {
            return 0;
        }
        int product = value;
        for (int i = 1; i < exponent; i++) {
            product *= value;
        }
        return product;
    }
}
