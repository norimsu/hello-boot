package norimsu.helloboot;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class HelloBootApplication {

    private final JdbcTemplate jdbcTemplate;

    public HelloBootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(255) primary key, count int)");
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }

}
