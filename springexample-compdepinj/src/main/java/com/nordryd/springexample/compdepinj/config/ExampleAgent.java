package com.nordryd.springexample.compdepinj.config;

/**
 * Imagine this is an agent declared outside of this class. This is just for the sake of example as to how
 * the authority bean may be wired to an agent.
 */
public class ExampleAgent
{
    private final String authority;

    public ExampleAgent(final String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "ExampleAgent{" + "authority='" + authority + '\'' + '}';
    }
}
