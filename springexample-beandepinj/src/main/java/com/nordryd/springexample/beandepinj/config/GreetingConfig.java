package com.nordryd.springexample.beandepinj.config;

import com.nordryd.springexample.beandepinj.internal.agent.GreetingAgent;
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
    /**
     * Notice how this bean calls the {@link #agent() GreetingAgent Bean} below. We do this because
     * {@link GreetingService} has a {@link GreetingAgent} dependency in the form of a constructor param. Instead of
     * making the service class pass in the parameter, we'll instead do that here in the config file. This way the
     * service can just worry about its logic rather than what objects need what (dependency injection!).<br>
     * When we call config to give us a service bean, the config will automatically create the service object and
     * call the agent bean to give it its dependency.<br>
     * This is called "wiring" beans together, where beans call each other to fulfill their dependency requirements
     * rather than the classes themselves doing it (providing constructor/setter args or setting the class fields
     * themselves). It keeps the configuration/dependencies away from the business logic (separation of concerns :P).
     * <br><br>
     * This could probably be accomplished with the dep factory as well (just passing <b>new</b> things in for the
     * instantiation), but this is a central area for deps to be retrieved through the spring framework.
     * <br><br>
     * It is possible to have superconfigs and subconfigs, but that can be discussed later if we decide we want
     * to actually go ahead and use Spring.
     */
    @Bean
    public GreetingService service() {
        return new GreetingService(agent());
    }

    @Bean
    public GreetingAgent agent() {
        return new UwuGreetingAgent();
    }
}
