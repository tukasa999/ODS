<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Userinfo"%>
	<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%	
	Userinfo user = (Userinfo)session.getAttribute("userinfo");
	%>
<!DOCTYPE html>
<html lang="ja">

<head>
<%  String userid = (String)session.getAttribute("userid");
	if(userid == null){%>
	<meta http-equiv="refresh"content="1; url=login.jsp">
	<%}else{ %>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<title>となりのシティ</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="./css/materialize.css" rel="stylesheet"
	media="screen,projection" />
<link href="./css/style.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="./js/materialize.js"></script>
<script src="./js/script.js"></script>
</head>

<body>
	<%@include file="header.jsp"%>
	<h1>ユーザー情報更新</h1>
	<p>あなたのID:<%= StringEscapeUtils.escapeHtml4(user.getUserid()) %></p><br>
	<form action="Userupdate" method="post">
	<input type="text" name="mail" value="<%=StringEscapeUtils.escapeHtml4(user.getMail()) %>">
	<input type="text" name="address" value="<%=StringEscapeUtils.escapeHtml4(user.getAddress()) %>">
	<input type="submit" value="更新" class="button">
	
	</form>

	<%@include file="footer.jsp"%>
</body>
</html>

<% }%>