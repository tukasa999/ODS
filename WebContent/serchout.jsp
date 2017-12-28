<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList" import="model.Item"%>
	<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%	ArrayList<Item> items = new ArrayList<Item>();
	items = (ArrayList<Item>)session.getAttribute("sitems");%>
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
	<tr><td>アイテム名</td><td>値段</td></tr>
	<%for(Item item :items ){%>
	<tr>
	<td><a href="Iteminfoout?id=<%=item.getSid()%>">
	<%=StringEscapeUtils.escapeHtml4(item.getName()) %></a></td>
	<td><%=item.getPrice() %>円</td>
	</tr>
	<% }%>
	</table>
	<%@include file="footer.jsp"%>
</body>
</html>

<% }%>