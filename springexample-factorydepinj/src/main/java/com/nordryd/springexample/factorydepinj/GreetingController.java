package com.nordryd.springexample.factorydepinj;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.factorydepinj.internal.injector.GreetingDependencyInjector;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * REST endpoints for the {@link SpringExampleMain Greeting app}.
 * </p>
 *
 * @author Nordryd
 */
@RestController
@RequestMapping("/v1/api/greeting")
public class GreetingController
{
    private final GreetingDependencyInjector depInjector;

    /**
     * Constructor.
     */
    public GreetingController() {
        this.depInjector = new GreetingDependencyInjector();
    }

    @GetMapping("/helloWorld")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return depInjector.getService().helloWorld();
    }

    @GetMapping("/greet")
    @ResponseStatus(HttpStatus.OK)
    public String greet(@RequestParam("who") final String who) {
        return depInjector.getService().greet(who);
    }

    @GetMapping("/sand")
    @ResponseStatus(HttpStatus.OK)
    public String sand() {
        return depInjector.getService().sand();
    }
}
