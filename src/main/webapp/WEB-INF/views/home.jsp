<%@page language="java"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
<h1>Welcome to Student Management System</h1>
    <ol>
        <li> Add Student</li>
        <li> Delete Student</li>
        <li> Update Student</li>
        <li> View All Students</li>
        <li> Search Student</li>
    </ol>
<form action="/handleChoice" method="post">
    <label for="choice">Enter your choice:</label>
    <input type="text" name="choice" id="choice">
    <input type="submit" value="Submit">
</form>

</body>
</html>