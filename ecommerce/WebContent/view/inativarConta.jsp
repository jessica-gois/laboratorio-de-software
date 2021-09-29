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
	</header>


			<div class="container">
				<div class="card shadow">
					<div>
					<h1 class="card-header">INATIVAÇÃO DE CONTA <i class="fas fa-exclamation-triangle"></i></h1>
					</div>
					
					<div class="card-body">
						<div class="row">
							<div class="col-8 mb-3">
							<form  action="${stub }" method="post">
							<p>Ao inativar sua conta, você não receberá mais e-mails de ofertas e novidades.</p>
								 <p>Deseja realmente desativar sua conta?</p>	
								<input type="hidden" name="acao" value="listaClientes" />
								
								<input type="hidden" name="acao" value="excluir" />	
								<input type="hidden" name="viewHelper" value="InativarClienteVH"/>	
								<br/>
								<div>
									<a href="/ecommerce/view/listaClientes.jsp" class="btn btn-secondary w-25" alt="Cancelar inativação" title="Cancelar inativação" type="submit">
										<i class="far fa-smile-beam"></i>
									</a>	
									<a href="/ecommerce/controlador?acao=excluir&viewHelper=InativarUsuarioVH" class="btn white border w-25" type="submit" alt="Confirmar inativação" title="Confirmar inativação">
										<i class="far fa-frown"></i>
									</a>	
								</div>
								</form>

							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
</body>
</html>