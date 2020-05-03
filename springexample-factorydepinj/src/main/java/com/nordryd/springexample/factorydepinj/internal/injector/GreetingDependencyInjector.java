package com.nordryd.springexample.factorydepinj.internal.injector;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.factorydepinj.GreetingController;
import com.nordryd.springexample.factorydepinj.internal.agent.GreetingAgent;
import com.nordryd.springexample.factorydepinj.internal.agent.NormalGreetingAgent;
import com.nordryd.springexample.factorydepinj.service.GreetingService;

/**
 * <p>
 * Dependency getters for the {@link SpringExampleMain Calculator app}. This facilitates dependency injection with just
 * pure java (or the way things are currently done with no dependencies). This would be replaced by either a Spring
 * config, or by component annotations.
 * </p>
 *
 * @author Nordryd
 */
public class GreetingDependencyInjector
{
    public GreetingService getService() {
        return new GreetingService(this);
    }

    public GreetingController getController() {
        return new GreetingController();
    }

    public GreetingAgent getAgent() {
        return new NormalGreetingAgent(this);
    }
}
