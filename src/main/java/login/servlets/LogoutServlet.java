package login.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para cerrar sesión
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalida la sesión actual
        request.getSession().invalidate();
        
        // Redirige al login con un mensaje
        response.sendRedirect("index.html?logout=1");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para cerrar sesión del usuario.";
    }
}