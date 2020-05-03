package com.nordryd.springexample.beandepinj.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.nordryd.springexample.beandepinj.internal.agent.CalculatorBasicMathAgent;
import com.nordryd.springexample.beandepinj.internal.agent.CalculatorBitwiseAgent;
import com.nordryd.springexample.beandepinj.internal.injector.CalculatorDependencyInjector;
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

    private CalculatorService service;

    @Nested
    public class BasicMathTest
    {
        @Mock
        private CalculatorBasicMathAgent mockBasicMathAgent;

        @BeforeEach
        public void setup() {
            when(mockDepInjector.getMathAgent()).thenReturn(mockBasicMathAgent);
            service = new CalculatorService(mockDepInjector);
        }

        @Test
        public void testAdd() {
            final int expectedResult = 2;
            when(mockBasicMathAgent.add(anyInt())).thenReturn(expectedResult);
            assertEquals(expectedResult, service.add(expectedResult));
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

    @Nested
    public class BitwiseTest
    {
        @Mock
        private CalculatorBitwiseAgent mockBitwiseAgent;

        @BeforeEach
        public void setup() {
            when(mockDepInjector.getBitwiseAgent()).thenReturn(mockBitwiseAgent);
            service = new CalculatorService(mockDepInjector);
        }

        @Test
        public void testLeftShift() {
            final int expectedResult = 2;
            when(mockBitwiseAgent.leftShift(anyInt(), anyInt())).thenReturn(expectedResult);
            assertEquals(expectedResult, service.leftShift(expectedResult, expectedResult));
        }

        @Test
        public void testRightShift() {
            final int expectedResult = 2;
            when(mockBitwiseAgent.rightShift(anyInt(), anyInt())).thenReturn(expectedResult);
            assertEquals(expectedResult, service.rightShift(expectedResult, expectedResult));
        }
    }
}
