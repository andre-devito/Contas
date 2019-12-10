<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Contas</title>
</head>
<body>

	<h3>Benvindo ao Sistema de Contas, ${usuarioLogado.login}!</h3>
	
	<br/>
	
	<form action="efetuaLogout" method="post">
		<input type="submit" value="Logout" />
	</form>		

</body>
</html>
