package norimsu.boot.autoconfigure.embeded;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import norimsu.boot.autoconfigure.MyAutoConfiguration;

@MyAutoConfiguration
public class ServerPropertiesConfig {


    @Bean
    public ServerProperties serverProperties(Environment env) {
        return Binder.get(env).bind("", ServerProperties.class).get();
    }
}