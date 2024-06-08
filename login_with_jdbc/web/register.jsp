<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
</head>
<body>
    <h2>Register</h2>
    <form action="register" method="post">
        UID (Email): <input type="email" name="uid" required><br>
        Nickname: <input type="text" name="nickname" required><br>
        Password: <input type="password" name="password" required><br>
        Confirm Password: <input type="password" name="check_password" required><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
