<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList" import="model.Order"%>
	<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%	ArrayList<Order> userorders = new ArrayList<Order>();
	userorders = (ArrayList<Order>)session.getAttribute("userorders");%>
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
	<table>
	<tr><th>日付</th><th>合計金額</th><th>詳細</th></tr>
	<%for(Order order:userorders){ %>
	<tr>
	<td><%=order.getBuydate() %></td>
	<td><%=order.getGprice() %></td>
	<td><a href="Historyinfo?cid=<%=order.getChunum() %>">詳細へ</a></td>
	</tr>
	<%} %>
	</table>
	
	<%@include file="footer.jsp"%>
</body>
</html>

<% }%>