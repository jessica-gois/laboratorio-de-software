<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<title>Cadastro</title>
<style>
.cabecalho-ecomm {
	background: #7209b7;
	color: white;
	font-size: 20px;
	font-family: Verdana;
	padding: 20px;
}

.fonte-admin {
	color: white;
	font-size: 16px;
	font-family: Verdana;
}
</style>
</head>
<body>
	<form action="${stub }" method="post">
		<div class="cabecalho-ecomm mb-3 p-3 d-flex justify-content-between">
		<span> TURMA DO LIVRO </span> <span class="fonte-admin"> admin</span>
		</div>


		<div class="container">
			<nav class="navbar navbar-expand navbar-light bg-light mb-3">
				<div class="navbar-nav col-8 me-2">
					<a class="nav-link " href="">comprar livros</a> 
					<a class="nav-link " href="/ecommerce/controlador?acao=ListaClientes"> minha conta </a> 
					<a class="nav-link " href="/ecommerce/controlador?acao=CadastraClienteFormulario"> cadastro </a> 
					<a class="nav-link " href=""> meus pedidos</a> 
					<a class="nav-link " href="/ecommerce/controlador?acao=Login"> login </a> 
					<a class="nav-link " href="/ecommerce/controlador?acao=Logout"> sair </a>
				</div>

				<div class="container-fluid">
					<form class="d-flex">
						<input class="form-control me-2" type="search" placeholder="escreva o que procura">
						<button class="btn btn-secondary" type="submit">busca</button>
					</form>
				</div>
			</nav>



			<div class="card">
				<div>
					<h1 class="card-header">CADASTRO</h1>
				</div>
				<div>
					<div class="card-header">
						<p>Meus dados</p>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-10 mb-3">
								<div>Nome: <input class="form-control" type="text" name="nome" /></div>
								<div>Data de Nascimento: <input class="form-control" type="text"name="dataNascimento" /></div>
								<div>CPF: <input class="form-control" type="text" name="cpf" /></div>
								<div>Score: <input class="form-control" type="text" name="score" /></div>
								<div>Status: <input class="form-control" type="text" name="status" /></div>
								<input type="hidden" name="acao" value="CadastraCliente" />

								<div class="card-body">
									<button class="btn btn-secondary" type="submit">Enviar</button>
								</div>


							</div>
							<div class="col-2 ">
								<img class="img-thumbnail" src="imagens/perfil.jpg" alt="Foto de perfil" width="100%" height="100%">
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>