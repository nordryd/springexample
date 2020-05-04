package com.nordryd.springexample.compdepinj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * Config file for greeting app. This can be used for explicit bean declaration if we need to (can't think of a use case
 * off the top of my head).
 * </p>
 * <p>
 * {@link ComponentScan @ComponentScan(root-pkg-path)} defines the directives (package name) of components for
 * auto-scanning. This enables {@link Autowired @Autowired} to be used, scanning for beans in the specified package.
 * I don't know if it uses its own package by default, but it might be good practice to just specify so we know
 * where beans are coming from.
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
     * If we want to get a bean of an integer, we can use {@link ApplicationContextAware} like in the beanDepInj example
     * and retrieve it easily. Or we can autowire it as an object field.<br>
     * NOTE: THE TYPE THE BEAN RETURNS IS THE TYPE OF THE BEAN (ie, this bean returns an {@link Integer}, so this bean
     * is an {@link Integer} bean.
     */
    @Bean
    public Integer getInteger() {
        return 420360666;
    }
}
