<!DOCTYPE html>
<html>
<head>
<title>Page de connexion et d'inscription</title>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">

<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery-ui.js"></script>

<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>

</head>

<body>
	<div class="wrapper">
		<div class="container">
			<div id="tabs">
				<ul>
					<li><a href="#login">Se connecter</a></li>
					<li><a href="#register">S'inscrire</a></li>
				</ul>
				<div id="login">
					<% 
  	if((String)session.getAttribute("error") != null){ %>
					<h4 style ="color:red"><%=session.getAttribute("errorLog") %></h4>
					<%} %>
					<form method="post" action="LoginController">
						<label for="email">Email:</label> 
						<br/> 
						<input type="text"	name="email" id="email" /> 
						<br /> 
						<label for="password">Mot de passe:</label>
						<br/> 
						<input type="password" name="password" id="password" /> 
						<br/>
						<br/> 
						<input type="submit" value="Valider">
					</form>
				</div>
				<div id="register">
					<% 
  	if((String)session.getAttribute("errorReg") != null){ %>
					<h4 style ="color:red"><%=session.getAttribute("errorReg") %></h4>
					<%} %>
					<form method="post" action="RegistrationController">
						<label for="nom">Nom:</label><br /> 
						<input type="text" name="nom" id="nom" /> 
						<br/> 
						<label for="email">Email:</label>
						<br/>
						<input type="text" name="email" id="email" /> 
						<br/> 
						<label	for="password">Mot de passe:</label>
						<br/> 
						<input type="password" name="password" id="password" /> 
						<br/> 
						<label for="adresse">Adresse:</label>
						<br/>
						<input type="text" name="adresse" id="adresse" /> 
						<br/> 
						<br /> 
						<input type="submit" value="Valider">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>