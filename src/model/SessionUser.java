package model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionUser implements HttpSessionBindingListener {

    private String username;

    public SessionUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("[BINDING] object SessionUser (" + username + ") connected to the session : " + event.getSession().getId());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("[BINDING] obj SessionUser (" + username+ ") is removed from session : " + event.getSession().getId());
    }
}