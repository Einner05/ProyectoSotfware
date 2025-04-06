package login.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        String nombre = request.getParameter("nombre");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            String url="jdbc:mysql://localhost:3306/servletlogin";
            Connection conexion = DriverManager.getConnection(url, "root", "");

            //String query = "INSERT INTO usuarios (usuario, contraseña, nombre) VALUES (?, ?, ?)";
            String query = "INSERT INTO usuarios (usuario, contraseña, nombre) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ps.setString(3, nombre);

            ps.executeUpdate();

            //Redirigir a login despues de registrarse
            response.sendRedirect("index.html");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            response.sendRedirect("registro.html?error=1");
            
        
    }
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
