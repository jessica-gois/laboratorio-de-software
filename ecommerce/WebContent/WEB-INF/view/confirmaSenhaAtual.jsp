<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp"/>
<title>Confirma��o de senha</title>
</head>
<body>
	<header>
	<c:import url="template-header.jsp"/>
	</header>


			<div class="container">
				<div class="card shadow">
					<div>
					<h1 class="card-header">CONFIRMA��O DE SENHA</h1>
					</div>
					
						<div class="card-header"> 
						<p>Insira a senha atual cadastrada</p>
					</div>

	
		
					<div class="card-body">
						<div class="row">
							<div class="col-6 mb-3 mr-0">
							
								<form action="${stub }" method="post">
								<div class="col-8">Senha: <input class="form-control" type="password" name="senha" required="true" /></div>
								<div class="col-8">Confirme a senha: <input class="form-control" type="password" name="confirmacaoSenha" required="true"/></div>							
							
			
								<input type="hidden" name="acao" value="ConfirmaSenhaAtual" />
								
								<br/>
								<div>
									<button class="btn btn-secondary w-25" alt="Confirmar senha" title="Confirmar senha" type="submit">
										<i class="fas fa-check"></i>
									</button>	
									<a href="/ecommerce/controlador?acao=ListaClientes" class="btn white border w-25" type="submit" alt="Cancelar" title="Cancelar">
										<i class="fas fa-ban"></i>
									</a>	
								</div>
								</form>

							</div>
							<div class="col-3 d-flex flex-row justify-content-center align-items-center ">
								<img class="img-thumbnail" src="imagens/key.png" alt="Confirma��o de senha" width="70%" height="70%">
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>