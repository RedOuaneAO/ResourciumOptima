<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form action="hello-servlet">
    <label>First Name</label><br>
    <input type="text"><br>
    <label>Second Name</label><br>
    <input type="text"><br>
     <label>User Name</label><br>
    <input type="text"><br>
     <label>Email</label><br>
    <input type="email"><br>
    <label>Password</label><br>
    <input type="password">

</form>
</body>
</html>