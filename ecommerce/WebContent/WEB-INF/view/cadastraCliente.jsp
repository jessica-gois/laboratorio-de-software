<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="stub"/>

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
					<h1 class="card-header">CADASTRO</h1>
					</div>
					
						<div class="card-header">
						<p>Meus dados</p>
					</div>
		
					<div class="card-body">
						<div class="row">
							<div class="col-10 mb-3">
								<form action="${stub }" method="post">
								<div>Nome: <input class="form-control" type="text" name="nome" /></div>
								<div>Data de Nascimento: <input class="form-control" type="text"name="dataNascimento" /></div>
								<div>CPF: <input class="form-control" type="text" name="cpf" /></div>
								<div>Score: <input class="form-control" type="text" name="score" /></div>
								<div>Status: <input class="form-control" type="text" name="status" /></div>
								<input type="hidden" name="acao" value="CadastraCliente" />
								

								<div class="card-body">
								<button class="btn btn-secondary" type="submit">Enviar</button>	
								</div>
								</form>


							</div>
							<div class="col-2 ">
								<img class="img-thumbnail" src="imagens/perfil.jpg" alt="Foto de perfil" width="100%" height="100%">
							</div>
							
						</div>
					</div>
				</div>
			</div>
</body>
</html>