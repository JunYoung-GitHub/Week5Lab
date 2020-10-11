<%-- 
    Document   : home.jsp
    Created on : Oct 9, 2020, 6:27:14 PM
    Author     : 710429
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1><br>
        
        <h2>Hello ${username}</h2><br>
        
        <p><a href="login?action=logout">Logout</a></p>
    </body>
</html>
