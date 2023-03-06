package norimsu.helloboot.service;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import norimsu.helloboot.repository.HelloRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class HelloServiceCountTest {

    @Autowired HelloService helloService;
    @Autowired HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("norimsu");
            assertThat(helloRepository.countOf("norimsu")).isEqualTo(count);
        });
    }

}
