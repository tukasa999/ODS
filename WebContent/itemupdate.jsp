<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
    <%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
    <%
    ArrayList<String> name = new ArrayList<String>();
    name = (ArrayList<String>)session.getAttribute("iname");
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
	<h1>アイテム一覧</h1>
	<%for(String iname :name ){%>
	<a href="Iteminfo?name=<%= StringEscapeUtils.escapeHtml4(iname) %>"><%=StringEscapeUtils.escapeHtml4(iname) %></a>
	<% } %>

</body>
</html>

<% }%>