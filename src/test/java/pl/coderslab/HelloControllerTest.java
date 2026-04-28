package pl.coderslab;

import org.junit.jupiter.api.Test;
import pl.coderslab.testowanie_w_springboot.HelloController;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void helloTest() {
        HelloController helloController = new HelloController();
        String hello = helloController.hello();
        assertEquals("Hello", hello);

    }

}