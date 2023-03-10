package norimsu.helloboot.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloControllerTest {

    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);
        final String ret = helloController.hello("Test");
        assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failHelloController() {
        HelloController helloController = new HelloController(name -> name);
        assertThatThrownBy(() -> helloController.hello(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> helloController.hello("")).isInstanceOf(IllegalArgumentException.class);
    }

}