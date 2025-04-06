package login.servtlets.api;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Este servlelet respode a /api/usuarios
@WebServlet(name = "usuariosApiServlet", urlPatterns = {"/api/usuarios"})
public class UsuariosApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Indicamos que respondemos con JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //Simulamos datos de usuario (más adelante los traemos de la base de datos)
        String jsonUsuarios ="""
            [
                {"id": 1, "usuario": "juan", "nombre": "Juan Perez"},
                {"id": 2, "usuario": "maria", "nombre": "Maria Lopez"}
            ]
            """;
        
        PrintWriter out= response.getWriter();
        out.print(jsonUsuarios);
        out.flush();

    }

}
