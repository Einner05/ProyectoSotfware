<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession sessionUsuario = request.getSession(false);
    if (sessionUsuario == null || sessionUsuario.getAttribute("usuario") == null) {
        response.sendRedirect("index.html?error=1");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Panel Principal</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
        <link rel="stylesheet" href="style.css">       
    </head>
    <body>

        
        <header class="header">
            
            <!-- Biemvenida -->
            
            <h1>Bienvenido, <%= sessionUsuario.getAttribute("usuario")%>!</h1>
            
            <!-- Botón de cerrar sesión arriba a la derecha--> 
            
            <form action="logout" method="get" class="top-right">
                <button type="submit" class="secondary">Cerrar sesión</button>
            </form>
        </header>

           



        <main class="main-contend">
            <!--Botones-->                      

            <div Class="button-group">
                <a href="productos" role="button">Productos</a>
                <a href="clientes" role="button">Clientes</a>
                <a href="proveedores" role="button">Proveedores</a>
            </div>
            <!--Descripcion-->                            
            <p>Has iniciado sesión correctamente. Puedes navegar por las secciones del sistema.</p>                     
            <hr>
        </main>
    </body>
</html>
