<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votre commande</title>
</head>
<body>

	<ul>
		<li>
			<span style="color: #f6ab29">Nom du produit:</span>
			<span> ${produit.name} </span></li>
		<li>
			<span style="color: #f6ab29">Quantité commandé :</span>
			<span> ${cmd.qtCom} </span></li>
	</ul>

</body>
</html>