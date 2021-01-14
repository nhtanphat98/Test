<%-- 
    Document   : SearchStudent
    Created on : Oct 21, 2020, 7:35:01 PM
    Author     : Admin
--%>

<%@page import="phat.dto.StudentDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <%
        StudentDTO dto = (StudentDTO) request.getAttribute("sObject");
        String header = (String) request.getAttribute("msg");
    %>
    <body>
        <h1><%=header%></h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID:</th>
                    <th>Name:</th>
                    <th>Age:</th>
                    <th>ClassId:</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=dto.getId()%></td>
                    <td><%=dto.getName()%></td>
                    <td><%=dto.getAge()%></td>
                    <td><%=dto.getClassId()%></td>
                </tr>
            </tbody>
        </table>
                <a href="StudentManagerServlet">Back to Student List</a>
    </body>
    
</html>
