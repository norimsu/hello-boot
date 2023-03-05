package norimsu.helloboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import norimsu.boot.autoconfigure.MySpringBootApplication;

@MySpringBootApplication
public class HelloBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            final String name = env.getProperty("my.name");
            System.out.println("name = " + name);
        };
    }

}
