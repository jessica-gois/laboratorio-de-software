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
					<h1 class="card-header">LOGIN</h1>
					</div>
					
						<div class="card-header"> 
						<p>Insira o <strong>e-mail</strong> e a <strong>senha</strong> usuário cadastrado</p>
					</div>

	
		
					<div class="card-body">
						<div class="row">
							<div class="col-8 mb-3">
							
								<form action="${stub }" method="post">
								<div>Email: <input class="form-control" type="email" name="email" required="true" /></div>
								<div class="col-6">Senha: <input class="form-control" type="password" name="senha" required="true"/></div>							
							
			
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