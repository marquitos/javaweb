<%-- 
    Document   : salir
    Created on : 28-may-2014, 0:42:04
    Author     : marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Desloquearse</title>
    </head>
    <body>
        <h1>Saliendo del sistema....</h1>
    </body>
</html>
