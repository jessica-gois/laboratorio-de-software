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
						<h2>Dados pessoais</h2>
					</div>

				<div class="card-body">
					<div class="row">
					 	<div class="col-12 mb-3">
							<form action="${stub}" method="post">	
							
								<div class="row d-flex justify-content-between">
								<div class="col-md-5">Nome: <input class="form-control" type="text" name="nome" value="${cliente.nome}" required="true" /></div>
								<div class="col-md-5">Sobrenome: <input class="form-control" type="text" name="sobrenome" value="${cliente.sobrenome}" required="true" /></div>
								<!-- <div class="col-md-2">Gênero: <input class="form-control" type="text" name="genero" value="${cliente.genero}" required="true" /></div>-->
								<div class="col-md-2"><label for="cidade">Gênero:</label> 
									<select class="form-control" name="genero" value="${cliente.genero}" required="true">
										<option value="">Escolha...</option>
										<option value="FEMININO">Feminino</option>
										<option value="MASCULINO">Masculino</option>
									</select>										
								</div>	
								</div>
								
								
								<div class="row d-flex justify-content-between">				
								<div class="col-md-2">DDD: <input class="form-control" type="text" name="dddResidencial" value="${cliente.dddResidencial} required="true" placeholder="00" /></div>
								<div class="col-md-4">Telefone residencial: <input class="form-control" type="tel" name="numeroTelResidencial" value="${cliente.numeroTelResidencial} placeholder="0000-0000" required="true" /></div>
								<div class="col-md-2">DDD: <input class="form-control" type="text" name="dddCelular" value="${cliente.dddCelular} required="true" placeholder="00" /></div>
								<div class="col-md-4">Telefone celular: <input class="form-control" type="tel" name="numeroTelCelular" value="${cliente.numeroTelCelular} placeholder="00000-0000" required="true" /></div>													
								</div>	
								
								<div class="row d-flex justify-content-between">
								<div class="col-md-6">Data de nascimento: <input class="form-control"  type="text" name="dataNascimento" value="<fmt:formatDate value="${cliente.dataNascimento }" pattern="dd/MM/yyyy"/>" required="true" /></div>
								<div class="col-md-6">CPF: <input class="form-control" type="text" name="cpf" value="${cliente.cpf}" required="true" disabled="true"/></div>
								</div>
								
								<div>E-mail: <input class="form-control" type="email" name="email" value="${cliente.email}" required="true"/></div>						
							

								<div><input type="hidden"  name="score" value ="700" /></div>
								<div><input type="hidden" name="status"  value ="true"/></div>									
								
								<input type="hidden" name="id" value="${cliente.id}" />
								<input type="hidden" name="acao" value="AtualizaCliente" />
								<br/>
								
								<button class="btn btn-secondary w-25" type="submit" alt="Salvar" title="Salvar"><i class="fas fa-save"></i></button>
								
								
								<a href="/ecommerce/controlador?acao=ListaClientes" class="btn white border w-25" type="submit" alt="Voltar" title="Voltar">
									<i class="fas fa-long-arrow-alt-left"></i>
								</a>								
							</form>
						</div>
					<br/>
			</body>
</html>