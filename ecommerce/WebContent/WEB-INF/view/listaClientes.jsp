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
	<!-- <div class="card-header hidden">
	<p>Usuário logado: ${usuarioLogado.email} </p>
	</div>-->	
	
			<div class="container">
				<div class="card shadow">
				<div>
				<h1 class="card-header">MINHA CONTA</h1>

					
					<div class="card-header">
					<h3>Meus dados</h3>
					</div>
					<div>
						
					<div class="container">	
					<div class="card-body">	
					<div class="row">			
					<div>
					
					<div class="col-10">
					<table class="table">
					<thead class="table table-dark table-striped">
    					<tr>
        					<th>Nome</th>
        					<th>Sobrenome</th>
        					<th>Data de nascimento</th>
        					<th>CPF</th>
        					<th>E-mail</th> 
        					<th>Score</th>
        					<th>Status</th>
    				 	</tr>
    				</thead>
						<tbody> 
						<c:forEach items="${clientes}" var="cliente"> 
							<tr>  				
        						<td>${cliente.nome}</td>
        						<td>${cliente.sobrenome}</td>
        						<td><fmt:formatDate value="${cliente.dataNascimento }" pattern="dd/MM/yyyy"/></td>
       							<td>${cliente.cpf}</td>
        						<td>${cliente.email}</td>
        						<td>${cliente.score}</td>
        						<td>${cliente.status}</td>
        					</tr>
        				</tbody>
					</div>
					
			
					<div class="col-2">
					<a class="btn btn-secondary w-25" alt="Atualizar dados" title="Atualizar dados" href="/ecommerce/controlador?acao=MostraCliente&id=${cliente.id}"><i class="far fa-edit"></i></a>		
					</br>										
					<!-- <a href="/ecommerce/controlador?acao=RemoveCliente&id=${cliente.id }">remove</a>-->	
    				</c:forEach>
    				</div>
    			
    				
				</table>	
			</div>								
		</div>
<br/>
	
       				
        				
	
	<div class="container">
		<section class="card shadow">
			<div class="card-header">
				<h3>Senha</h3>
			</div>
			
			<div class="card-body">
				<div class="row">
					<div>
						<a class="btn white" href="#"><p>Alterar senha</p></a>
					</div>
				</div>
			</div>
		</section>
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
				<div class="container">
					<a href="#">Desativar conta</a>
				</div>
				<br/>
			</div>
				</div>
				</div>
		</body>
</html>