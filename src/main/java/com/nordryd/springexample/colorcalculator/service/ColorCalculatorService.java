package com.nordryd.springexample.colorcalculator.service;

import com.nordryd.springexample.colorcalculator.factory.ColorCalculatorDependencyFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Service layer for the Color Calculator app.
 * </p>
 *
 * @author Nordryd
 */
@Service
public class ColorCalculatorService
{
    private final ColorCalculatorDependencyFactory depFactory = new ColorCalculatorDependencyFactory();

    public String addColors(final String color1, final String color2) {
        return color1 + " " + color2;
    }
}
