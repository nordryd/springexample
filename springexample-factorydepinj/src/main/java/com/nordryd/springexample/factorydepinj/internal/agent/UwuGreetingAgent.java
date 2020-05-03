package com.nordryd.springexample.factorydepinj.internal.agent;

import com.nordryd.springexample.factorydepinj.internal.injector.GreetingDependencyInjector;

/**
 * <p>
 * Agent that gweets the end usew.
 * </p>
 *
 * @author Nowdwyd
 */
public class UwuGreetingAgent implements GreetingAgent
{
    private static final String GWEETING = "Gweetings!";
    private final GreetingDependencyInjector depInjectow;

    /**
     * Constwuctow.
     *
     * @param depInjectow a {@link GreetingDependencyInjector GweetingDependencyInjectow}.
     */
    public UwuGreetingAgent(final GreetingDependencyInjector depInjectow) {
        this.depInjectow = depInjectow;
    }

    @Override
    public String helloWorld() {
        return null;
    }

    @Override
    public String greet(final String toGweet) {
        return null;
    }

    @Override
    public String funFact() {
        return null;
    }
}
