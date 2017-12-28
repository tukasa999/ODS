<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%	%>
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
	<a href="Itemout" class="button">商品一覧</a>
	<a href="Cartout" class="button">カート</a>
	<a href="Categorylist" class="button">カテゴリー</a>
	<a href="search.jsp" class="button">商品検索</a>
	<%@include file="footer.jsp"%>
</body>
</html>

<% }%>