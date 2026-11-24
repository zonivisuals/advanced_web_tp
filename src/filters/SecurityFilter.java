package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/ListItems"})
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        if (loggedIn) {
            System.out.println("[SECURITY] access autorise pour l'user : " + session.getAttribute("user"));

            chain.doFilter(request, response); //resume la chaine

        } else {
            System.out.println("[SECURITY] accees refuse a " + httpRequest.getRequestURI()
                    + ". Redirection vers login.html.");

            //interruption de la chaine
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
        }
    }

    @Override
    public void destroy() {}
}