<%-- 
    Document   : login_form.jsp
    Created on : Mar 6, 2015, 10:35:13 AM
    Author     : adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CheckLogin" method="POST">
            <input type="text" name="username" > <br>
            <input type="password" name="password" > <br>
            <input type="submit" value="Log In" >
        </form>
    </body>
</html>
