<%@page import="Server_Connecter.Userinfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
    <h2>Welcome</h2>
    <% 
        HttpSession sessionuid = request.getSession();
        String uid = (String) sessionuid.getAttribute("uid");
        String userInfo = Userinfo.getUserInfo(uid);
    %>
    
    <p><%= userInfo %></p>
    
    <form action="logout.jsp" method="post">
        <input type="submit" value="Logout">
    </form>
    
</body>
</html>
