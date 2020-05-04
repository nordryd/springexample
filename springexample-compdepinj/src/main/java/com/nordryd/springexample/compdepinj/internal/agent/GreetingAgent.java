package com.nordryd.springexample.compdepinj.internal.agent;

import org.springframework.stereotype.Component;

/**
 * <p>
 * Interface for what a greeting agent should have. Notice we don't have a {@link Component @Component} anno on this
 * class. We put it on the subclasses so we can declare those beans with names to allow for disambiguation later on.
 * </p>
 *
 * @author Nordryd
 */
public interface GreetingAgent
{
    String helloWorld();

    String sand();

    String greet(final String toGreet);

    String number(final Integer integer);
}
