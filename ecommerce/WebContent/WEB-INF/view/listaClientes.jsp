<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List,model.domain.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<c:import url="template-head.jsp"/>
	<title>Cadastro</title>
</head>
<body>

<header>
	<c:import url="template-header.jsp"/>
	</header>


			<div class="container">
				<div class="card">
					<div>
					<h1 class="card-header">MEU CADASTRO</h1>
					</div>
					
						<div class="card-header">
						<p>Usu�rio logado: ${usuarioLogado.email} </p>
					</div>		

	<div class="card-body">
	<div class="row">
	<div class="col-10 mb-3">		
	<ul style="list-style: none;">
		<c:forEach items="${clientes}" var="cliente">
			
			<li>		
				<h2> ${cliente.nome } </h2>		
				<a href="/ecommerce/controlador?acao=MostraCliente&id=${cliente.id }">atualiza</a>
				</br>
				<a href="/ecommerce/controlador?acao=RemoveCliente&id=${cliente.id }">remove</a>
				
			</li>
		</c:forEach>
	</ul>

</body>
</html>