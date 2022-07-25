<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Usuario</title>
	</head>
	<body>
		Login Usuario:<br><br>
		${msg}
		<form action="LoginUsuario" method="post">
			<input type="text" name="nome" value=""><br><br>
			<input type="password" name="senha" value="">
			<br><br>
			<input type="submit">
		</form>
		<br>
		Se cadastre <a href="AdicionarUsuario">aqui!</a>
	</body>
</html>