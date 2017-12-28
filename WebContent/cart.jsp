<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="model.Cart" import="dao.Itemdao" import="model.Item"%>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%	ArrayList<Cart> carts = new ArrayList<Cart>();
	Itemdao dao = new Itemdao();
	carts = (ArrayList<Cart>)session.getAttribute("carts");%>
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
	<%for(Cart cart:carts ){%>
	<% Item item = new Item();
	item = dao.getitem(cart.getS_id());%>
	<tr>
	<td><a href="Iteminfoout?id=<%=cart.getS_id()%>">
	<%= StringEscapeUtils.escapeHtml4(item.getName()) %></a></td>
	<td><%=item.getPrice() %>円</td>
	<td><a href="Cartitemdelete?cid=<%= cart.getCartid()%>">削除</a>
	</tr>
	<% }%>
	</table>
	<a href="Kessai?uid=<%=userid %>">購入</a>
	<%@include file="footer.jsp"%>
</body>
</html>
<% }%>