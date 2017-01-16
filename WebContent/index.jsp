<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%-- rediriger le contrôleur noel --%>
<c:redirect url="/home.htm"/>

<html>
	<head>
	<title>Example :: Spring Application</title>
	</head>
	<body>
		<h1>Example - Spring Application</h1>
		<p>This is my test.</p>
		<p>
			<a
				href="http://docs.spring.io/spring/docs/4.3.3.RELEASE/spring-framework-reference/html/index.html">Documentation</a>
		</p>
		<p>
			<a
				href="http://docs.spring.io/spring/docs/4.3.3.RELEASE/javadoc-api/index.html">JavaDoc</a>
		</p>
	</body>
</html>