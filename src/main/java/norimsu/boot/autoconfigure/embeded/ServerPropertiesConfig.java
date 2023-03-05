package norimsu.boot.autoconfigure.embeded;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import norimsu.boot.autoconfigure.MyAutoConfiguration;

@MyAutoConfiguration
public class ServerPropertiesConfig {


    @Bean
    public ServerProperties serverProperties(Environment env) {
        final ServerProperties properties = new ServerProperties();
        properties.setContextPath(env.getProperty("contextPath", ""));
        properties.setPort(env.getProperty("port", Integer.class, 8080));
        return properties;
    }
}