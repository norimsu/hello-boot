package norimsu.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigurationImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "norimsu.config.autoconfig.DispatcherServletConfig", "norimsu.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
