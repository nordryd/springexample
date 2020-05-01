package com.nordryd.springexample.example;

/**
 * <p>
 * "Hello, World!"
 * </p>
 */
public class HelloWorldPrintingService implements PrintingService
{
    private static final String TEMPLATE = "Hello, %s!\n";

    @Override
    public void print(final String word) {
        System.out.printf(TEMPLATE, word);
    }

    @Override
    public void print() {
        print("World");
    }
}
