package norimsu.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

    public static void run(Class<?> appliocationClass, String... args) {
        final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                final ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                final DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                //dispatcherServlet.setApplicationContext(this); // ApplicationContextAware

                final WebServer webServer = serverFactory.getWebServer(servletContext -> servletContext.addServlet(
                        "dispatcherServlet",
                        dispatcherServlet).addMapping("/*"));
                webServer.start();
            }
        };
        applicationContext.register(appliocationClass);
        applicationContext.refresh();
    }
}