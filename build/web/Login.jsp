<%-- 
    Document   : Login
    Created on : Nov 10, 2020, 9:48:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="demo.css"
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    
    <body>
        <div class="loginbox">
            <img src="avatar.png" class="avatar">
        <h1>Login</h1>
        <table>
            <form action="StudentManagerServlet" method="POST">
                <input type="hidden" name="action" value="Login"/>
                Username: <input type="text" name="txtUsername" placeholder="Enter Username"/></br>
                Password: <input type="password" name="txtPassword" placeholder="Enter Password "/></br>
                <input type="submit" value="Login"/>
                <input type="reset" value="Reset"/>
            </form>     
        </table>
        </div>
    </body>
</html>
