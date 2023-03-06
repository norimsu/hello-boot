package norimsu.helloboot.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class HelloRepositoryTest {

    @Autowired JdbcTemplate jdbcTemplate;
    @Autowired HelloRepository helloRepository;

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("norimsu")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("norimsu")).isEqualTo(0);

        helloRepository.increaseCount("norimsu");
        assertThat(helloRepository.countOf("norimsu")).isEqualTo(1);

        helloRepository.increaseCount("norimsu");
        assertThat(helloRepository.countOf("norimsu")).isEqualTo(2);
    }
}