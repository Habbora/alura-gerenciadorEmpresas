<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
	<li>Usuario conectado: ${usuarioNome}; <a href="LogoutUsuario">Logout</a></li>
	<li><a href="ListarEmpresas">Listar Empresas</a></li>
	<li><a href="AdicionarEmpresa">Adicionar Empresas</a></li>
	<c:if test="${usuarioNivel > 4}">
		<c:import url="MenuAdmin.jsp"></c:import>
	</c:if>
</ul>