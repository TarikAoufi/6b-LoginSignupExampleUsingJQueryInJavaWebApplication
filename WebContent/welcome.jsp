<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Page d'accueil</title>
<link rel="stylesheet" href="js/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
<div class="wrapper">
	<div class="container">
		<%
			String user = (String) session.getAttribute("user");
			if (user != null) {
		%>
		<h3>
			Bienvenue
			<%
				out.print(user);
			%>
			</h3>
			<a href="LoginController?param=logout">Se d�connecter</a>
			<%
				} else {
			%>
			<h3>Vous n'�tes pas autoris� � acc�der � cette page !!</h3>
			<%
				}
			%>
	</div>
</div>
</body>
</html>