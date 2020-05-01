package com.nordryd.springexample.factorydepinj.controller;

import com.nordryd.springexample.factorydepinj.CalculatorMain;
import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * REST endpoints for the {@link CalculatorMain Calculator app}.
 * </p>
 *
 * @author Nordryd
 */
@RestController
@RequestMapping("/calc")
public class CalculatorController
{
    private final CalculatorDependencyInjector depFactory;

    /**
     * Constructor.
     */
    public CalculatorController() {
        this.depFactory = new CalculatorDependencyInjector();
    }

    @GetMapping("hello")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String helloWorld() {
        return "Hello, world!";
    }
}
