<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
    <%
    String msg = (String)session.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<%  String userid = (String)session.getAttribute("userid");
	if(userid == null){%>
	<meta http-equiv="refresh"content="1; url=login.jsp">
	<%}else{ %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>退会確認</h1>
	<% if(msg != null){ %><%=StringEscapeUtils.escapeHtml4(msg) %><%} %>

	<p>パスワードを入力してね
	</p>
	<form action ="Taikai" method="post">
	<input type="password" name="pass">
	<input type="submit" value="退会">
	</form>

</body>
</html>

<% }%>