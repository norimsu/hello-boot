package norimsu.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

public class HelloBootApplication {

    public static void main(String[] args) {
        final ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        final WebServer webServer = serverFactory.getWebServer();
        webServer.start();
    }

}
