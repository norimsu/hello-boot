package norimsu.boot.autoconfigure.condition;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

public class MyOnClassCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final Map<String, Object> attr = metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
        final String value = (String) attr.get("value");
        return ClassUtils.isPresent(value, context.getClassLoader());

    }
}
