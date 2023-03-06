package norimsu.helloboot.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import norimsu.helloboot.HelloBootTest;

@HelloBootTest
class HelloRepositoryTest {

    @Autowired JdbcTemplate jdbcTemplate;
    @Autowired HelloRepository helloRepository;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(255) primary key, count int)");
    }

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