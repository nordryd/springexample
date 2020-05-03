package com.nordryd.springexample.factorydepinj.internal.agent;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <p>
 * Unit tests for {@link CalculatorBasicMathAgent}.
 * </p>
 *
 * @author Nordryd
 */
@ExtendWith(MockitoExtension.class)
public class CalculatorBasicMathAgentTest
{
    // InjectMocks will be used when shit is autowired (and the total autowiring will prevent the need to initialize it explicitly)
    private final CalculatorBasicMathAgent agent = new CalculatorBasicMathAgent(new CalculatorDependencyInjector());

    @ParameterizedTest
    @MethodSource("getAddTests")
    public void testAdd(final List<Integer> operands, final int expected) {
        assertEquals(expected, agent.add(operands.stream().mapToInt(Integer::intValue).toArray()));
    }

    @ParameterizedTest
    @MethodSource("getSubtractTests")
    public void testSubtract(final List<Integer> operands, final int expected) {
        assertEquals(expected, agent.subtract(operands.stream().mapToInt(Integer::intValue).toArray()));
    }

    @ParameterizedTest
    @MethodSource("getMultiplyTests")
    public void testMultiply(final List<Integer> operands, final int expected) {
        assertEquals(expected, agent.multiply(operands.stream().mapToInt(Integer::intValue).toArray()));
    }

    @ParameterizedTest
    @MethodSource("getSquareTests")
    public void testSquare(final int value, final int expected) {
        assertEquals(expected, agent.square(value));
    }

    @ParameterizedTest
    @MethodSource("getExponentTests")
    public void testExponent(final int value, final int exponent, final int expected) {
        assertEquals(expected, agent.exponent(value, exponent));
    }

    private static Stream<Arguments> getAddTests() {
        return Stream.of(Arguments.of(asList(2), 2), Arguments.of(asList(2, 2), 4), Arguments.of(asList(2, -2), 0),
                Arguments.of(asList(2, 2, -2), 2), Arguments.of(asList(-2, 2), 0), Arguments.of(asList(2, -2, -2), -2),
                Arguments.of(asList(-2, -2, 2), -2));
    }

    private static Stream<Arguments> getSubtractTests() {
        return Stream.of(Arguments.of(asList(2), 2), Arguments.of(asList(2, 2), 0), Arguments.of(asList(2, -2), 4),
                Arguments.of(asList(2, 2, -2), 2), Arguments.of(asList(-2, 2), -4), Arguments.of(asList(2, -2, -2), 6),
                Arguments.of(asList(-2, -2, 2), -2));
    }

    private static Stream<Arguments> getMultiplyTests() {
        return Stream.of(Arguments.of(asList(2), 2), Arguments.of(asList(2, 3), 6), Arguments.of(asList(2, -3), -6),
                Arguments.of(asList(2, 3, -2), -12), Arguments.of(asList(-2, 7, 3), -42),
                Arguments.of(asList(3, -2, 2), -12), Arguments.of(asList(-4, 2, -3), 24), Arguments.of(asList(2, 0), 0),
                Arguments.of(asList(0, 2), 0), Arguments.of(asList(0, 0), 0), Arguments.of(asList(0, -1), 0),
                Arguments.of(asList(1, 2), 2));
    }

    private static Stream<Arguments> getSquareTests() {
        return Stream.of(Arguments.of(2, 4), Arguments.of(1, 1), Arguments.of(0, 0), Arguments.of(-9, 81));
    }

    private static Stream<Arguments> getExponentTests() {
        return Stream.of(Arguments.of(2, 2, 4), Arguments.of(2, 1, 2), Arguments.of(2, 0, 0), Arguments.of(0, 4, 0));
    }
}
