<%-- 
    Document   : StudentForm
    Created on : Oct 21, 2020, 7:34:46 PM
    Author     : Admin
--%>

<%@page import="StudentDTO.StudentDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Form</title>
    </head>
    <body>
        <h1>Student Form</h1>
        <h1>${msg}</h1>
        <table border="0">
            <form action="StudentManagerServlet" method="Post" name="f1">
                <input type="hidden" name="action" value="${action}"/>           
                <tr>
                    <td>Student ID: </td>
                    <td><input type="text" name="id" value="${sObject.id}"/><font color="red">${err.idErr}</front></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" value="${sObject.name}"><font color="red">${err.nameErr}</front></td>
                </tr>
                <tr>
                    <td>Age: </td>
                    <td><input type="text" name="age" value="${sObject.age}"/><font color="red">${err.ageErr}</front></td>
                </tr>
                <tr>
                    <td>ClassId: </td>
                    <td><input type="text" name="classId" value="${sObject.classId}"/><font color="red">${err.classIdErr}</front></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="${action}"/>
                        <input type="reset" value="Reset" />
                    </td>
                </tr>
            </form>
        </table>
                        
    </body>
</html>
