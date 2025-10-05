<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login Page</h1>

<form action="${url.loginAction!''}" method="post">
    <label>Username:</label>
    <input name="username" value="${login.username!''?html}"/>

    <label>Password:</label>
    <input type="password" name="password"/>

    <button type="submit">Login</button>
</form>
</body>
</html>
