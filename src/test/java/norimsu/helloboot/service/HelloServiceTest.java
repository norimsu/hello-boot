package norimsu.helloboot.service;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import norimsu.helloboot.dto.Hello;
import norimsu.helloboot.repository.HelloRepository;

class HelloServiceTest {

    private static final HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };

    @Test
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService(helloRepositoryStub);
        final String ret = helloService.sayHello("Test");
        assertThat(ret).isEqualTo("Hello, Test!");
    }

    @Test
    void helloDecorator() {
        HelloService helloService = new HelloDecorator(name -> name);
        final String ret = helloService.sayHello("Test");
        assertThat(ret).isEqualTo("*Test*");
    }
}