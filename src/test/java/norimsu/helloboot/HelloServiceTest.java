package norimsu.helloboot;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

    @Test
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService();
        final String ret = helloService.sayHello("Test");
        assertThat(ret).isEqualTo("Hello, Test!");
    }
}