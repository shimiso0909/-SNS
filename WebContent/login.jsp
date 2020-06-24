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
<h1>ログイン</h1>
<hr>
<form action="LoginServlet" method="post">
userid:<input type="text" name="userid" pattern="^@[0-9A-Za-z]+$" value="@" required><br>
password:<input type="password"name="password" pattern="^[0-9A-Za-z]+$" required><br>
<input type="submit"value="ログイン">
</form>
<form action="register.jsp"method="post">
<input type="submit" value="新規会員登録">
</form>


</body>
</html>