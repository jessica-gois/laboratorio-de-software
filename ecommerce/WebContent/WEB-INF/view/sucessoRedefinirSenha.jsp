<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
	<c:import url="template-head.jsp"/>
	<title>Atualiza</title>
</head>

<body>
	<header>
	<c:import url="template-header.jsp"/>
	</header>


			<div class="container">
				<div class="card shadow">
					<div>
					<h1 class="card-header">SUCESSO</h1>
					</div>
					
					<div class="card-header">
						<p>E-mail de redefinição de senha enviado! Siga as instruções e faça o
						<a href="/ecommerce/controlador?acao=Logout">login</a>
						novamente.
						</p>
					</div>
					

				
				
			</body>
</html>