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

    String greet(final String toGreet);

    String sand();

    String number(final Integer integer);

    String swiggity();

    String special();
}
