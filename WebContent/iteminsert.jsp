<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"%>
	<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<% ArrayList<String> category = new ArrayList<String>();
    category = (ArrayList<String>)session.getAttribute("category");
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
	<h1>商品登録</h1>
	<form action="Iteminsert" method="post" enctype="multipart/form-data">
	<div class="input-field col s12">
	<table border="0">
	<tr><td>犬名</td><td><input type="text" name ="name"></td></tr>
	<tr><td>価格</td><td><input type="text" name="price"></td></tr>
	<tr><td>写真</td><td><input type="file" name="image"></td></tr>
	<tr><td>カテゴリー</td><td>
	<div class="input-field col s12">
	<select name="category">
<%
for(String cate :category ){%>
	<option value="<%=StringEscapeUtils.escapeHtml4(cate) %>"><%= StringEscapeUtils.escapeHtml4(cate) %></option>
	<% }%>
	</select>
	</div>
	</td></tr>
	</table>
	<input type="submit" class="button" value="送信">
	</form>
	

</body>
</html>

<% }%>