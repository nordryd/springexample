package com.nordryd.springexample.example;

/**
 * <p>
 * "I don't like sand..."
 * </p>
 */
public class IDontLikeSandPrintingService implements PrintingService
{
    private static final String TEMPLATE = "I don't like %s. It's coarse and rough and irritating... and it gets everywhere.\n";

    @Override
    public void print(final String word) {
        System.out.printf(TEMPLATE, word);
    }

    @Override
    public void print() {
        print("sand");
    }
}
