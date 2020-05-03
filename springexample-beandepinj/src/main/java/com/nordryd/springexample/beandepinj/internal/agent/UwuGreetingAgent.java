package com.nordryd.springexample.beandepinj.internal.agent;

import static java.lang.String.format;

/**
 * <p>
 * Agent dat gweets de end usew.
 * </p>
 *
 * @author Nowdwyd
 */
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

    private static String uwuTranslator(final String string) {
        return string.replaceAll("[rl]", "w").replaceAll("[RL]", "W").replaceAll("th", "d").replaceAll("Th", "D");
    }
}
