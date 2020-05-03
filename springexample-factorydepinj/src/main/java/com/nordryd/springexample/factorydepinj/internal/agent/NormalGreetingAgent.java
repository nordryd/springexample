package com.nordryd.springexample.factorydepinj.internal.agent;

import com.nordryd.springexample.factorydepinj.internal.injector.GreetingDependencyInjector;

/**
 * <p>
 * Agent that greets the end user.
 * </p>
 *
 * @author Nordryd
 */
public class NormalGreetingAgent implements GreetingAgent
{
    private static final String GREETING = "Greetings!";
    private final GreetingDependencyInjector depInjector;

    /**
     * Constructor.
     *
     * @param depInjector a {@link GreetingDependencyInjector}.
     */
    public NormalGreetingAgent(final GreetingDependencyInjector depInjector) {
        this.depInjector = depInjector;
    }

    @Override
    public String helloWorld() {
        return null;
    }

    @Override
    public String greet(final String toGreet) {
        return null;
    }

    @Override
    public String funFact() {
        return null;
    }
}
