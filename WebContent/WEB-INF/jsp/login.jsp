<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>
	<h1>Bienvenue</h1>
	<font>${loginError}</font>
	<form class="form" action="login" method="POST">
		<input type="text" placeholder="E-mail" name="email"> 
		<input type="password" placeholder="mot-de-passe" name="password">
		<button type="submit">Connexion</button>
	</form>
</body>
</html>