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
					<h1 class="card-header">ALTERAR SENHA</h1>
					</div>
					
					<div class="card-header">
						<p>Informe a nova senha</p>
					</div>

				<div class="card-body">
					<div class="row">
					 	<div class="col-10 mb-3">
							<form action="${stub}" method="post">	
							
								<div class="row d-flex justify-content-between">
								<div class="col-md-6"> <input class="form-control" type="hidden"  name="nome" value="${cliente.nome}" required="true" /></div>
								<div class="col-md-6"> <input class="form-control" type="hidden"  name="sobrenome" value="${cliente.sobrenome}" required="true" /></div>
								</div>
								
								<div class="row d-flex justify-content-between">
								<div class="col-md-6"> <input class="form-control"  type="hidden"  name="dataNascimento" value="<fmt:formatDate value="${cliente.dataNascimento }" pattern="dd/MM/yyyy"/>" required="true" /></div>
								<div class="col-md-6"> <input class="form-control" type="hidden"  name="cpf" value="${cliente.cpf}" required="true"/></div>
								</div>
								
								<div><input class="form-control" type="hidden" name="email" value="${cliente.email}" required="true"/></div>
								
								<div class="row d-flex justify-content-between">
								<div class="col-md-6"> Nova senha: <input class="form-control" type="password" name="senha" value="${cliente.senha}" required="true"/></div>
								<div class="col-md-6"> Senha: <input class="form-control" type="password" name="confirmacaoSenha" value="${cliente.confirmacaoSenha}" required="true"/></div>								
								</div>
								
							

								<div><input type="hidden"  name="score" value ="700" /></div>
								<div><input type="hidden" name="status"  value ="true"/></div>									
								
								<input type="hidden" name="id" value="${cliente.id}" />
								<input type="hidden" name="acao" value="AtualizaCliente" />
								<br/>
								
								<button class="btn btn-secondary w-25" type="submit" alt="Salvar" title="Salvar"><i class="fas fa-save"></i></button>
								
								
								<a href="/ecommerce/controlador?acao=ListaClientes" class="btn white border w-25" type="submit" alt="Cancelar" title="Cancelar">
									<i class="fas fa-ban"></i>
								</a>								
							</form>
						</div>
					<br/>
			</body>
</html>