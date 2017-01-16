<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Modification</h1>
	<div class="edit">
		<form:form method="POST" commandName="produits">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td><span style="font-weight: bold">Nom :</span></td>
					<td><form:input path="nom" /></td>
					<td><form:errors path="nom" cssClass="error" /></td>
				</tr>
				<tr>
					<td><span style="font-weight: bold">Prix :</span></td>
					<td><form:input path="prix" /></td>
					<td><form:errors path="prix" cssClass="error" /></td>
				</tr>
				<tr>
					<td><span style="font-weight: bold">Quantité :</span></td>
					<td><form:input path="qtProd" /></td>
					<td><form:errors path="qtProd" cssClass="error" /></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit">Valider</button></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>