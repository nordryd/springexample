package com.nordryd.springexample.beandepinj.internal.injector;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.beandepinj.internal.agent.CalculatorBasicMathAgent;
import com.nordryd.springexample.beandepinj.internal.agent.CalculatorBitwiseAgent;
import com.nordryd.springexample.beandepinj.service.CalculatorService;

/**
 * <p>
 * Dependency getters for the {@link SpringExampleMain Calculator app}. This facilitates dependency injection with just pure java (or the way things are currently done).
 * This would be replaced by either a Spring config, or by component annotations.
 * </p>
 *
 * @author Nordryd
 */
public class CalculatorDependencyInjector
{
    public CalculatorService getService() {
        return new CalculatorService(this);
    }

    public CalculatorBasicMathAgent getMathAgent() {
        return new CalculatorBasicMathAgent(this);
    }

    public CalculatorBitwiseAgent getBitwiseAgent() {
        return new CalculatorBitwiseAgent(this);
    }
}
