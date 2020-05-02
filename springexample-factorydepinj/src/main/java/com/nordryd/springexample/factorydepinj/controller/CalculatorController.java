package com.nordryd.springexample.factorydepinj.controller;

import static org.springframework.http.HttpStatus.OK;

import com.nordryd.springexample.factorydepinj.SpringExampleMain;
import com.nordryd.springexample.factorydepinj.internal.injector.CalculatorDependencyInjector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * REST endpoints for the {@link SpringExampleMain Calculator app}, an app that calculates various calculations that must be calculatingly calculated in a calculated manner.
 * </p>
 *
 * @author Nordryd
 */
@RestController
@RequestMapping("/calc")
public class CalculatorController
{
    private final CalculatorDependencyInjector depInjector;

    /**
     * Constructor.
     */
    public CalculatorController() {
        this.depInjector = new CalculatorDependencyInjector();
    }

    @GetMapping("/add")
    @ResponseBody
    @ResponseStatus(OK)
    public int add(@RequestParam("values[]") final int... values) {
        return depInjector.getService().add(values);
    }

    @GetMapping("/subtract")
    @ResponseBody
    @ResponseStatus(OK)
    public int subtract(@RequestParam("values[]") final int... values) {
        return depInjector.getService().subtract(values);
    }

    @GetMapping("/multiply")
    @ResponseBody
    @ResponseStatus(OK)
    public int multiply(@RequestParam("values[]") final int... values) {
        return depInjector.getService().multiply(values);
    }

    @GetMapping("/multiply")
    @ResponseBody
    @ResponseStatus(OK)
    public int square(@RequestParam("value") final int value) {
        return depInjector.getService().square(value);
    }

    @GetMapping("/multiply")
    @ResponseBody
    @ResponseStatus(OK)
    public int exponent(@RequestParam("value") final int value, @RequestParam("exp") final int exponent) {
        return depInjector.getService().exponent(value, exponent);
    }

    @GetMapping("/help")
    @ResponseStatus(OK)
    @ResponseBody
    public String help() {
        return "HALP!";
    }
}
