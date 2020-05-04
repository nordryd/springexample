package com.nordryd.springexample.compdepinj.service;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.compdepinj.config.GreetingConfig;
import com.nordryd.springexample.compdepinj.internal.agent.GreetingAgent;
import com.nordryd.springexample.compdepinj.internal.agent.NormalGreetingAgent;
import com.nordryd.springexample.compdepinj.internal.agent.UwuGreetingAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Service layer for the {@link SpringExampleMain Calculator app}.
 * </p>
 *
 * @author Nordryd
 */
@Service
public class GreetingService
{
    /**
     * This is autowired in the constructor. Notice how we're even able to autowire the config in the first place
     * (this is to retrieve the {@link Integer} bean we created in the {@link GreetingConfig config file}). The context,
     * in and of itself, is also a bean. The fact that we can even autowire it confirms this. We could use field
     * injection on this, but constructor injection is the preferred method, so it's best to use it whenever possible.
     */
    private final ApplicationContext config;
    private final GreetingAgent agent;

    /**
     * Autowiring via the constructor is the preferred method (setter and field inj also exist, but that's not worth
     * going into right now). Notice how we have a {@link Qualifier @Qualifier} anno on
     * the agent param but not the config param. This is because {@link GreetingAgent} has 2 subclasses
     * {@link NormalGreetingAgent} and {@link UwuGreetingAgent} that are both defined with {@link Component @Component}
     * annos. This creates 2 beans of type {@link GreetingAgent}. Autowiring, by default, is by type. This isn't an
     * issue if only one bean exists of one type (like for the config and for {@link GreetingService}, but when 2 beans
     * of the same type exist, default autowiring will not work. This is because spring doesn't know which bean to retrieve.
     * The {@link Qualifier @Qualifier} anno is how we do bean disambiguation.<br>
     * Notice that in the {@link NormalGreetingAgent} and {@link UwuGreetingAgent}, the {@link Component @Component}
     * annos have strings on them. This is the bean's name. In the {@link Qualifier @Qualifier} anno, we can
     * explicitly say "get the bean with this name". Spring knows exactly what to do then, and gets the bean we
     * want. We can do this with the normal {@link Bean @Bean} anno in the config class as well if we want multiple
     * beans of the same type that do different things.
     */
    @Autowired
    public GreetingService(@Qualifier("uwuGreet") final GreetingAgent agent, final ApplicationContext config) {
        this.agent = agent;
        this.config = config;
    }

    public String helloWorld() {
        return agent.helloWorld();
        // return config.getBean("normalGreet", GreetingAgent.class).helloWorld();
        // this line would also be perfectly valid since there exists a bean of this type and name thanks to
        // the @Component anno and the use of @ComponentScan in the config file. It's unnecessary with autowiring
        // however, so this is just here to reference that it is indeed possible.
    }

    public String greet(final String who) {
        return agent.greet(who);
    }

    public String sand() {
        return agent.sand();
    }

    public String number() {
        return agent.number(config.getBean(Integer.class));
    }
}
