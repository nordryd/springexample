package com.nordryd.springexample.factorydepinj.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.nordryd.springexample.factorydepinj.internal.agent.CalculatorBasicMathAgent;
import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <p>
 * Unit tests for {@link CalculatorService}.
 * </p>
 *
 * @author Nordryd
 */
@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest
{
    @Mock
    private CalculatorDependencyInjector mockDepInjector;
    @Mock
    private CalculatorBasicMathAgent mockBasicMathAgent;

    private CalculatorService service;

    @Nested
    public class BasicMathTest
    {
        @BeforeEach
        public void setup() {
            when(mockDepInjector.getMathAgent()).thenReturn(mockBasicMathAgent);
            service = new CalculatorService(mockDepInjector);
        }

        @Test
        public void testAdd() {
            final int expectedResult = 2;
            when(mockBasicMathAgent.add(anyInt())).thenReturn(expectedResult);
            assertEquals(expectedResult, service.add(2));
        }

        @Test
        public void testSubtract() {
            final int expectedResult = 2;
            when(mockBasicMathAgent.subtract(anyInt())).thenReturn(expectedResult);
            assertEquals(expectedResult, service.subtract(expectedResult));
        }

        @Test
        public void testMultiply() {
            final int expectedResult = 2;
            when(mockBasicMathAgent.multiply(anyInt())).thenReturn(expectedResult);
            assertEquals(expectedResult, service.multiply(expectedResult));
        }

        @Test
        public void testSquare() {
            final int expectedResult = 2;
            when(mockBasicMathAgent.square(anyInt())).thenReturn(expectedResult);
            assertEquals(expectedResult, service.square(expectedResult));
        }

        @Test
        public void testExponent() {
            final int expectedResult = 2;
            when(mockBasicMathAgent.exponent(anyInt(), anyInt())).thenReturn(expectedResult);
            assertEquals(expectedResult, service.exponent(expectedResult, expectedResult));
        }
    }

}
