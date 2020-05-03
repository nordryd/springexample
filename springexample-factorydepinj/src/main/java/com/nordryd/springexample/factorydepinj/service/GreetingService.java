package com.nordryd.springexample.factorydepinj.service;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.factorydepinj.internal.injector.GreetingDependencyInjector;

/**
 * <p>
 * Service layer for the {@link SpringExampleMain Calculator app}.
 * </p>
 *
 * @author Nordryd
 */
public class GreetingService
{
    private final GreetingDependencyInjector depInjector;

    /**
     * Constructor.
     *
     * @param depInjector a {@link GreetingDependencyInjector}.
     */
    public GreetingService(final GreetingDependencyInjector depInjector) {
        this.depInjector = depInjector;
    }

    public String helloWorld() {
        return depInjector.getAgent().helloWorld();
    }

    public String greet(final String who) {
        return depInjector.getAgent().greet(who);
    }

    public String sand() {
        return depInjector.getAgent().sand();
    }
}
