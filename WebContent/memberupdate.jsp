<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Userinfo"%>
	<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%	
	Userinfo userinfo = (Userinfo)session.getAttribute("userinfo");
	%>
<!DOCTYPE html>
<html lang="ja">

<head>
<%  String userid = (String)session.getAttribute("userid");
String manager = (String)session.getAttribute("manager");
	if(userid == null || manager==null){%>
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
	<p>変更ユーザーのID:<%= StringEscapeUtils.escapeHtml4(userinfo.getUserid()) %></p><br>
	<form action="Memberupdate" method="post">
	<input type="text" name="mail" value="<%=StringEscapeUtils.escapeHtml4(userinfo.getMail()) %>">
	<input type="text" name="address" value="<%=StringEscapeUtils.escapeHtml4(userinfo.getAddress()) %>">
	<input type="submit" value="更新" class="button">
	</form>
	<a href ="Memberdelete" class="button">ユーザー削除</a>
	<%@include file="footer.jsp"%>
</body>
</html>

<% }%>