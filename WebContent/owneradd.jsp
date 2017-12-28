<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8" import="java.util.ArrayList" import="model.Userinfo"%>
    <%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%	ArrayList<Userinfo> users = new ArrayList<Userinfo>();
	users = (ArrayList<Userinfo>)session.getAttribute("users");
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp"%>
	<table border="1">
	<tr><td>会員名</td></tr>
	<%for(Userinfo user:users ){%>
	<tr>
	<td><a href="Owneradd?id=<%=StringEscapeUtils.escapeHtml4(user.getUserid())%>">
	<%= StringEscapeUtils.escapeHtml4(user.getUserid()) %></a></td>
	</tr>
	<% }%>
	</table>
	<a href="ownerpage.jsp">戻る</a>
	<%@include file="footer.jsp"%>
</body>
</html>