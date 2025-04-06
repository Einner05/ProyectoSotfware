package productos.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;

@WebServlet(name = "ProductosServlet", urlPatterns = {"/productos"})
public class ProductosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String[]> productos = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sistemaventa";
            Connection conexion = DriverManager.getConnection(url, "root", "");

            String query = "SELECT id, codigo, nombre, proveedor, stock, precio, fecha FROM productos";
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {
                String[] fila = {
                    rs.getString("id"),
                    rs.getString("codigo"),
                    rs.getString("nombre"),
                    rs.getString("proveedor"),
                    rs.getString("stock"),
                    rs.getString("precio"),
                    rs.getString("fecha")};
                productos.add(fila);
            }
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("productos", productos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productos.jsp");
        dispatcher.forward(request, response);
    }

    // Llamar a processRequest desde GET y POST
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
