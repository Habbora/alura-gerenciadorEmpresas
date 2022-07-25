<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Adicionar Empresa</title>
	</head>
	<body>
		Adicionar Usuario:<br><br>
		${msg}
		<form action="${acao}" method="post">
			<input type="hidden" name="id" value="${usuario.chaveId}">
			<label>Nome Completo: </label>
			<input type="text" name="nome" value="${usuario.nome}"><br><br>
			<label>Nickname: </label>
			<input type="text" name="nickname" value="${usuario.nickname}"><br><br>
			<label>Senha: </label>
			<input type="password" name="senha"><br><br>
			<label>Repetir Senha: </label>
			<input type="password" name="senha2"><br><br>
			<input type="submit">
		</form>
		<br>
		Voltar para o login <a href="LoginUsuario">aqui!</a>
	</body>
</html>