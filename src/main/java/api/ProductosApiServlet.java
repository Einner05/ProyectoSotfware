package api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "ProductosApiServlet", urlPatterns = {"/api/productos"})
public class ProductosApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONArray productosArray = new JSONArray();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sistemaventa", "root", "");

            String sql = "SELECT * FROM productos";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JSONObject producto = new JSONObject();
                producto.put("id", rs.getInt("id"));
                producto.put("codigo", rs.getString("codigo"));
                producto.put("nombre", rs.getString("nombre"));
                producto.put("proveedor", rs.getString("proveedor"));
                producto.put("stock", rs.getInt("stock"));
                producto.put("precio", rs.getDouble("precio"));
                producto.put("fecha", rs.getString("fecha"));

                productosArray.put(producto);
            }

            rs.close();
            ps.close();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.print(productosArray.toString());
        out.flush();
    }
}
