package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ListItems")
public class ListItemsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("");
        out.println("\nliste des articles (espace securise)\n");

        out.println("\n- ");
        out.println("\n- article 1 : ordinateur portable\n- ");
        out.println("\n- article 2 : clavier mecanique\n- ");
        out.println("\n- article 3: ecran 4k\n- ");

        out.println("\n\n");

        out.println("\n\nvoir ma session / deconnexion\n\n");

        out.println("");
    }
}