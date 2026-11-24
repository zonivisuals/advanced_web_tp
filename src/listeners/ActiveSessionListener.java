package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private static final AtomicInteger activeSessions = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int count = activeSessions.incrementAndGet();

        se.getSession().getServletContext().setAttribute("activeSessions", count);

        System.out.println("[SESSION-LISTENER] session cree ID=" + se.getSession().getId() + ". total actives : " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        int count = activeSessions.decrementAndGet();

        se.getSession().getServletContext().setAttribute("activeSessions", count);

        System.out.println("[SESSION-LISTENER] session detruite ID=" + se.getSession().getId() + ". total actives : " + count);
    }
}