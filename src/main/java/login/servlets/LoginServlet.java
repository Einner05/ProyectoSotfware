package login.servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario=request.getParameter("usuario");
        String contraseña=request.getParameter("contraseña");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String url="jdbc:mysql://localhost:3306/servletlogin";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        try{
            conexion=(Connection) DriverManager.getConnection(url,"root","");
            statement=conexion.createStatement();
            rs=statement.executeQuery("SELECT * FROM `usuarios` WHERE `usuario` = '"+usuario+"' AND `contraseña` = '"+contraseña+"'");
            if(rs.next()){
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("panel.jsp");
            }else{
                response.sendRedirect("index.html?error=1");
            }
            
        }catch(SQLException ex){
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }


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

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
