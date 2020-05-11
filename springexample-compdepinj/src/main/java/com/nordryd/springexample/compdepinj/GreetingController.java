package com.nordryd.springexample.compdepinj;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.compdepinj.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * REST endpoints for the {@link SpringExampleMain Greeting app}. Notice that this doesn't need a bean, we don't declare
 * it in the root app starter, but these are still recognized as endpoints. The {@link RestController @RestController}
 * annotation automatically creates this class as a bean, and is automatically recognized as such when we start the
 * spring app. In fact, if we create an explicit bean in our config, it results in an error because of conflicting
 * beans.
 * </p>
 * <p>
 * {@link RestController @RestController} is functionally the same as {@link Controller @Controller}, defining this as
 * a bean of type {@link GreetingController}, however {@link RestController @RestController} automatically adds the
 * {@link ResponseBody @ResponseBody} annotation to all endpoints, which returns the object as normal, and writes the
 * object data directly into the HTTP response as JSON or XML.
 * </p>
 *
 * @author Nordryd
 */
@RestController
@RequestMapping("/v1/api/greeting")
public class GreetingController
{
    private final GreetingService service;

    /**
     * Constructor. This uses <b>constructor injection</b> to inject a bean of type {@link GreetingService} into this
     * object when spring creates it (effectively making it a dependency of this class).
     *
     * @param service a {@link GreetingService}, which is injected by spring when the {@link GreetingController} bean is
     * created.
     */
    @Autowired
    public GreetingController(final GreetingService service) {
        this.service = service;
    }

    @GetMapping("/helloWorld")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return service.helloWorld();
    }

    @GetMapping("/greet")
    @ResponseStatus(HttpStatus.OK)
    public String greet(@RequestParam("who") final String who) {
        return service.greet(who);
    }

    @GetMapping("/sand")
    @ResponseStatus(HttpStatus.OK)
    public String sand() {
        return service.sand();
    }

    @GetMapping("/number")
    @ResponseStatus(HttpStatus.OK)
    public String number() {
        return service.number();
    }

    @GetMapping("/swiggity")
    @ResponseStatus(HttpStatus.OK)
    public String swiggity() {
        return service.swiggity();
    }

    @GetMapping("/special")
    @ResponseStatus(HttpStatus.OK)
    public String special() {
        return service.special();
    }
}
