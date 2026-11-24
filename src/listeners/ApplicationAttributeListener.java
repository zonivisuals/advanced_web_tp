package listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("[APP-ATTR] add attribut application : "+ event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("[APP-ATTR] replace attribut application : "+ event.getName() + " = " + event.getValue());

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("[APP-ATTR] delete attribut application : "+ event.getName() + " = " + event.getValue());

    }
}