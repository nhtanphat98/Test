<%-- 
    Document   : StudentList
    Created on : Oct 21, 2020, 7:34:30 PM
    Author     : Admin
--%>


<%@page import="DBUtils.StudentDAO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Student</title>
    </head>
    <body>
        <a>${msg}</a>
        <h1><b>List Of Students</b></h1>
        <form action="StudentManagerServlet" method="POST">
            <input type="hidden" name="action" value="Search"/>
            Search By Id: <input type="text" name="txtSearchById"/>
            <input type="submit" value="Search" />
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>ClassId</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sline" items="${data}">

                <tr>
                    <td>${sline.id}</td>
                    <td>${sline.name}</td>
                    <td>${sline.age}</td>
                    <td>${sline.classId}</td>
                    <td><a href="StudentManagerServlet?action=updateForm&sid=${sline.id}">Edit</a></td>
                    <td><a href="StudentManagerServlet?action=Delete&sid=${sline.id}">Delete</a></td>
                </tr>
                </c:forEach>
            </tbody>

        </table>
            <form action="StudentManagerServlet" method="POST">
                <input type="hidden" name="action" value="newForm"/>
                <input type="submit" value="Add New"/>
            </form>
    </body>
</html>
