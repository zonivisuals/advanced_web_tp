package servlets;

import model.SessionUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (username != null && !username.trim().isEmpty()) {

            HttpSession session = request.getSession(true);

            session.setAttribute("user", username);
            session.setAttribute("userBindingObj", new SessionUser(username));

            out.println("<html><body>");
            out.println("<h3>bienvenue, " + username + " ! connexion reussie.</h3>");
            out.println("<p><a href='ListItems'>acceder a la liste des articles protegee</a></p>");
            out.println("<p><a href='ShowSession'>consulter l'etat de la session</a></p>");
            out.println("</body></html>");

        } else {
            response.sendRedirect("login.html");
        }
    }
}