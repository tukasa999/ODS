<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet" />
<link href="./css/style.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="./js/materialize.js"></script>
<script src="./js/script.js"></script>
</head>

<body>

	<nav class="light-blue darken-1 nv">
		<div class="nav-wrapper container">
			<a href="top.jsp" class="brand-logo">ODS<label>オンラインドッグショップ</label></a>
			<a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down nv">
				<li><a href="mypage.jsp">マイページ</a></li>
				<li><a href="top.jsp">トップへ</a></li>
				<%  String uid = (String)session.getAttribute("userid");
					if(uid == null){%>
				<li><a href="Loginuser">ログアウト</a></li>
				<%}else{ %>
				<li><a href="login.jsp">ログイン</a></li>
				<%} %>
			</ul>
			<ul class="side-nav" id="mobile-demo">
				<li><a href="mypage.jsp">マイページ</a></li>
				<li><a href="top.jsp">トップへ</a></li>
				<% if(uid == null){%>
				<li><a href="Loginuser">ログアウト</a></li>
				<%}else{ %>
				<li><a href="login.jsp">ログイン</a></li>
				<%} %>
			</ul>
		</div>
	</nav>
	<div class="parallax-container">
		<div class="parallax">
			<img src="./img/inu.jpg" class="responsive-img">
		</div>
	</div>



</body>

</html>