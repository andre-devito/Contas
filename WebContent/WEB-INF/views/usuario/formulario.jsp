<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de Login</title>
</head>
<body>

	<h3>Login</h3>
	
	<form action="efetuaLogin" method="post">
	
		Login: <input type="text" name="login" />
		<br/>
		Senha: <input type="password" name="senha" />
		<br/><br/>
	
		<input type="submit" value="Entrar na lista de contas" />
	
	</form>	

</body>
</html>
