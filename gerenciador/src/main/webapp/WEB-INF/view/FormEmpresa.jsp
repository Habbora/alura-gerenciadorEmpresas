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
		<c:import url="MenuGeral.jsp"></c:import>
		Adicionar Empresa:<br><br>
		<form action="${acao}">
			<input type="hidden" name="acao" value="${acao}">
			<input type="hidden" name="id" value="${empresa.chaveId}">
			<input type="text" name="nome" value="${empresa.nome}"><br><br>
			<input type="submit">
		</form>
	</body>
</html>