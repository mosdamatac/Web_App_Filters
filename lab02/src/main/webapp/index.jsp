<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css"/>
	<title>Lab 02</title>
</head>
<body>
<div id="wrapper">
	<header>
		<h2>${initParam.course}</h2>
		<h4>${initParam.author }</h4>
	</header>
	<div id="main">
		<img src="${pageContext.request.contextPath}<%= request.getAttribute("imgPath") %>"/>
		<p><span class="spanHead">My name is Duke. What is yours?</span></p>
		<br/><br/>
		<form>
			<input type="text" name="nameTb">
			<input type="submit" value="Submit"/>
			<input type="reset"/>
		</form>
		<br/><br/>
		<%
		System.out.println(request.getAttribute("name"));
		if (request.getAttribute("name") != null) {
		%>
		<span class="spanHead">Hello, <%= request.getAttribute("name") %></span>
		<%} %>
	</div>
	<footer>&copy; ${initParam.footer }</footer>
</div>
</body>
</html>
