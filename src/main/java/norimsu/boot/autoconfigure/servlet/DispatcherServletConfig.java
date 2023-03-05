package norimsu.boot.autoconfigure.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import norimsu.boot.autoconfigure.MyAutoConfiguration;

@MyAutoConfiguration
public class DispatcherServletConfig {

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}
