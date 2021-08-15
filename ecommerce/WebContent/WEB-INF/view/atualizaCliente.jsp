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
					<h1 class="card-header">ATUALIZAÇÃO DE CADASTRO</h1>
					</div>
					
					<div class="card-header">
						<h3>Dados pessoais</h3>
					</div>

				<div class="card-body">
					<div class="row">
					 	<div class="col-10 mb-3">
							<form action="${stub}" method="post">
								<div>Nome: <input class="form-control" type="text" name="nome" value="${cliente.nome}" required="true" /></div>
								<div class="row d-flex justify-content-between">
									<div class="col-md-6">
										Data de Nascimento:
										<input class="form-control" type="text" name="dataNascimento" value="${cliente.dataNascimento}" required="true" /></div>
									<div class="col-md-6">CPF:
									<input class="form-control" type="text" name="cpf" value="${cliente.cpf}" required="true"/></div>
								</div>
								<div>E-mail: <input class="form-control" type="email" name="email" value="${cliente.email}" required="true"/></div>
											
								<input type="hidden" name="id" value="${cliente.id}" />
								<input type="hidden" name="acao" value="AtualizaCliente" />
								<br/>
								<button class="btn btn-secondary w-25" type="submit">Salvar</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br/>
	<div class="container">
		<section class="card shadow">
			<div class="card-header">
				<h3>Meus cartões</h3>
			</div>
			<div class="card-body">
				<div class="row">
					<div>
						<a class="btn white" href="#"><p>Cadastrar novo</p></a>
					</div>
				</div>
			</div>
		</section>
	</div>
	<br/>
	<div class="container">
		<section class="card shadow">
			<div class="card-header">
				<h3>Endereços</h3>
			</div>
			<div class="card-body">
				<div class="row">
					<div>
						<a class="btn white" href="#"><p>Adicionar novo endereço</p></a>
					</div>
				</div>
			</div>
		</section>
	</div>
	<br/>
	<br/>


</body>
</html>