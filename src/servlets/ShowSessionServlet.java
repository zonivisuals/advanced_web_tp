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

        out.println("");
        out.println("infos sur la session\n");

        out.println("nbr de sessions actives sur le serveur"
                + activeUsers + "\n");

        if (session != null && session.getAttribute("user") != null) {

            out.println("\nuser connected : "
                    + session.getAttribute("user") + "\n");

            out.println("\nID de session : "
                    + session.getId() + "\n");

            out.println("");

        } else {

            out.println("\n\n no session active pour votre navigateur.\n");

            out.println("se connecter");
        }

        out.println("");
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