package blackjack;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * <p>
 * Unit tests for {@link BlackjackController}.
 * </p>
 *
 * @author Nordryd
 */
@RunWith(MockitoJUnitRunner.class)
public class BlackjackControllerTest
{
    @Mock
    private BlackjackService stuntService;

    @InjectMocks
    private BlackjackController controller;
}
