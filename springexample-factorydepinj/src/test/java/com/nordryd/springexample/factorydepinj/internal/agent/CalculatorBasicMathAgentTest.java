package com.nordryd.springexample.factorydepinj.internal.agent;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;
import javafx.util.Pair;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
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
    @Mock
    private CalculatorDependencyInjector mockDepInjector;

    // InjectMocks will be used when shit is autowired
    private CalculatorBasicMathAgent agent = new CalculatorBasicMathAgent(mockDepInjector);

    @ParameterizedTest
    @MethodSource("getAddTests")
    public void testAdd(final List<Integer> operands, final int expectedSum) {
        assertEquals(expectedSum, agent.add(operands.stream().mapToInt(Integer::intValue).toArray()));
    }

    @ParameterizedTest
    @MethodSource("getAddTests")
    public void testSubtract(final Pair<List<Integer>, Integer> operandsAndExpectedResult) {
        assertEquals(operandsAndExpectedResult.getValue().intValue(),
                agent.subtract(operandsAndExpectedResult.getKey().stream().mapToInt(Integer::intValue).toArray()));
    }

    @ParameterizedTest
    @MethodSource("getAddTests")
    public void testMultiply(final Pair<List<Integer>, Integer> operandsAndExpectedResult) {
        assertEquals(operandsAndExpectedResult.getValue().intValue(),
                agent.multiply(operandsAndExpectedResult.getKey().stream().mapToInt(Integer::intValue).toArray()));
    }

    private static Stream<Arguments> getAddTests() {
        return Stream.of(Arguments.of(asList(2), 2), Arguments.of(asList(2, 2), 4), Arguments.of(asList(2, -2), 0),
                Arguments.of(asList(2, 2, -2), 2), Arguments.of(asList(-2, 2), 0), Arguments.of(asList(2, -2, -2), -2),
                Arguments.of(asList(-2, -2, 2), -2));
    }
}
