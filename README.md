# springexample (incomplete, waiting for final verdict)
A (hopefully) simple example of Spring to demonstrate the power of Spring beans and dependency injection.

If the team likes this enough, I can formally write out some documentation to clarify points and give a breakdown of
how to do shit (to the best of my knowledge anyways :P)

Most of the details on how this shit works will be in the compdepinj project (as where that's the ideal setup is 
located).

##  [Spring Boot documentation](https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/)

### Note
It used to be a meme that people who used Spring for their java programs were glorified XML programmers, because all of
Spring's configuration (where all the bean MAJIK HAPPENS) was done in an xml file before. **This is no longer the case**.
Everything can be done in Java with annotations, and it's a very nice framework once you get used to it.

The notes in this README are mentioned throughout the code itself (mostly the compdepinj module)

## I) Dependency Injection Through SPRING BEANZ
What is a bean? A bean is any object that is instantiated and handled by Spring. What does that mean for us? The purpose 
of beans in Spring is to separate the business logic from the configuration (the specific impls of a class, dependencies
between objects, etc). It's basically handing a bunch of objects to your friend and telling them to hold them for you until you need them.

### 1) Creating Configuration Class
The first step is to create the configuration itself. This is where all your custom-made Spring beans will be stored.

```
@Configuration
public class AppConfig{...}
```


### 2) Defining a Bean
The way a bean is defined is by sticking a `@Bean` anno on a getter inside the `@Configuration` class. _**In essence, that's 
all a bean is: a glorified getter**_. Don't overthink it :P

### 3) Retrieving a Bean

### 4) Bean Disambiguation
You might've noticed that the retrieval of a bean is done via its typing (_i.e._ we call the config to give us the bean
of type `Recipe` with `config.getbean(Recipe.class)`. That's all fine... but what happens if we have _2 beans of the 
**same type**_ declared in the config?

### 5) Stereotypes
--add a @ComponentScan("root pkg") anno to the config class

--label classes with @Component, @RestController, @Controller, @Service, @Repository to declare beans instantly

--can still access beans like you would normally (assuming @ComponentScan is declared in the config class)

--can also put names on the stereotype annos to give the beans explicit names

These two methods of declaring beans are exactly equivalent to each other:
<table>
<th>Explicit Bean Declaration (in config)</th>
<th>Stereotype Bean Declaration (in class itself)</th>
<tr>
<td>
   <pre>
   @Bean("chickenTendies")
   public Recipe getRecipe(){
       return new ChickenTendiesRecipe();
   }
   </pre>
</td>
<td>
  <pre>
  @Component("chickenTendies")
  public class ChickenTendiesRecipe implements Recipe{...}
  </pre>
</td>
</tr>
</table>

Notice that the stereotype anno is placed on the _subclass_, not the interface (this also is the case for abstract 
classes). This is because Spring needs to know what implementation it needs to provide for the bean of the generic type.
If

We could also create _custom_ stereotype annotations to suit our purposes 
([http://www.javabyexamples.com/spring-stereotype-annotations/](http://www.javabyexamples.com/spring-stereotype-annotations/)).
Since all of the stereotype annotations are functionally identical, besides their name, we just need to put the
`@Component` annotation on our custom one, and Spring will take care of the rest! A couple I can think of right off
the bat would be `@Agent` and `@Delegate`...?

### 6) Wiring Beans Together
"Wiring" beans in Spring refers to 

### 7) Autowiring
This is the biggest learning curve of Spring dependency injection, but if you understand how Spring beans work at their
core, then autowiring pretty much follows suit.

If we go back to our restaurant scenario, calling `config.getBean(...)` is like finding a recipe ourselves. Autowiring
is like telling someone else

### 8) Injection Methods
There's 3 different ways you can inject dependencies: field, setter, and constructor injection.

##### i) Field Injection
This is done by simply sticking `@Autowired` onto the field you wish to be injected.
```java
public class RecipeBook{
    @Autowired
    private Recipe Recipe;
}
```
This method is the least preferred because it breaks OOP best practices by allowing an external entity to modify
object fields directly, but it works just as good.

##### ii) Setter Injection
This is done by creating a setter for the field you want to be injected, and then sticking `@Autowired` on the setter.
```java
public class RecipeBook{
    private Recipe Recipe;

    @Autowired
    public void setRecipe(final Recipe Recipe){
        this.Recipe = Recipe;
    }
}
```
This is a technically better method of injecting dependencies because the interaction with the object is abstracted, 
but it's still not the best method because it's preferred that object fields be immutable. Furthermore, for each field
to be injected, a separate setter is needed, which just adds to the line count.

##### iii) Constructor Injection
This is the method that you _should_ use if possible. It makes the most sense of the three, and allows us to maintain
OOP best practices, _i.e._ immutable object fields that are interacted with in an abstracted way. Moreover, it doesn't
require a setter method (which would just add to the line count).

This method is done by sticking `@Autowired` onto the constructor.
```java
public class RecipeBook{
    private final Recipe Recipe;

    @Autowired
    public RecipeBook(final Recipe Recipe){
        this.Recipe = Recipe;
    }
}
```

The two most used dependency injection methods are field and constructor, with constructor being the best one by far.
This is probably due to these methods adding minimal lines to the code, with only needing 1 extra line per field/constructor
method, while setter injection requires 3 or 4 per injected field (assuming you format well).

### 9) Autowiring Disambiguation

### 10) Unit Testing with Spring
Spring's 

## II) A Basic REST Service with Spring

### 1) Main Class
The root of the application, which should be in the default package (src/main/java/com.something.mavenartifacty), should
look something like:
```java
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.base.package")
@Import(ConfigClass.class)
public class Application{
    public static void main(final String... args){
        SpringApplication.run(Application.class, args);
    }   
}
```
The `scanBasePackages` arg tells Spring where to look for stereotype annotated classes (`@Component`, `@Service`, 
`@RestController`, `@Repository`, `@Configuration`). The `@Import` anno tells Spring which class (or classes) to look 
for user-defined beans (`@Bean` methods). The section above goes into more detail about the mechanics of configurations,
beans, and stereotyping classes.

### 2) The Service layer
This is the bottommost layer of the overall service where the majority of the computation will occur. A service class
might look something like this:
```java
import org.springframework.stereotype.Service;
@Service
public class AppService{
    
}
```

### 3) The REST layer
This is where database interactions would occur. However, for the sake of simplicity, we won't worry about database bs
for now. We'll just implement some getters and pretend like it's coming from a database.

### 4) Error Handling

### 5) Integration Testing
