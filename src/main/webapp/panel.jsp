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
    <title>Panel de usuario</title>
    <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
    >
</head>
<body>
    <main class="container">
        <h2>Bienvenido, <%= sessionUsuario.getAttribute("usuario") %>!</h2>
        <p>Has iniciado sesión correctamente.</p>
        
        <form action="logout" method="get">
            <button type="submit">Cerrar sesión</button>
        </form>
    </main>
</body>
</html>
