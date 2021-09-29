<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp"/>
<title>Cadastro de cart�o</title>
</head>
<body>
	<header>
	<c:import url="template-header.jsp"/>
	<script src="javascript/validacaoFormulario/validaFormCadastroCartao.js" charset="UTF-8"></script>
	</header>

	<div class="container">
		<div class="card shadow">
			<div>
				<h1 class="card-header">CADASTRO DE CART�O</h1>
			</div>
			<div class="card-header d-flex align-items-center">
				<img src="imagens/cartoes.webp"
					alt="Cart�es" width="25%" height="10%">
			</div>

			<div class="card-body">
				<div class="row">
					<div class="col-8 mb-3">

						<form id="formCadastroCartao" action="${stub }" method="post" novalidate>
							
							<div class="row d-flex">
								<div class="col-3 mb-2">
									<label for="bandeira">Bandeira:</label>
									<select	class="form-control" name="bandeira" id="bandeira" required="true">
										<option value="">Escolha...</option>
										<option value="Visa">Visa</option>
										<option value="Mastercard">Mastercard</option>
										<option value="Elo">Elo</option>
									</select>
								</div>
								<div class="col-md-9">
									N�mero do cart�o: <input class="form-control" type="text" maxlength="16"
										name="numeroCartao" id="numeroCartao" required="true" placeholder="Digite o n�mero do cart�o..." />
								</div>
							</div>

							<div class="row d-flex ">
								<div class="col-8 mb-4">
									Nome impresso no cart�o: <input class="form-control" type="text"
										name="nomeImpresso" required="true" placeholder="Digite o nome impresso no cart�o..." />
								</div>
								<div class="col-4 mb-4">
									C�digo de seguran�a (CVV): <input class="form-control" type="text" maxlength="3"
										name="codigoSeguranca" id="codigoSeguranca" required="true" placeholder="Informe o c�digo..." />
								</div>

							<div class="row mb-4">
								<div class="col-8">
									<input class="form-check-input" type="checkbox" value="true" name="preferencial"
										id="preferencial"> <label class="form-check-label"
										for="preferencial">Usar como cart�o preferencial?</label>
								</div>
							</div>
							<input type="hidden" name="acao" value="salvar" />
								<input type="hidden" name="viewHelper" value="CadastroCartaoVH" />
							<div>									
								</button>
								<button class="btn btn-secondary w-25" type="submit" title="Salvar" alt="Salvar">
									<i class="fas fa-save"></i>	
								</button>	
								<a href="/ecommerce/view/listaClientes.jsp" class="btn white border w-25" type="submit" alt="Voltar" title="Voltar">
									<i class="fas fa-long-arrow-alt-left"></i>
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