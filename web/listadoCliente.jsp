<%-- 
    Document   : listadoCliente
    Created on : 27-may-2014, 18:25:30
    Author     : marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="WEB-INF/jspf/validarSession.jspf" %>
<%
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Listado de todos los clientes</title>
    </head>
    <body>
        <table border="0">
            
            <tbody>
                <tr>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>Direccion</td>
                    <td>Email</td>
                    <td>Telefono</td>
                    <td>Localidad</td>
                    <td>Acciones</td>
                    <td>${sessionScope.us}</td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

        
    </body>
</html>
