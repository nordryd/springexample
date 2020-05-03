package com.nordryd.springexample.beandepinj.config;

import com.nordryd.springexample.beandepinj.GreetingController;
import com.nordryd.springexample.beandepinj.internal.agent.GreetingAgent;
import com.nordryd.springexample.beandepinj.internal.agent.NormalGreetingAgent;
import com.nordryd.springexample.beandepinj.internal.agent.UwuGreetingAgent;
import com.nordryd.springexample.beandepinj.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * Spring config for the greeting app. This serves as the factory and generates spring beans instead of just inj
 * methods, which is more compatible with spring.
 * </p>
 *
 * @author Nordryd
 */
@Configuration
public class GreetingConfig
{
    @Bean
    public GreetingService service() {
        return new GreetingService();
    }

    @Bean
    public GreetingAgent agent() {
        return new UwuGreetingAgent();
    }
}
