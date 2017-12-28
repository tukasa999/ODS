<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList" import="model.Orderm" import="model.Item"
	import="dao.Itemdao"%>
	<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%	ArrayList<Orderm> userorders = new ArrayList<Orderm>();
	Itemdao dao = new Itemdao();
	userorders = (ArrayList<Orderm>)session.getAttribute("orderm");%>
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
	<tr><th>商品</th><th>金額</th></tr>
	<%for(Orderm order:userorders){ %>
	<% Item item = new Item();
	item = dao.getitem(order.getSid());%>
	<tr>
	<td><a href="Iteminfoout?id=<%=order.getSid()%>"><%= StringEscapeUtils.escapeHtml4(item.getName()) %></a></td>
	<td><%=order.getPrice() %></td>
	
	</tr>
	<%} %>
	</table>
	
	<%@include file="footer.jsp"%>
</body>
</html>
<% }%>
