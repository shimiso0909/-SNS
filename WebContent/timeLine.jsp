<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "beans.*" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="twitter.css">
<head>
<%
	List <TimeLineBean> list=(List <TimeLineBean>)session.getAttribute("tweet");
	List<UserBean>userlist=(List<UserBean>)session.getAttribute("userlist");
	UserBean user=(UserBean)session.getAttribute("user");

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twitter</title>
</head>
<body>
<h1>TimeLine</h1>
<hr>
<%

for(TimeLineBean timeline:list){
	
	out.println("<form action=\"DeleteServlet\"　method=\"get\">");
	out.println("<h4>"+timeline.getUserName()+"  "+timeline.getUserId()+"</h4>");
	out.println("<h2>"+timeline.getText()+"</h2>"+timeline.getDate()+" "+timeline.getTime()); 
	if(timeline.getUserId().equals(user.getUserId())){
		out.println("<input type=\"hidden\" name=\"delete\" value=\""+timeline.getText()+"\">");
		out.println("<input type=\"hidden\" name=\"date\" value=\""+timeline.getDate()+"\">");
		out.println("<input type=\"hidden\" name=\"time\" value=\""+timeline.getTime()+"\">");
		out.println("<input type=\"submit\" value=\"削除\">");
		out.println("</form>"+"<hr>");
		
	}else{
		out.println("<input type=\"hidden\" name=\"delete\" value=\""+timeline.getText()+"\">");
		out.println("<input type=\"hidden\" name=\"date\" value=\""+timeline.getDate()+"\">");
		out.println("<input type=\"hidden\" name=\"time\" value=\""+timeline.getTime()+"\">");
		out.println("<input type=\"submit\" value=\"削除\" disabled>");
		out.println("</form>"+"<hr>");
	}
		
	
	
}
%>
<form action="tweet.jsp" method="get">
<input type="submit" value="投稿画面へ">
</form>
<form action="LogoutServlet" method="post">
<input type="submit" value="ログアウト">
</form>


</body>
</html>