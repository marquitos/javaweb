<%-- 
    Document   : index
    Created on : 28-may-2014, 0:29:15
    Author     : marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logueo de usuario</title>        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <form name="flog" action="loguinUsuario" method="post">
                <p>Nombre:<input type="text" name="user"/></p>
                <p>Password:<input type="password" name="pass"/></p>
                <p><input type="submit" value="Ingresar" /></p>
            </form>
        </div>
    </body>
</html>
