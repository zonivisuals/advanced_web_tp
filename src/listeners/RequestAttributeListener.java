package listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("[REQ-ATTR] add request attribute : "+ srae.getName() + " = " + srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("[REQ-ATTR] replace request attribute : "+ srae.getName() + " = " + srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("[REQ-ATTR] del request attribute : "+ srae.getName() + " = " + srae.getValue());
    }
}