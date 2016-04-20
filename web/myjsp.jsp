<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Hello ${login}!</h1>
You are ${role}.
<p>Go to <a href="/loggger_war_exploded/userpage">user page</a></p>
<p>Go to <a href="/loggger_war_exploded/adminpage">admin page</a></p>
<form method="post">
    <button type="submit">Log out</button>
</form>
</body>
</html>