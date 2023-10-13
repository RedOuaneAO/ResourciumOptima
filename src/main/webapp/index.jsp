<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Inserting into database</a>--%>
<form action="hello-servlet" method="post">
    <label>First Name</label><br>
    <input type="text" name="fName"><br>
    <label>Second Name</label><br>
    <input type="text" name="sName"><br>
<%--     <label>User Name</label><br>--%>
<%--    <input type="text"><br>--%>
<%--     <label>Email</label><br>--%>
<%--    <input type="email"><br>--%>
<%--    <label>Password</label><br>--%>
<%--    <input type="password">--%>
    <button type="submit">send</button>
</form>
</body>
</html>