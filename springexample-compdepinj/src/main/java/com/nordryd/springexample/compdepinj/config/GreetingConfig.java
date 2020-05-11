package com.nordryd.springexample.compdepinj.config;

import static java.lang.String.format;

import com.nordryd.springexample.compdepinj.internal.agent.ExampleAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Config file for greeting app. This can be used for explicit bean declaration if we need to (can't think of a use case
 * off the top of my head).
 * </p>
 * <p>
 * {@link ComponentScan @ComponentScan(root-pkg-path)} defines the directives (package name) of components for
 * auto-scanning. This enables {@link Autowired @Autowired} to be used, scanning for beans in the specified package.
 * I don't know if it uses its own package by default, but it might be good practice to just specify so we know
 * where beans are coming from. {@link EnableAutoConfiguration @EnableAutoConfiguration} is more of a quality-of-life
 * annotation that fills in some gaps that we don't necessarily care about.
 * </p>
 * <p>
 * This "java" way of a making a spring config is much more java-user-friendly and dispels the meme of spring users
 * being more XML devs instead of Java devs.<br>
 * Fun fact: Spring traditionally uses XML for this config, and all beans would be declared and wired (and autowired)
 * there. It's confusing af tho, because XML is hella ugly, as well as needing to kind of know what your code structure
 * was gonna be before even writing it to know how to design your beans. This version of using Java for configs and
 * wiring is MUUUCH nicer because we can use Java concepts to accomplish the same things while we write the code itself,
 * as well as using a language we're familiar with, so there's less of a learning curve.
 * </p>
 * <p>
 * Technically it <i>is</i> possible to have parameterized beans, but this is considered a spring anti-pattern since
 * the whole point is to not worry about object configuration, and impose a separation of concerns by allowing the root
 * code to focus on the business logic rather than what objects of what type and instance are being passed to it.
 * </p>
 *
 * @author Nordryd
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.nordryd.springexample.compodepinj")
public class GreetingConfig
{
    /**
     * Configuration variables can be stored like this, and returned via beans. All config stuff is stored in one nice
     * place :P
     */
    private static final String AUTHORITY = "authority";

    /**
     * <p>
     * If we want to get a bean of an integer, we can use {@link ApplicationContextAware} like in the beanDepInj example
     * and retrieve it easily. Or we can autowire it.<br>
     * NOTE: THE TYPE THE BEAN RETURNS IS THE TYPE OF THE BEAN (ie, this bean returns an {@link Integer}, so this bean
     * is an {@link Integer} bean.
     * </p>
     * <p>
     * This bean uses a literal value, but constants can be declared above, just like normal variables.
     * </p>
     * <p>
     * This is all a bean is: a glorified Getter. Don't overthink it :P
     * </p>
     */
    @Bean
    public Integer getInteger() {
        return 420360;
    }

    /**
     * This bean has an explicit name. This is required because there are 2 beans of the same type (String), and Spring
     * can't figure out which one to return with default autowiring. The Integer bean above is the only integer bean
     * that exists, so it doesn't need a name.
     * Spring is usually pretty good about telling you which beans are conflicting, or what TYPE of bean is conflicting
     * when you try to start up the spring app and it encounters such a problem.
     */
    @Bean("swiggity")
    public String swiggity() {
        return "Wot? Swiggity Swooty?";
    }

    /**
     * This bean has an explicit name, for the reasons stated above. Also, notice how this bean is calling the
     * {@link #getInteger() Integer bean} declared above. Beans are able to call each other to get values. This is
     * called "wiring" beans together. This is where the term {@link Autowired "Autowiring"} gets its meaning. Remember
     * how when we use a {@link Component @Component, @Service, @Repository, @Controller, or @RestController} on
     * a class, a Bean is automatically created of that type. The {@link Autowired @Autowired} anno automatically goes
     * and fetches that particular bean and wires it to the current one. It basically automatically does what this
     * bean does.
     */
    @Bean("special")
    public String special() {
        return format("%s no scope", getInteger());
    }

    /**
     * Here's an example of a bean that could be VERY useful to us and could be wired to a bunch of other beans, like
     * for Agents and Delegates and whatnot. This could be something that is more defined in subconfigs more
     * specifically for diff workflows.
     * <br><br>
     * Would be something like config.getBean("authority", String.class) to get the authority, or just completely
     * abstract this away to be just wired to other beans in the config file. The authority is stored in this place
     * and this place only, and as long as each bean that is dependent on the authority is wired to this bean
     */
    @Bean("authority")
    public String authority() {
        return AUTHORITY;
    }

    /**
     * Example of how an agent might be wired to the authority. This bean also shows how beans can have computation
     * inside them as well.
     */
    @Bean
    public ExampleAgent getExampleAgent() {
        final ExampleAgent agent = new ExampleAgent(authority());
        System.out.println(agent);
        return new ExampleAgent(authority());
    }

    @Bean("patchMsgFormat")
    public String patch() {
        return "This is a PATCH request that has the parameters:\nop: %s\npath: %s\nvalue: %s\n\nwith an ID of %d.";
    }
}
