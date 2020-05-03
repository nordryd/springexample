package com.nordryd.springexample.beandepinj;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpStatus.OK;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.beandepinj.internal.injector.CalculatorDependencyInjector;
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
@RequestMapping("/vi/api/calc")
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
    public int add(@RequestParam("values") final String values) {
        return depInjector.getService()
                .add(stream(values.replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray());
    }

    @GetMapping("/subtract")
    @ResponseBody
    @ResponseStatus(OK)
    public int subtract(@RequestParam("values") final String values) {
        return depInjector.getService()
                .subtract(stream(values.replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray());
    }

    @GetMapping("/multiply")
    @ResponseBody
    @ResponseStatus(OK)
    public int multiply(@RequestParam("values") final String values) {
        return depInjector.getService()
                .multiply(stream(values.replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray());
    }

    @GetMapping("/square")
    @ResponseBody
    @ResponseStatus(OK)
    public int square(@RequestParam("value") final int value) {
        return depInjector.getService().square(value);
    }

    @GetMapping("/exponent")
    @ResponseBody
    @ResponseStatus(OK)
    public int exponent(@RequestParam("value") final int value, @RequestParam("exp") final int exponent) {
        return depInjector.getService().exponent(value, exponent);
    }

    @GetMapping("/leftshift")
    @ResponseBody
    @ResponseStatus(OK)
    public int leftShift(@RequestParam("value") final int value,
            @RequestParam(value = "shift", required = false) final Integer shift) {
        return depInjector.getService().leftShift(value, shift);
    }

    @GetMapping("/rightshift")
    @ResponseBody
    @ResponseStatus(OK)
    public int rightShift(@RequestParam("value") final int value,
            @RequestParam(value = "shift", required = false) final Integer shift) {
        return depInjector.getService().rightShift(value, shift);
    }

    @GetMapping("/help")
    @ResponseStatus(OK)
    @ResponseBody
    public String help() {
        return "HALP!";
    }
}
