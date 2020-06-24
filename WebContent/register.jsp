<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="twitter.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twitter</title>
</head>
<body>
<h1>新規会員登録</h1>
<hr>
<form action="RegisterServlet" method="post">
userid:<input type="text" name="userid" pattern="^@[0-9A-Za-z]+$" value="@" required>(半角英数字6文字以上)<br>
username:<input type="text"name="username" required><br>
password:<input type="password" name="password" pattern="^[0-9A-Za-z]+$" required><br>

<input type="submit" value="登録">
</form>
<form action="login.jsp"method="post">
<input type="submit" value="ログイン画面へ">
</form>


</body>
</html>