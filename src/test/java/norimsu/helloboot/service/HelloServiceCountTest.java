package norimsu.helloboot.service;

import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import norimsu.helloboot.HelloBootTest;
import norimsu.helloboot.repository.HelloRepository;

@HelloBootTest
class HelloServiceCountTest {

    @Autowired HelloService helloService;
    @Autowired HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("norimsu");
            Assertions.assertThat(helloRepository.countOf("norimsu")).isEqualTo(count);
        });
    }

}
