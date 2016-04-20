
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<p>${message}</p>
<form method="post" action="index">
    <input type="email" name="login">
    <input type="password" name="pass">
    <button type="submit">Войти</button>
</form>
</body>
</html>
