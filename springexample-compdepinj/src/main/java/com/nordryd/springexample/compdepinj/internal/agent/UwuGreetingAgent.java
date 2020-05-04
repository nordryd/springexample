package com.nordryd.springexample.compdepinj.internal.agent;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    @Override
    public String number(final Integer integer) {
        return uwuTranslator(format("%d uwu", integer));
    }

    private static String uwuTranslator(final String string) {
        return string.replaceAll("[rl]", "w").replaceAll("[RL]", "W").replaceAll("th", "d").replaceAll("Th", "D");
    }
}
