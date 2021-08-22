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
	</header>


			<div class="container">
				<div class="card shadow">
					<div>
					<h1 class="card-header">REDEFINA SUA SENHA</h1>
					</div>
					
						<div class="card-header"> 
						<p>Só precisamos do e-mail que você usou ao criar seu cadastro na Turma do Livro.</p>
					</div>

	
		
					<div class="card-body">
						<div class="row">
							<div class="col-8 mb-3">
							
								<form action="${stub }" method="post">
								<div class="col-10">Email: <input class="form-control" type="email" name="email" required="true" placeholder="exemplo@exemplo.com.br" /></div>												
						
								<input type="hidden" name="acao" value="SucessoRedefinirSenhaClienteFormulario" />
								
								<br/>
								<div>
									<button class="btn btn-secondary w-25" alt="Redefinir Senha" title="Redefinir Senha" type="submit">
										<i class="fas fa-check"></i>
									</button>	
									<button class="btn white border w-25" type="submit" alt="Cancelar" title="Cancelar">
										<i class="fas fa-ban"></i>
									</button>	
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