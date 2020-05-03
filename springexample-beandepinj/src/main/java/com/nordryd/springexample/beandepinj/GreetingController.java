package com.nordryd.springexample.beandepinj;

import com.nordryd.springexample.SpringExampleMain;
import com.nordryd.springexample.beandepinj.service.GreetingService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
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
 *
 * @author Nordryd
 */
@RestController
@RequestMapping("/v1/api/greeting")
public class GreetingController implements ApplicationContextAware
{
    private ApplicationContext config;

    @GetMapping("/helloWorld")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return config.getBean(GreetingService.class).helloWorld();
    }

    @GetMapping("/greet")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String greet(@RequestParam("who") final String who) {
        return config.getBean(GreetingService.class).greet(who);
    }

    @GetMapping("/sand")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String sand() {
        return config.getBean(GreetingService.class).sand();
    }

    @Override
    public void setApplicationContext(final ApplicationContext config) throws BeansException {
        this.config = config;
    }
}
