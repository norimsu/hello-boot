package norimsu.boot.autoconfigure.context;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import norimsu.boot.autoconfigure.MyAutoConfiguration;

@MyAutoConfiguration
public class PropertyPlaceHolderConfig {

    @Bean
    @ConditionalOnMissingBean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
