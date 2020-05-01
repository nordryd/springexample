package com.nordryd.springexample.colorcalculator.agent;

import com.nordryd.springexample.colorcalculator.factory.ColorCalculatorDependencyFactory;

/**
 * <p>Gets RGB colors.</p>
 */
public class ColorCalculatorRGBAgent
{
    private final ColorCalculatorDependencyFactory depFactory;

    public ColorCalculatorRGBAgent(final ColorCalculatorDependencyFactory depFactory) {
        this.depFactory = depFactory;
    }
}
