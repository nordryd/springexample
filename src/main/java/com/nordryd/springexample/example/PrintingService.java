package com.nordryd.springexample.example;

/**
 * <p>
 * Service for printing out templates with specific words.
 * </p>
 */
public interface PrintingService
{
    /**
     * Prints a template string out with the word injected.
     *
     * @param word the custom words to inject.
     */
    void print(final String word);

    /**
     * Prints the original string this template is based on.
     */
    void print();
}
