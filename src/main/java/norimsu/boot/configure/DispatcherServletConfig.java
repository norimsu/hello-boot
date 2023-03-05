package norimsu.boot.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import norimsu.boot.MyAutoConfiguration;

@MyAutoConfiguration
public class DispatcherServletConfig {

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}
