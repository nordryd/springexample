package com.nordryd.springexample;

import com.nordryd.springexample.beandepinj.config.GreetingConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * Main class for the Factory Dependency Injection version of this app.
 * </p>
 * <p>
 * This incarnation uses the {@link GreetingConfig dependency factory} that we use now, passing a class
 * around that contains the dependencies.
 * </p>
 * <p>
 * Can run {@code mvn spring-boot:run} to start up the assembly and hit the endpoints via postman. We don't have to
 * create a Tomcat or Docker image (at least here, I'm not sure if we could do this in our real projects if we decide
 * to implement this). Then, thanks to the actuator dep in the pom, we can run:
 * {@code POST localhost:8080/actuator/shutdown} to shutdown the service remotely (not sure how to make this secure yet,
 * but that's OOS for this example). This endpoint is necessary because sometimes you can't Ctrl-C or stop the
 * assembly very easily without doing a kill process or something. It's there for convenience reasons, mainly.
 * </p>
 *
 * @author Nordryd
 */
@SpringBootApplication
public class SpringExampleMain
{
    /**
     * Main method.
     *
     * @param args command line arguments.
     */
    public static void main(final String... args) {
        SpringApplication.run(new Class[] { SpringExampleMain.class }, args);
    }
}
