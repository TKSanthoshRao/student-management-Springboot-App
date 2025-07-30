<%@page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="santhu.springjdbc.practice.demo1.model.Student" %>

<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>

<html>
<head>
    <title>All Students</title>
    <link rel="stylesheet" type="text/css" href="viewAllStudents.css">
</head>
<body>
<h2>All Students</h2>
<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Marks</th><th>Gender</th>
    </tr>
    <%
        for (Student student : students) {
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
    <button type="button" onclick="window.location.href='/'">Go to Home Page</button>
</body>
</html>
