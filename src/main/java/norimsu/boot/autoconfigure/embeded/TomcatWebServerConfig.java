package norimsu.boot.autoconfigure.embeded;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import norimsu.boot.autoconfigure.MyAutoConfiguration;
import norimsu.boot.autoconfigure.condition.ConditionalMyOnClass;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Value("${contextPath:}") String contextPath;
    @Value("${port:8080}") int port;

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        final TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        System.out.println("contextPath = " + contextPath);
        factory.setContextPath(this.contextPath);
        factory.setPort(this.port);
        return factory;
    }
}
