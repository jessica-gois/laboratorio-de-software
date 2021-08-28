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
	<script src="javascript/validacaoFormulario/validaFormLogin.js" charset="UTF-8"></script>
	</header>

			<div class="container">
				<div class="card shadow">
					<div>
					<h1 class="card-header">LOGIN</h1>
					</div>
					
						<div class="card-header"> 
						<p>Insira o <strong>e-mail</strong> e a <strong>senha</strong> usuário cadastrado</p>
					</div>

	
		
					<div class="card-body">
						<div class="row">
							<div class="col-8 mb-3">
							
								<form id="formLogin" action="${stub }" method="post" novalidate>
								<div class="col-6">E-mail: <input class="form-control" type="email" name="email" id="email" required="true" /></div>
								<div class="col-6">Senha: <input class="form-control" type="password" name="senha" id="senha" required="true"/></div>	
								
								<div>
								<a id="esqueceu-senha" href="/ecommerce/controlador?acao=RedefinirSenhaClienteFormulario" >Esqueceu sua senha?</a>						
								</div>
								
								<div>
								<a id="esqueceu-senha" href="/ecommerce/controlador?acao=CadastraClienteFormulario" >Novo cadastro?</a>						
								</div>
			
								<input type="hidden" name="acao" value="Login" />
								
								<br/>
								<div>
									<button class="btn btn-secondary w-25" alt="Entrar" title="Entrar" type="submit">
										<i class="fas fa-sign-in-alt"></i>
									</button>	
									<button class="btn white border w-25" alt="Limpar" title="Limpar" type="reset">
										<i class="fas fa-eraser"></i>
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