<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List, model.domain.enums.Estado"%>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp"/>
<title>Cadastro de endere?o</title>
</head>
<body>
	<header>
	<c:import url="template-header.jsp"/>
	<script src="javascript/validacaoFormulario/validaFormCadastroEndereco.js" charset="UTF-8"></script>
	<script type="text/javascript" src="javascript/carregaCidades.js" charset="UTF-8"></script>
	</header>
	<%
		List<Estado> estados = Estado.getEstadosOrdenados();
	%>
	<div class="container">
		<div class="card shadow">
			<div>
				<h1 class="card-header">CADASTRO DE ENDERE?O</h1>
			</div>
			

			<div class="card-body">
				<div class="row">
					<div class="col-8 mb-3">

						<form id="formCadastroEndereco" action="${stub }" method="post" novalidate>
							
							<div class="row">
									<div>
										Descri??o: <input class="form-control" type="text"  name="descricaoEndereco" id="descricaoEndereco" placeholder="Exemplo: Minha Casa" required="true" maxlength="120"/>
									</div>
								</div>
								
								<div class="row d-flex">
									<div class="col-3">
										<label for="tipoLogradouro">Tipo de logradouro:</label> <select required="true"
											class="form-control" name="tipoLogradouro" id="tipoLogradouro">
											<option value="">Escolha...</option>
											<option value="Rua">Rua</option>
											<option value="Travessa">Travessa</option>
											<option value="Avenida">Avenida</option>
											<option value="Alameda">Alameda</option>
											<option value="Estrada">Estrada</option>
											<option value="Rodovia">Rodovia</option>
											<option value="Jardim">Jardim</option>
										</select>
									</div>								
									<div class="col-md-9">
										Logradouro: <input class="form-control" type="text" name="logradouro" id="logradouro" required="true" placeholder="Digite o logradouro..."/>	
									</div>									
								</div>

								<div class="row d-flex">
									<div class="col-3">
										N?: <input class="form-control" type="text"  name="numeroEndereco" id="numeroEndereco" required="true" placeholder="0000" />	
									</div>
									<div class="col-6">
										Complemento: <input class="form-control" type="text"  name="complemento" id="complemento" placeholder="Digite o complemento..."/>	
									</div>
									
									<div class="col-3">
										<label for="tipoResidencia">Tipo de resid?ncia:</label> 
										<select class="form-control" name="tipoResidencia" id="tipoResidencia" required="true">
											<option value="">Escolha...</option>
											<option value="Casa">Casa</option>
											<option value="Apartamento">Apartamento</option>
											<option value="Flat">Flat</option>
											<option value="Kitnet">Kitnet</option>
											<option value="Loft">Loft</option>
										</select>
									</div>	
								</div>

							<div class="row d-flex">
								<div class="col-4">
									Bairro: <input class="form-control" type="text" name="bairro" id="bairro" required="true" placeholder="Digite o bairro..."/>
								</div>
								<div class="col-2">
									CEP: <input class="form-control" type="text" name="cep" id="cep" placeholder="00000-000"
										required="true" />
								</div>
								<div class="col-3">
									<label for="estado">Estado:</label>
									 <select class="form-control" name="estado" id="estado" required="true" onchange="carregarCidades(this);">
										<option value="">Escolha o estado...</option>										
										  <% for ( Estado estado : estados) {  %>
										  	<option value=<%=estado.getSigla()%>><%=estado.getNome()%></option>
										  <% } %>
									</select>
								</div>
								<div class="col-3">
									<label for="cidade">Cidade:</label> <select 
										class="form-control" name="cidade" id="cidade" required="true">
										<option value="">Escolha...</option>
									</select>
								</div>
							</div>
							<br/>
							<div class="row">
								<div>
									Tipo de endere?o: <select class="form-control" name="tipoEndereco" id="tipoEndereco"
									required="true">
										<option value="">Escolha...</option>
										<option value="Cobranca">Cobran?a</option>
										<option value="Entrega">Entrega</option>
									</select>
								</div>
							</div>
							</br>
							<div class="row">
								<div>
									Observa??o: <textarea class="form-control" type="text" maxlength="200" 
										name="observacaoEndereco" id="observacaoEndereco"></textarea>
								</div>
							</div>
							</br>
							<input type="hidden" name="acao" value="salvar" />	
							<input type="hidden" name="viewHelper" value="CadastroEnderecoVH" />
							<div>									
								<button class="btn btn-secondary w-25" type="submit" alt="Salvar" title="Salvar">
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