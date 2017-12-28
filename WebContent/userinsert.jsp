<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%	
	String dist = (String)session.getAttribute("dist"); 
	%>
<!DOCTYPE html>
<html lang="ja">

<head>

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
	<%if(dist != null){ %>
	<h5 style="color:red"><%= dist %><%} %></h5>
	<form method="post" action="Userinsert">
	<table>
	<tr><td>あなたのID</td><td><input type="text" name="id"></td></tr>
	<tr><td>パスワード</td><td><input type="password" name="pass"></td></tr>
	<tr><td>メールアドレス</td><td><input type="text" name="mail"></td></tr>
	<tr><td>住所</td><td><input type="text" name ="address" value="長崎県となり市うえ町89-1"></td></tr>
	</table>
	<input type="submit" class="button" value="登録">
	</form>


	<%@include file="footer.jsp"%>
</body>
</html>