<%@page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="santhu.springjdbc.practice.demo1.model.Student" %>
<html>
<head>
    <title>Searched Students</title>
    <link rel="stylesheet" type="text/css" href="ShowSearchedStudents.css">
</head>
<body>
<% List<Student> students = (List<Student>) request.getAttribute("students");
%>
<table>
    <tr>
    <th>Student Id</th><th>Student Name</th><th>Student Marks</th><th>Student Gender</th>
    </tr>
    <%
        for(Student student : students){
    %>
    <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getMarks() %></td>
            <td><%= student.getGender() %></td>
    </tr>
    <%
        }
    %>
</table>
<button onclick="window.location.href='/'">Return to home Page</button>
</body>
</html>