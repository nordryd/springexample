package com.nordryd.springexample.colorcalculator.factory;

import com.nordryd.springexample.colorcalculator.agent.ColorCalculatorMathAgent;
import com.nordryd.springexample.colorcalculator.agent.ColorCalculatorRGBAgent;
import com.nordryd.springexample.colorcalculator.service.ColorCalculatorService;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * Dependency factory for the Color Calculator app. This will be what is replaced by Spring {@link Bean Beans}.
 * </p>
 */
public class ColorCalculatorDependencyFactory
{
    public ColorCalculatorMathAgent getAgent() {
        return new ColorCalculatorMathAgent(this);
    }

    public ColorCalculatorRGBAgent getRGBAgent() {
        return new ColorCalculatorRGBAgent(this);
    }
}
