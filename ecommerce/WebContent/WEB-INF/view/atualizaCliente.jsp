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
				<div class="card">
					<div>
					<h1 class="card-header">ATUALIZAÇÃO DE CADASTRO</h1>
					</div>
					
						<div class="card-header">
						<p>Meus dados</p>
					</div>

		<div class="card-body">
			<div class="row">
			 	<div class="col-10 mb-3">	
				<form action="${stub }" method="post">
				<div>Nome: <input class="form-control" type="text" name="nome" value="${cliente.nome}" /> </div>
				<div>Data de Nascimento: <input class="form-control" type="text"name="dataNascimento" value="<fmt:formatDate value="${cliente.dataNascimento }" pattern="dd/MM/yyyy"/> " /></div>
				<div>CPF: <input class="form-control" type="text" name="cpf" value="${cliente.cpf}"/> </div>
				<div>Score: <input class="form-control" type="text" name="score"  value="${cliente.score}" /> </div>
				<div>Status: <input class="form-control" type="text" name="status" value="${cliente.status}" /> </div>
	
				<input type="hidden" name="id" value="${cliente.id }" />
				<input type="hidden" name="acao" value="AtualizaCliente" />
				
		
				<div class="card-body">
				<button class="btn btn-secondary" type="submit">Enviar</button>
				</div>
				</form>

				</div>
			</div>
		</div>
	</body>
</html>