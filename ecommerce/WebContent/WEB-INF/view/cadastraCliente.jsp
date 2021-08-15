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
				<div class="card shadow">
					<div>
					<h1 class="card-header">CADASTRO</h1>
					</div>
					
						<div class="card-header">
						<h3>Meus dados</h3>
					</div>
		
					<div class="card-body">
						<div class="row">
							<div class="col-10 mb-3">
								<form action="${stub }" method="post">
								<div>Nome: <input class="form-control" type="text" name="nome" required="true" /></div>
								<div class="row d-flex justify-content-between">
									<div class="col-md-6">Data de Nascimento: <input class="form-control" type="text" name="dataNascimento" required="true" /></div>
									<div class="col-md-6">CPF: <input class="form-control" type="text" name="cpf" required="true"/></div>
								</div>
								<div>E-mail: <input class="form-control" type="email" name="email" required="true"/></div>
								<div class="row d-flex justify-content-between">
								<div class="col-6">
									<label for="senha">Nova Senha:</label>
									<input class="form-control" type="password" name="senha" required="true"/>									
								</div>
								<div class="col-6">
									<label for="confirmacaoSenha"> Confirme a nova senha:</label>
									<input class="form-control" type="password" name="confirmacaoSenha" required="true"/>
								</div>
								</div>
								<input type="hidden" name="acao" value="CadastraCliente" />								
								
								<br/>	
								<div>
									<button class="btn btn-secondary w-25" type="submit">Enviar</button>	
									<button class="btn white border w-25" type="reset">Limpar</button>	
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