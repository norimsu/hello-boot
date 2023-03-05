package norimsu.boot.autoconfigure.web.embeded;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import norimsu.boot.autoconfigure.EnableMyConfigurationProperties;
import norimsu.boot.autoconfigure.MyAutoConfiguration;
import norimsu.boot.autoconfigure.condition.ConditionalMyOnClass;
import norimsu.boot.autoconfigure.web.ServerProperties;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
@EnableMyConfigurationProperties(ServerProperties.class)
public class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        final JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());
        return factory;
    }
}
