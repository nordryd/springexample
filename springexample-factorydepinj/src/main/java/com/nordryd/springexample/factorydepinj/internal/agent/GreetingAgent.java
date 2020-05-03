package com.nordryd.springexample.factorydepinj.internal.agent;

/**
 * <p>
 * Interface for what a greeting agent should have.
 * </p>
 *
 * @author Nordryd
 */
public interface GreetingAgent
{
    String helloWorld();

    String greet(final String toGreet);

    String funFact();
}
