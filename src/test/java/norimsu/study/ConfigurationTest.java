package norimsu.study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class ConfigurationTest {

    @Test
    void same() {
        // test1
        final Common common = new Common();
        assertThat(common).isSameAs(common);

        // test2
        assertThat(new Common()).isNotSameAs(new Common());
    }

    @Test
    void configuration1() {
        MyConfig myConfig = new MyConfig();
        final Bean1 bean1 = myConfig.bean1();
        final Bean2 bean2 = myConfig.bean2();

        assertThat(bean1.common).isNotSameAs(bean2.common);
    }

    @Test
    void configuration2() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        final Bean1 bean1 = ac.getBean(Bean1.class);
        final Bean2 bean2 = ac.getBean(Bean2.class);

        assertThat(bean1.common).isSameAs(bean2.common);
    }

    @Test
    void configuration3() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfigNoProxy.class);
        ac.refresh();

        final Bean1 bean1 = ac.getBean(Bean1.class);
        final Bean2 bean2 = ac.getBean(Bean2.class);

        assertThat(bean1.common).isNotSameAs(bean2.common);
    }

    @Test
    void proxyCommonMethod() {
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        final Bean1 bean1 = myConfigProxy.bean1();
        final Bean2 bean2 = myConfigProxy.bean2();

        assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyConfigProxy extends MyConfig {

        private Common common;

        @Override
        Common common() {
            if (this.common == null) {
                this.common = super.common();
            }
            return this.common;
        }
    }

    @Configuration(proxyBeanMethods = false)
    static class MyConfigNoProxy {

        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    @Configuration(proxyBeanMethods = true)
    static class MyConfig {

        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common()); // SAME with proxy
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common()); // SAME with proxy
        }
    }

    static class Bean1 {

        private final Common common;

        Bean1(Common common) {
            this.common = common;
        }
    }


    static class Bean2 {

        private final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }

    private static class Common {

    }
}
