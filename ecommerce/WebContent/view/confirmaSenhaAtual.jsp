<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp"/>
<title>Confirmação de senha</title>
</head>
<body>
	<header>
	<c:import url="template-header.jsp"/>
	<script src="javascript/validacaoFormulario/validaFormConfirmacaoSenha.js" charset="UTF-8"></script>
	</header>


			<div class="container">
				<div class="card shadow">
					<div>
					<h1 class="card-header">CONFIRMAÇÃO DE SENHA</h1>
					</div>
					
						<div class="card-header"> 
						<p>Insira a senha atual cadastrada</p>
					</div>
					
					<div class="card-body">
						<div class="row">
							<div class="col-8 mb-3">
							
								<form id="formConfirmacaoSenha" action="${stub }" method="post" novalidate>
								<span class="error"><%=request.getParameter("mensagemErro") != null ? (String)request.getParameter("mensagemErro") : ""%></span>
								<div class="col-6">Senha: <input class="form-control" type="password" name="senha" id="senha" required="true" /></div>
								<div class="col-6">Confirme a senha: <input class="form-control" type="password" name="confirmacaoSenha" id="confirmacaoSenha" required="true" /></div>							
			
								<input type="hidden" name="acao" value="consultar" />
								<input type="hidden" name="viewHelper" value="ConsultarSenhaVH" />
								
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
							<div class="col-3 d-flex align-items-center">
								<img class="img-thumbnail"  src="imagens/key.png" alt="Confirmação de senha" width="70%" height="35%">
							</div>
							
						</div>
					</div>
					
				</div>
			</div>
		</div>
</body>
</html>