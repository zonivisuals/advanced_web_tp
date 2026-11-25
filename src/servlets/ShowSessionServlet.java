package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ShowSession")
public class ShowSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        Integer activeUsers = (Integer) getServletContext().getAttribute("activeSessions");

        if (activeUsers == null) {
            activeUsers = 0;
        }

        out.println("<html><body>");
        out.println("<h2>informations sur la session</h2>");
        out.println("<p><b>nombre de sessions actives sur le serveur :</b> " + activeUsers + "</p>");

        if (session != null && session.getAttribute("user") != null) {

            out.println("<p>utilisateur connecte : " + session.getAttribute("user") + "</p>");
            out.println("<p>id de session : " + session.getId() + "</p>");

            out.println("<form action='ShowSession' method='POST'>");
            out.println("<input type='submit' value='se deconnecter'>");
            out.println("</form>");

        } else {

            out.println("<p>aucune session active pour votre navigateur.</p>");
            out.println("<a href='login.html'>se connecter</a>");
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect("login.html");
    }
}