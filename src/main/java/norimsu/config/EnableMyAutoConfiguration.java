package norimsu.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import norimsu.config.autoconfig.DispatcherServletConfig;
import norimsu.config.autoconfig.TomcatWebServerConfig;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({TomcatWebServerConfig.class, DispatcherServletConfig.class})
public @interface EnableMyAutoConfiguration {

}
