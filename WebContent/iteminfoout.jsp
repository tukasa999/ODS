<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Item"%>
	<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%	Item item = new Item();
	item = (Item)session.getAttribute("item");
	String cname = (String)session.getAttribute("cname");%>
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
	<table border="1">
	<tr><td>犬名</td><td><%= StringEscapeUtils.escapeHtml4(item.getName()) %></td></tr>
	<tr><td>値段</td><td><%= item.getPrice() %></td></tr>
	<tr><td>犬種</td><td><a href="Category?cid=<%=item.getCid() %>"><%= StringEscapeUtils.escapeHtml4(cname) %></a></td></tr>
	</table>
	<img style="width:50%;" src="GetImage?id=<%= item.getSid() %>">
	<% if(item.getStatus().equals("未購入")){ %>
	<a href="Cartinsert?sid=<%= item.getSid() %>">カートに追加</a>
	<% }else{%>
	<p>売り切れ</p>
	<%} %>
	
	<%@include file="footer.jsp"%>
</body>
</html>

<% }%>