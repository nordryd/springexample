package com.nordryd.springexample;

import com.nordryd.springexample.compdepinj.config.GreetingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Main class for the Factory Dependency Injection version of this app.
 * </p>
 * <p>
 * This incarnation uses {@link Component @Component (stereotyping) annotations} to define beans right on the classes
 * <b>without the need of a config class</b> (though you can certainly use one anyways). Note that
 * {@link Component @Component}, {@link Service @Service}, {@link Controller @Controller}, and
 * {@link Repository @Repository} all do the exact same thing as they all extend {@link Component @Component},
 * but are to make them more differentiable to humans. We then use {@link Autowired @Autowired} to wire them together
 * (by default it'll do it by type, but you can use {@link Qualifier @Qualifier (bean disambiguation)} to get a bean by
 * name if you define a bean with a name with the stereotype annotation.
 * </p>
 * <p>
 * Can run {@code mvn spring-boot:run} to start up the assembly and hit the endpoints via postman. We don't have to
 * create a Tomcat or Docker image (at least here, I'm not sure if we could do this in our real projects if we decide
 * to implement this). Then, thanks to the actuator dep in the pom, we can run:
 * {@code POST localhost:8080/actuator/shutdown} to shutdown the service remotely (not sure how to make this secure yet,
 * but that's OOS for this example). This endpoint is necessary because sometimes you can't Ctrl-C or stop the
 * assembly very easily without doing a kill process or something. It's there for convenience reasons, mainly.
 * </p>
 * <p>
 * The {@link SpringBootApplication @SpringBootApplication} makes this class recognized as a ServletWebServerFactory
 * bean, and also is equivalent to sticking {@link ComponentScan @ComponentScan},
 * {@link EnableAutoConfiguration @EnableAutoConfiguration}, and {@link Configuration @Configuration} annotations.
 * What this implies is that this can be autowired with other beans.
 * </p>
 * <p>
 * I believe when {@link SpringBootApplication @SpringBootApplication} is put on a class (and by extension,
 * {@link ComponentScan @ComponentScan}), it scans the immediate package and subpackages for
 * {@link Configuration @Configuration} classes and automatically imports them. This is just a theory, however, because
 * the {@link SpringBootApplication @SpringBootApplication} initializes the class itself as a bean (remember everything
 * in Spring is bean-based). {@link Configuration @Configuration} also initializes the class itself as a bean, too.
 * Thus, since they both exist as beans, Spring is able to autowire them, and it just does all of the under the
 * hood. But that's just a theory (a GAME theory).
 * </p>
 *
 * @author Nordryd
 */
@SpringBootApplication(scanBasePackages = "com.nordryd.springexample.compdepinj")
@Import(GreetingConfig.class)
public class SpringExampleMain
{
    /**
     * Main method. I BELIEVE this automatically searches for configs in the package directory and instantiates them
     * and then the objects' dependencies start a chain of bean instantiation depending on how they're wired together,
     * whether it's explicitly through the config, or though {@link Autowired autowiring}.
     *
     * @param args command line arguments.
     */
    public static void main(final String... args) {
        SpringApplication.run(new Class[] { SpringExampleMain.class }, args);
    }
}
