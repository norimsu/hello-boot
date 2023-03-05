package norimsu.boot.autoconfigure.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import norimsu.boot.autoconfigure.MyAutoConfiguration;
import norimsu.boot.autoconfigure.MyConfigurationProperties;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

    @Bean
    BeanPostProcessor propertyPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                final MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(),
                                                                                            MyConfigurationProperties.class);
                if (annotation == null) return bean;
                return Binder.get(env).bindOrCreate("", bean.getClass());
            }
        };
    }
}
