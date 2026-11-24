package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoggingFilter implements Filter {

    private String prefix = "[LOG]";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String customPrefix = filterConfig.getInitParameter("logPrefix");

        if (customPrefix != null && !customPrefix.trim().isEmpty()) {
            this.prefix = customPrefix;
        }

        System.out.println(prefix + " Initialisation du LoggingFilter.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        long startTime = System.nanoTime();

        // ->: execute avant servlet
        System.out.println(prefix + " [->] Interception requete : " + httpRequest.getRequestURI());

        chain.doFilter(request, response);

        // <-: exec apres la servlet
        long durationMs = (System.nanoTime() - startTime) / 1_000_000;

        System.out.println(prefix + " [<-] reponse envoye pour : "
                + httpRequest.getRequestURI() + " (Temps : " + durationMs + " ms)");
    }

    @Override
    public void destroy() {
        System.out.println(prefix + " Destruction du LoggingFilter.");
    }
}