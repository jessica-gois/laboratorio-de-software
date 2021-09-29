<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp"/>
<title>Login</title>
</head>
<body>
	<header>
	<c:import url="template-header.jsp"/>
	<script src="javascript/validacaoFormulario/validaFormRedefinicaoSenha.js" charset="UTF-8"></script>
	</header>


			<div class="container">
				<div class="card shadow">
					<div>
					<h1 class="card-header">REDEFINA SUA SENHA</h1>
					</div>
					
					<div class="card-body">
						<div class="row">
							<div class="col-8 mb-3">
							
								<form id="formRedefinicaoSenha" action="${stub }" method="post" novalidate>
								<div class="col-6">Nova senha: <input class="form-control" type="password" name="senha" id="senha" required="true"/></div>
								<div class="col-6">Confirme a nova senha: <input class="form-control" type="password" name="confirmacaoSenha" id="confirmacaoSenha" required="true"/></div>							
							
			
								<input type="hidden" name="acao" value="alterar" />
								<input type="hidden" name="viewHelper" value="AlterarSenhaVH" />
								
								<br/>
								<div>
									<button class="btn btn-secondary w-25" alt="Confirmar senha" title="Confirmar senha" type="submit">
										<i class="fas fa-check"></i>
									</button>	
									<a href="listaClientes.jsp" class="btn white border w-25" alt="Cancelar" title="Cancelar">
										<i class="fas fa-ban"></i>
									</a>	
								</div>
								</form>
							</div>
							<div class="col-3">
								<img class="img-thumbnail" src="imagens/login.jpg" alt="Foto de perfil" width="100%" height="50%">
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>