<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
UserBean user=(UserBean)session.getAttribute("user");
%>
<link rel="stylesheet" href="twitter.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twitter</title>
</head>
<body>
<h2>Tweet</h2>
<%
out.println("<h4>"+user.getUserName()+"さん ようこそ</h4>");

%>
<hr>
<form action="TweetServlet" method="post">
ツイート内容:<input type="text" name="tweet" style="line-height: 60px; width: 500px; height: 60px;">
<input type="submit" value="投稿">
</form>
<hr>
<form action="timeLine.jsp" method="get">
<input type="submit" value="タイムラインへ">
</form>
<form action="LogoutServlet" method="post">
<input type="submit" value="ログアウト">
</form>



</body>
</html>