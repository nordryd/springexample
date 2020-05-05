package com.nordryd.springexample.beandepinj.service;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.beandepinj.internal.agent.GreetingAgent;

/**
 * <p>
 * Service layer for the {@link SpringExampleMain Calculator app}.
 * </p>
 *
 * @author Nordryd
 */
public class GreetingService
{
    private GreetingAgent agent;

    public GreetingService(final GreetingAgent agent) {
        this.agent = agent;
    }

    public String helloWorld() {
        return agent.helloWorld();
    }

    public String greet(final String who) {
        return agent.greet(who);
    }

    public String sand() {
        return agent.sand();
    }
}
