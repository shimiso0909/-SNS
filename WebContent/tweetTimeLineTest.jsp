<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.*" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="twitter.css">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TweetTimeLineTest</title>
</head>
<body>
<!-- ヘッダーでツイート画面を固定します -->
<header>
<h2>Home</h2>
<form action="TweetServlet" method="post">
ツイート内容:<input type="text" name="tweet" style="line-height: 60px; width: 500px; height: 60px;">
<input type="submit" value="投稿">
</form>

</header>
<div class="TimeLine">
<h1>TimeLine</h1>
<hr>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>
<h1>TimeLine</h1>

<h1>TimeLine</h1>
<h1>TimeLine</h1>

<form action="tweet.jsp" method="get">
<input type="submit" value="投稿画面へ">
</form>
<form action="LogoutServlet" method="post">
<input type="submit" value="ログアウト">
</form>
</div>

</body>
</html>