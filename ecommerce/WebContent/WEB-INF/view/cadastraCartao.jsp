<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp"/>
<title>Cadastro de cartão</title>
</head>
<body>
	<header>
	<c:import url="template-header.jsp"/>
	</header>

	<div class="container">
		<div class="card shadow">
			<div>
				<h1 class="card-header">CADASTRO DE CARTÃO</h1>
			</div>
			<div class="card-header d-flex align-items-center">
				<img src="imagens/cartoes.webp"
					alt="Cartões" width="25%" height="10%">
			</div>

			<div class="card-body">
				<div class="row">
					<div class="col-8 mb-3">

						<form action="${stub }" method="post">
							
							<div class="row d-flex">
								<div class="col-3 mb-2">
									<label for="tipoLogradouro">Bandeira:</label> <select
										class="form-control" name="tipoLogradouro" id="tipoLogradouro">
										<option value="">Escolha...</option>
										<option value="VISA">Visa</option>
										<option value="MASTERCARD">Mastercard</option>
										<option value="ELO">Elo</option>
									</select>
								</div>
								<div class="col-md-9">
									Número do cartão: <input class="form-control" type="text" maxlength="16"
										name="numeroCartao" required="true" />
								</div>
							</div>

							<div class="row d-flex ">
								<div class="col-8 mb-4">
									Nome impresso no cartão: <input class="form-control" type="text"
										name="nomeImpresso" required="true" />
								</div>
								<div class="col-4 mb-4">
									Código de segurança (CVV): <input class="form-control" type="text" maxlength="3"
										name="cvv" required="true" />
								</div>

							<div class="row mb-4">
								<div class="col-8">
									<input class="form-check-input" type="checkbox" value=""
										id="cartaoPreferencial"> <label class="form-check-label"
										for="cartaoPreferencial">Usar como cartão preferencial?</label>
								</div>
							</div>
							<div>									
								</button>
								<a href="/ecommerce/controlador?acao=ListaClientes" class="btn btn-secondary w-25" type="submit" alt="Salvar" title="Salvar">
									<i class="fas fa-save"></i>
								</a>	
								<button class="btn white border w-25" type="reset"
									title="Limpar" alt="Limpar">
									<i class="fas fa-eraser"></i>
								</button>
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