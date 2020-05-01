package com.nordryd.springexample.factorydepinj.controller;

import com.nordryd.springexample.factorydepinj.CalculatorMain;
import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * REST endpoints for the {@link CalculatorMain Calculator app} app.
 * </p>
 *
 * @author Nordryd
 */
@RestController
@RequestMapping(CalculatorController.BASE_MAPPING)
public class CalculatorController
{
    public static final String BASE_MAPPING = "/calc";

    private final CalculatorDependencyInjector depFactory;

    public CalculatorController() {
        this.depFactory = new CalculatorDependencyInjector();
    }
}
