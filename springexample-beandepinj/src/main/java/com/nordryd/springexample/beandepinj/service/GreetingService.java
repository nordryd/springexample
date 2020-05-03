package com.nordryd.springexample.beandepinj.service;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.beandepinj.internal.agent.GreetingAgent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>
 * Service layer for the {@link SpringExampleMain Calculator app}.
 * </p>
 *
 * @author Nordryd
 */
public class GreetingService implements ApplicationContextAware
{
    private ApplicationContext config;


    public String helloWorld() {
        return config.getBean(GreetingAgent.class).helloWorld();
    }

    public String greet(final String who) {
        return config.getBean(GreetingAgent.class).greet(who);
    }

    public String sand() {
        return config.getBean(GreetingAgent.class).sand();
    }

    @Override
    public void setApplicationContext(final ApplicationContext config) throws BeansException {
        this.config = config;
    }
}
