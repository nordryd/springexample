package com.nordryd.springexample.factorydepinj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import com.nordryd.springexample.SpringExampleMain;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * <p>
 * Integration tests for {@link CalculatorController the calculator app}.
 * </p>
 *
 * @author Nordryd
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringExampleMain.class)
@AutoConfigureMockMvc
public class CalculatorAppIntegrationTest
{
    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource(value = { "getBasicMathEndpointTests", "getBitwiseEndpointTests" })
    public void testEndpoints(final String endpoint, final HttpStatus expectedStatus, final String expectedResult)
            throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(endpoint)).andReturn()
                .getResponse();
        assertEquals(expectedStatus.value(), response.getStatus());
        assertEquals(expectedResult, response.getContentAsString());
    }

    private static Stream<Arguments> getBasicMathEndpointTests() {
        return Stream.of(Arguments.of("/vi/api/calc/add?values=3,2,1", HttpStatus.OK, "6"),
                Arguments.of("/vi/api/calc/add?values=-3,-2,-1", HttpStatus.OK, "-6"),
                Arguments.of("/vi/api/calc/subtract?values=3,2,1", HttpStatus.OK, "0"),
                Arguments.of("/vi/api/calc/subtract?values=-3,-2,-1", HttpStatus.OK, "0"),
                Arguments.of("/vi/api/calc/multiply?values=3,2,1", HttpStatus.OK, "6"),
                Arguments.of("/vi/api/calc/multiply?values=-3,-2,-1", HttpStatus.OK, "-6"),
                Arguments.of("/vi/api/calc/square?value=3", HttpStatus.OK, "9"),
                Arguments.of("/vi/api/calc/square?value=-3", HttpStatus.OK, "9"),
                Arguments.of("/vi/api/calc/exponent?value=3&exp=2", HttpStatus.OK, "9"),
                Arguments.of("/vi/api/calc/exponent?value=-3&exp=2", HttpStatus.OK, "9"));
    }

    private static Stream<Arguments> getBitwiseEndpointTests() {
        return Stream.of(Arguments.of("/vi/api/calc/leftshift?value=2", HttpStatus.OK, "4"),
                Arguments.of("/vi/api/calc/leftshift?value=2&shift=1", HttpStatus.OK, "4"),
                Arguments.of("/vi/api/calc/leftshift?value=2&shift=2", HttpStatus.OK, "8"),
                Arguments.of("/vi/api/calc/rightshift?value=8", HttpStatus.OK, "4"),
                Arguments.of("/vi/api/calc/rightshift?value=8&shift=1", HttpStatus.OK, "4"),
                Arguments.of("/vi/api/calc/rightshift?value=8&shift=2", HttpStatus.OK, "2"));
    }

    private static Stream<Arguments> getStatisticEndpointTests() {
        return Stream.of(Arguments.of("/vi/api/calc/leftshift?value=2", HttpStatus.OK, "4"),
                Arguments.of("/vi/api/calc/leftshift?value=2&shift=1", HttpStatus.OK, "4"),
                Arguments.of("/vi/api/calc/leftshift?value=2&shift=2", HttpStatus.OK, "8"),
                Arguments.of("/vi/api/calc/rightshift?value=8", HttpStatus.OK, "4"),
                Arguments.of("/vi/api/calc/rightshift?value=8&shift=1", HttpStatus.OK, "4"),
                Arguments.of("/vi/api/calc/rightshift?value=8&shift=2", HttpStatus.OK, "2"));
    }
}
