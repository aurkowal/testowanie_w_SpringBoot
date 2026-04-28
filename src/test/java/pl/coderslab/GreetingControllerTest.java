package pl.coderslab;

import org.junit.jupiter.api.Test;
import pl.coderslab.testowanie_w_springboot.Greeting;
import pl.coderslab.testowanie_w_springboot.GreetingController;

import static org.junit.jupiter.api.Assertions.*;

class GreetingControllerTest {

    @Test
    void greetTest() {
        GreetingController greetingController = new GreetingController("hej nieznajomy");
        Greeting helloName = greetingController.greet("Alicja");
        assertEquals("Hello, Alicja!", helloName.getMessage());
    }

    @Test
    void greetTestNoParam() {
        GreetingController greetingController = new GreetingController("hej nieznajomy");
        Greeting helloName = greetingController.greet(null);
        assertEquals("Hello, World!", helloName.getMessage());
    }
}