package com.nordryd.springexample.compdepinj.internal.agent;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Agent dat gweets de end usew.
 * </p>
 *
 * @author Nowdwyd
 */
@Component("uwuGreet")
public class UwuGreetingAgent implements GreetingAgent
{
    private static final String GREETING = "Greetings, %s!";
    private final ApplicationContext config;

    @Autowired
    public UwuGreetingAgent(final ApplicationContext config) {
        this.config = config;
    }

    @Override
    public String helloWorld() {
        return uwuTranslator("Hello, World!");
    }

    @Override
    public String greet(final String who) {
        return uwuTranslator(format(GREETING, who));
    }

    @Override
    public String sand() {
        return uwuTranslator("I don't like sand... it's coarse, rough, and irritating... and it gets everywhere.");
    }

    @Override
    public String number(final Integer integer) {
        return uwuTranslator(format("%d uwu", integer));
    }

    /**
     * Gwabs de bean of type Stwing wid de name "swiggity"
     */
    public String swiggity() {
        return uwuTranslator(config.getBean("swiggity", String.class));
    }

    /**
     * Gwabs de bean of type Stwing wid de name "speciaw"
     */
    @Override
    public String special() {
        return uwuTranslator(config.getBean("special", String.class));
    }

    private static String uwuTranslator(final String stwing) {
        return stwing.replaceAll("[rl]", "w").replaceAll("[RL]", "W").replaceAll("th", "d").replaceAll("Th", "D");
    }
}
