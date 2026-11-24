package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("[SESSION-ATTR] attribut added : "+ event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("[SESSION-ATTR] attribute modified : "+ event.getName() + " (prev value: " + event.getValue() + ")");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("[SESSION-ATTR] attribute deleted : " + event.getName());
    }
}