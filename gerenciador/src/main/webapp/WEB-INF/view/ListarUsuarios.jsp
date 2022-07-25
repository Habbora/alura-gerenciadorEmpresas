<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listar Usuarios</title>
	</head>
	<body>
		<c:import url="MenuGeral.jsp"></c:import>
		Lista de usuarios cadastradas:
		<table>
			<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>Nome: ${usuario.nome} - </td>
				<td>Nickname: ${usuario.nickname}; </td>
				<td><a href="EditarUsuario?id=${usuario.chaveId}">Editar</a></td>
				<td><a href="ApagarUsuario?id=${usuario.chaveId}">Apagar</a></td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>