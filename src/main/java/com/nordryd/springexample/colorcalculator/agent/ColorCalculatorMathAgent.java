package com.nordryd.springexample.colorcalculator.agent;

import com.nordryd.springexample.colorcalculator.factory.ColorCalculatorDependencyFactory;

/**
 * Performs math calculations for adding color values together.
 */
public class ColorCalculatorMathAgent
{
    private final ColorCalculatorDependencyFactory depFactory;

    public ColorCalculatorMathAgent(final ColorCalculatorDependencyFactory depFactory) {
        this.depFactory = depFactory;
    }
}
