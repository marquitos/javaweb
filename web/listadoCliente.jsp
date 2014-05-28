<%-- 
    Document   : listadoCliente
    Created on : 27-may-2014, 18:25:30
    Author     : marcos
--%>

<%@page import="com.cliente.conexion.ConexionBD"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="WEB-INF/jspf/validarSession.jspf" %>
<%
    ResultSet resul = ConexionBD.query_all();
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Listado de todos los clientes</title>
    </head>
    <body>
        <a href="agregarCliente.jsp">Agregar Clientes</a> -
        <a href="salir.jsp">Salir</a>
        <a href="listaTotal">Listar Clientes</a>
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
                <% if(resul.next()){%>
                <tr>
                    <td> <% out.println(resul.getString("nombre"));%> </td>
                    <td><% out.println(resul.getString("apellido"));%></td>
                    <td><% out.println(resul.getString("direccion"));%></td>
                    <td><% out.println(resul.getString("email"));%></td>
                    <td><% out.println(resul.getString("tel"));%></td>
                    <td><% out.println(resul.getString("localidad"));%></td>
                    <td><a href="editarUsuario?id=<%=resul.getString("id")%>">Edi</a>-
                        <a href="eliminarUsuario?id=<%=resul.getString("id")%>">Eli</a>
                    </td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>

        
    </body>
    
</html>
