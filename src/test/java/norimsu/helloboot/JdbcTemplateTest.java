package norimsu.helloboot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
class JdbcTemplateTest {

    @Autowired JdbcTemplate jdbcTemplate;

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello values (?, ?)", "spring", 1);
        jdbcTemplate.update("insert into hello values (?, ?)", "norimsu", 3);

        final Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        assertThat(count).isEqualTo(2);
    }


    @Test
    void insertAndQuery2() {
        jdbcTemplate.update("insert into hello values (?, ?)", "spring", 1);
        jdbcTemplate.update("insert into hello values (?, ?)", "norimsu", 3);

        final Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        assertThat(count).isEqualTo(2);
    }
}
