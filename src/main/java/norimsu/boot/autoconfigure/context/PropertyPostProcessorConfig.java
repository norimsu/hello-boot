package norimsu.boot.autoconfigure.context;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
import static org.springframework.core.annotation.AnnotationUtils.getAnnotationAttributes;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
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
                final MyConfigurationProperties annotation = findAnnotation(bean.getClass(),
                                                                            MyConfigurationProperties.class);
                if (annotation == null) return bean;
                final Map<String, Object> attr = getAnnotationAttributes(annotation);
                final String prefix = (String) attr.get("prefix");
                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }
}
