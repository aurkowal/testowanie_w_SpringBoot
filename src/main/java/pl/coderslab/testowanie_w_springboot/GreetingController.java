package pl.coderslab.testowanie_w_springboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final String defaultGreeting;

    public GreetingController(String defaultGreeting) {
        this.defaultGreeting = defaultGreeting;
    }

    @GetMapping("/greeting")
    public Greeting greet(@RequestParam(required = false, defaultValue = "World") String name) {
        String message = "Hello, " + name + "!";
        return new Greeting(message);
    }
}