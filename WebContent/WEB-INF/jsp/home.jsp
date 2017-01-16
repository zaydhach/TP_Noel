<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<title>Bienvenue</title>
<link rel="stylesheet" href="/Project/css/style.css" />
<title>Liste des produits</title>
</head>
<body>
	<h1>Bienvenue dans notre application</h1>

	<form class="form" method="POST">
		<button type="button" 
			onclick="self.location.href='http://localhost:8080/Noel/actions/cadeaux/login'">
			Connexion</button>
		<button type="button"
			onclick="self.location.href='http://localhost:8080/Noel/actions/cadeaux/listeProduits'">Effectuer une commande</button>
	</form>
</body>
</html>