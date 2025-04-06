<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%
//Recuperar la lista de productos del request
    List<String[]> productos = (List<String[]>) request.getAttribute("productos");
%>

<!DOCTYPE html>

<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Lista de Productos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <main>            
            <h2>Productos</h2>
            <table role="grid">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Proveedor</th>
                        <th>Stock</th>
                        <th>Precio</th>
                        <th>Fecha</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (productos != null && !productos.isEmpty()) {
                            for (String[] producto : productos) {
                    %>
                    <tr>
                        <td><%= producto[0]%></td>
                        <td><%= producto[1]%></td>
                        <td><%= producto[2]%></td>
                        <td><%= producto[3]%></td>
                        <td><%= producto[4]%></td>
                        <td><%= producto[5]%></td>
                        <td><%= producto[6]%></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td>colspan="7">No se encontro producto.</td>    
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
                <a href="panel.jsp" role="button">volver al panel</a>
        </main>
    </body>
</html>

