package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("appName", "MP2_web_app");

        System.out.println("[APP-LISTENER] app demarree - attribut 'appName' initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[APP-LISTENER] app arretee.");
    }
}