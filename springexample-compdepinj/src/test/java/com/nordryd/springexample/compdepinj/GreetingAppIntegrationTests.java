package com.nordryd.springexample.compdepinj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import com.nordryd.springexample.SpringExampleMain;
import javafx.util.Pair;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * <p>
 * Integration tests for {@link GreetingController the calculator app}. I'm not sure if using the MockMvc is sufficient
 * for assembly testing. Should investigate if the team likes this approach with beans.
 * </p>
 * <p>
 * If these tests pass, we know our endpoints work, though we can still do spring-boot:run to verify via Postman.
 * </p>
 * <p>
 * This feels simpler to me than how we do other integ tests, but Cucumber integration can come later if we agree that
 * Spring is the way to go (it works with Junit 4 and 5 all the same, so no worries there.
 * </p>
 * <a href=https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/>mock mvc deets</a>
 *
 * @author Nordryd
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringExampleMain.class)
@AutoConfigureMockMvc
public class GreetingAppIntegrationTests
{
    private static final boolean TESTING_NORMAL_ENDPOINT = true;

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource(value = { "getGreetingEndpointsTest" })
    public void testEndpoints(final String endpoint, final HttpStatus expectedStatus,
            final Pair<String, String> expectedResults) throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(endpoint)).andReturn()
                .getResponse();
        assertEquals(expectedStatus.value(), response.getStatus());
        assertEquals(TESTING_NORMAL_ENDPOINT ? expectedResults.getKey() : expectedResults.getValue(),
                response.getContentAsString());
    }

    private static Stream<Arguments> getGreetingEndpointsTest() {
        //@formatter:off
        return Stream.of(Arguments.of("/v1/api/greeting/helloWorld", HttpStatus.OK, getNormalAndUwuStrings("Hello, World!")),
                         Arguments.of("/v1/api/greeting/greet?who=comrades", HttpStatus.OK, getNormalAndUwuStrings("Greetings, comrades!")),
                         Arguments.of("/v1/api/greeting/sand", HttpStatus.OK, getNormalAndUwuStrings("I don't like sand... it's coarse, rough, and irritating... and it gets everywhere.")),
                         Arguments.of("/v1/api/greeting/number", HttpStatus.OK, new Pair<>("420360", "420360 uwu")),
                         Arguments.of("/v1/api/greeting/swiggity", HttpStatus.OK, getNormalAndUwuStrings("Wot? Swiggity Swooty?")),
                         Arguments.of("/v1/api/greeting/special", HttpStatus.OK, getNormalAndUwuStrings("420360 no scope")));
        //@formatter:on
    }

    private static Pair<String, String> getNormalAndUwuStrings(final String string) {
        return new Pair<>(string, uwuTranslator(string));
    }

    private static String uwuTranslator(final String string) {
        return string.replaceAll("[rl]", "w").replaceAll("[RL]", "W").replaceAll("th", "d").replaceAll("Th", "D");
    }
}
