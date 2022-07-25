<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Empresas</title>
</head>
<body>
	<c:import url="MenuGeral.jsp"></c:import>
	Lista de empresas cadastradas:
	<table>
		<c:forEach items="${empresas}" var="empresa">
			<tr>
				<td>ID: ${empresa.chaveId} -</td>
				<td>Nome: ${empresa.nome};</td>
				<td><a href="EditarEmpresa?id=${empresa.chaveId}">Editar</a></td>
				<td><a href="ApagarEmpresa?id=${empresa.chaveId}">Apagar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>