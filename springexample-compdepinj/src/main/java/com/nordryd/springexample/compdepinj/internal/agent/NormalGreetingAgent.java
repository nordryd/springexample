package com.nordryd.springexample.compdepinj.internal.agent;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Agent that greets the end user.
 * </p>
 *
 * @author Nordryd
 */
@Component("normalGreet")
public class NormalGreetingAgent implements GreetingAgent
{
    private static final String GREETING = "Greetings, %s!";
    private final ApplicationContext config;

    @Autowired
    public NormalGreetingAgent(final ApplicationContext config) {
        this.config = config;
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

    @Override
    public String number(final Integer integer) {
        return integer.toString();
    }

    /**
     * Grabs the bean of type String with the name "swiggity"
     */
    public String swiggity() {
        return config.getBean("swiggity", String.class);
    }

    /**
     * Grabs the bean of type String with the name "special"
     */
    @Override
    public String special() {
        return config.getBean("special", String.class);
    }
}
