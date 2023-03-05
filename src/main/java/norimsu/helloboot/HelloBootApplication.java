package norimsu.helloboot;

import org.springframework.boot.SpringApplication;

import norimsu.boot.autoconfigure.MySpringBootApplication;

@MySpringBootApplication
public class HelloBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }

}
