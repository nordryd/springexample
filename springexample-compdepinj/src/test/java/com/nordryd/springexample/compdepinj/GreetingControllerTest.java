package com.nordryd.springexample.compdepinj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.nordryd.springexample.compdepinj.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <p>
 * Unit tests for {@link GreetingController}.
 * </p>
 *
 * @author Nordryd
 */
@ExtendWith(MockitoExtension.class)
public class GreetingControllerTest
{
    @Mock
    private GreetingService service;

    /**
     * Since spring creates this object for us, we don't have to initialize it for testing, and the mock above
     * will be injected in for its instantiation. This allows for easy unit testing (without any "VisibleForTesting"
     * bullshit) :P:P:P:P:P:P:P:P:P:P
     */
    @InjectMocks
    private GreetingController controller;

    @Test
    public void testInjectMocksWorks() {
        final String expectedMessageIfSuccessful = "the mock was successfully injected";
        when(service.helloWorld()).thenReturn(expectedMessageIfSuccessful);
        assertEquals(expectedMessageIfSuccessful, controller.helloWorld());
    }
}
