<%-- 
    Document   : WelcomePage
    Created on : Mar 3, 2015, 10:45:26 AM
    Author     : adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <p>Welcome ${username} <a href="login_form.jsp">Log Out</a></p>
        <form method="POST" action="AddComment">
            <input type="text" name="comment">
            <input type="submit" value="Post Comment">
        </form>
        <a href="LoadComments">View Comments</a>
    </body>
</html>
