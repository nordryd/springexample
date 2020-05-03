package com.nordryd.springexample.factorydepinj.internal.agent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * Unit tests for {@link CalculatorBitwiseAgent}.
 * </p>
 *
 * @author Nordryd
 */
public class CalculatorBitwiseAgentTest
{
    private final CalculatorBitwiseAgent agent = new CalculatorBitwiseAgent(new CalculatorDependencyInjector());

    @Test
    public void testLeftShift() {
        assertEquals(4, agent.leftShift(2, 1));
        assertEquals(8, agent.leftShift(2, 2));
    }

    @Test
    public void testRightShift() {
        assertEquals(0, agent.rightShift(1, 1));
        assertEquals(0, agent.rightShift(2, 2));
        assertEquals(0, agent.rightShift(0, 0));
    }
}
