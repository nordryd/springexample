package com.nordryd.springexample.factorydepinj.internal.agent;

import static java.lang.String.format;

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
    private static final String GREETING = "Greetings, %s!";
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
        return "Hello, World!";
    }

    @Override
    public String greet(final String who) {
        return format(GREETING, who);
    }

    @Override
    public String sand() {
        return "I don't like sand... it's coarse, rough, and irritating... and it gets everywhere.";
    }
}
