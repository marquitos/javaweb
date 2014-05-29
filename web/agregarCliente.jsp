<%-- 
    Document   : agregarCliente
    Created on : 28-may-2014, 17:52:32
    Author     : marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar clientes</title>
    </head>
    <body>
        <form name="formCli" action="agregarCliente" method="post">
            <p><label for="nombre">Nombre:</label>
                <input type="text" name="nombre" id="nombre" required autofocus placeholder="Nombre"></p>  
            <p><label for="apellido">Apellido:</label>
                <input type="text" name="apellido" id="apellido" required placeholder="Apellido"></p>
            <p><label for="direccion">Direccion:</label>
                <input type="text" name="direccion" id="direccion" required placeholder="Direccion actual"></p>
            <p><label for="correo">Direccion de correo:</label>
                <input type="email" name="correo" id="correo" required placeholder="ejemplo@ejemplo.com"></p>
            <p><label for="tel">Telefono:</label>
                <input type="tel" name="tel" id="tel" pattern="[0-9]{9}" required placeholder="+543534133846"></p>
            <p><label for="pass">Password:</label>
                <input type="password" name="pass" id="pass" pattern="[a-z]{3}[0-9]{4}" required placeholder="aqw12345" ></p>
            <p><label for="loca">Localidad:</label>
                <input type="text" name="localidad" id="loca" required placeholder="Localidad"></p>
            
            <input type="submit" value="Agregar">
            
        </form>
    </body>
</html>
