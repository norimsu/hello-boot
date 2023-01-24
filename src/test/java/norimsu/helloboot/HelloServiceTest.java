package norimsu.helloboot;


import static org.assertj.core.api.Assertions.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Test
@interface FastUnitTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest {

}

class HelloServiceTest {

    @FastUnitTest
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService();
        final String ret = helloService.sayHello("Test");
        assertThat(ret).isEqualTo("Hello, Test!");
    }

    @UnitTest
    void helloDecorator() {
        HelloService helloService = new HelloDecorator(name -> name);
        final String ret = helloService.sayHello("Test");
        assertThat(ret).isEqualTo("*Test*");
    }
}