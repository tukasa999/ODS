<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="model.Userinfo"%>
    <%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%	ArrayList<Userinfo> users = new ArrayList<Userinfo>();
	users = (ArrayList<Userinfo>)session.getAttribute("users");
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
	<table border="1">
	<tr><td>会員名</td></tr>
	<%for(Userinfo user:users ){%>
	<tr>
	<td><a href="Memberupdate?id=<%=StringEscapeUtils.escapeHtml4(user.getUserid())%>">
	<%= StringEscapeUtils.escapeHtml4(user.getUserid()) %></a></td>
	</tr>
	<% }%>
	</table>
	<a href="ownerpage.jsp">戻る</a>
	<%@include file="footer.jsp"%>
</body>
</html>
<% }%>