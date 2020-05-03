package com.nordryd.springexample.factorydepinj;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpStatus.OK;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.factorydepinj.internal.injector.GreetingDependencyInjector;
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
@RequestMapping("/v1/api/calc")
public class GreetingController
{
    private final GreetingDependencyInjector depInjector;

    /**
     * Constructor.
     */
    public GreetingController() {
        this.depInjector = new GreetingDependencyInjector();
    }
}
