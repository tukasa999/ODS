<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	String loginMsg = (String)session.getAttribute("login"); 
	String message="";
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
	<div class="section"></div>
	<main>
	<center>

		<h5 class="indigo-text">ログイン情報を入力してください</h5>
		<% if(loginMsg != null){ %>
		<small class="error">IDとパスワードを正しく入力してください</small>
		<%} %>
		<div class="section"></div>

		<div class="container">
			<div class="z-depth-1 grey lighten-4 row"
				style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

				<form class="col s12" method="post" action="Loginuser">
					<div class='row'>
						<div class='col s12'></div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='text' name='memberid' id='email' />
							<label for='email'>ログインID</label>
						</div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='password' name='password'
								id='password' /> <label for='password'>パスワード</label>
							
						</div>
						<label style='float: right;'> <a class='pink-text'
							href='userinsert.jsp'><b>新規会員登録はこちら</b></a>
						</label>
					</div>

					<br />
					<center>
						<div class='row'>
							<button type='submit' name='btn_login'
								class='col s12 btn btn-large waves-effect indigo'>Login</button>
						</div>
					</center>
				</form>
			</div>
		</div>
		
	</center>

	<div class="section"></div>
	<div class="section"></div>
	</main>

	<% session.invalidate(); %>
	<%@include file="footer.jsp"%>
</body>
</html>