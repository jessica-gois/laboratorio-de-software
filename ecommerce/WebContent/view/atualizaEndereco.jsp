<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="model.domain.Endereco, model.domain.Cidade,java.util.List, model.domain.enums.Estado" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
	<c:import url="template-head.jsp"/>
	<title>Atualiza</title>
</head>

<body>
	<header>
	<c:import url="template-header.jsp"/>
	<script src="javascript/validacaoFormulario/validaFormAtualizaEndereco.js" charset="UTF-8"></script>
		<script src="javascript/validacaoFormulario/validaFormCadastroEndereco.js" charset="UTF-8"></script>
	<script type="text/javascript" src="javascript/carregaCidadesAlteracaoEndereco.js" charset="UTF-8"></script>
	</header>
	<%
		Endereco endereco = (Endereco) request.getSession().getAttribute("endereco");
		List<Estado> estados = Estado.getEstadosOrdenados();
	%>
	<script type="text/javascript">
		window.onload = function() {
			const selectEstado = document.getElementById("estado");			
			 carregarCidades(selectEstado,'<%=endereco.getCidade().getNome()%>');
			 
			 const selectTipoEndereco = document.getElementById("tipoEndereco");
			const tipoEnderecoAtual = '<%=endereco.getTipoEndereco().name()%>';
			if(tipoEnderecoAtual && tipoEnderecoAtual === "Residencial"){
				selectTipoEndereco.setAttribute('disabled', "true");
			}
		};
		
	</script>
			<div class="container">
		<div class="card shadow">
			<div>
				<h1 class="card-header">ATUALIZAR ENDEREÇO</h1>
			</div>

			<div class="card-body">
				<div class="row">
					<div class="col-8 mb-3">

						<form id="formCadastroEndereco" action="${stub }" method="post" novalidate>
							
							<div class="row">
									<div>
										Descrição: <input class="form-control" type="text"  name="descricaoEndereco"
										value = "<%=endereco.getDescricao()%>"
										id="descricaoEndereco" required="true" maxlength="120"/>
									</div>
								</div>
								
								<div class="row d-flex">
									<div class="col-3">
										<label for="tipoLogradouro">Tipo de logradouro:</label> <select required="true"
											class="form-control" name="tipoLogradouro" id="tipoLogradouro">
											<option value="">Escolha...</option>
											<option value="Rua" <%=endereco.getTipoLogradouro().name() == "Rua" ? "selected" : ""%>>Rua</option>
											<option value="Travessa" <%=endereco.getTipoLogradouro().name() == "Travessa" ? "selected" : ""%>>Travessa</option>
											<option value="Avenida" <%=endereco.getTipoLogradouro().name() == "Avenida" ? "selected" : ""%>>Avenida</option>
											<option value="Alameda" <%=endereco.getTipoLogradouro().name() == "Alameda" ? "selected" : ""%>>Alameda</option>
											<option value="Estrada" <%=endereco.getTipoLogradouro().name() == "Estrada" ? "selected" : ""%>>Estrada</option>
											<option value="Rodovia" <%=endereco.getTipoLogradouro().name() == "Rodovia" ? "selected" : ""%>>Rodovia</option>
											<option value="Jardim" <%=endereco.getTipoLogradouro().name() == "Jardim" ? "selected" : ""%>>Jardim</option>
										</select>
									</div>								
									<div class="col-md-9">
										Logradouro: <input class="form-control" type="text" name="logradouro" id="logradouro"
										value = "<%=endereco.getLogradouro()%>"
										required="true" />	
									</div>									
								</div>

								<div class="row d-flex">
									<div class="col-3">
										Nº: <input class="form-control" type="text"  name="numeroEndereco" id="numeroEndereco"
										required="true" value ="<%=endereco.getNumero()%>" />	
									</div>
									<div class="col-6">
										Complemento: <input class="form-control" type="text"  name="complemento" id="complemento"
										value = "<%=endereco.getComplemento() != null ? endereco.getComplemento() : ""%>"
										/>	
									</div>
									
									<div class="col-3">
										<label for="tipoResidencia">Tipo de residência:</label> 
										<select class="form-control" name="tipoResidencia" id="tipoResidencia"
										 required="true">
											<option value="">Escolha...</option>
											<option value="Casa" <%=endereco.getTipoResidencia().name() == "Casa" ? "selected" : ""%>>Casa</option>
											<option value="Apartamento" <%=endereco.getTipoResidencia().name() == "Apartamento" ? "selected" : ""%>>Apartamento</option>
											<option value="Flat" <%=endereco.getTipoResidencia().name() == "Flat" ? "selected" : ""%>>Flat</option>
											<option value="Kitnet" <%=endereco.getTipoResidencia().name() == "Kitnet" ? "selected" : ""%>>Kitnet</option>
											<option value="Loft" <%=endereco.getTipoResidencia().name() == "Loft" ? "selected" : ""%>>Loft</option>
										</select>
									</div>	
								</div>

							<div class="row d-flex">
								<div class="col-4">
									Bairro: <input class="form-control" type="text" name="bairro" id="bairro"
									value = "<%=endereco.getBairro()%>" required="true" />
								</div>
								<div class="col-2">
									CEP: <input class="form-control" type="text" name="cep" id="cep"
									value = "<%=endereco.getCep()%>" 
										required="true" />
								</div>
								<div class="col-3">
									<label for="estado">Estado:</label>
									 <select class="form-control" name="estado" id="estado" 
									 value = <%=endereco.getCidade().getEstado()%>
									 required="true" onchange="carregarCidades(this);">
										<option value="">Escolha o estado...</option>										
										  <% for ( Estado estado : estados) {  %>
										  	<option value=<%=estado.getSigla()%> <%=endereco.getCidade().getEstado() == estado ? "selected" : ""%>><%=estado.getNome()%></option>
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
									Tipo de endereço: <select class="form-control" name="tipoEndereco" id="tipoEndereco"
									required="true">
										<option value="">Escolha...</option>
										<option value="Cobranca" <%=endereco.getTipoEndereco().name() == "Cobranca" ? "selected" : ""%> >Cobrança</option>
										<option value="Entrega" <%=endereco.getTipoEndereco().name() == "Entrega" ? "selected" : ""%>>Entrega</option>
										<%if(endereco.getTipoEndereco().name() == "Residencial"){%>
										<option value="Residencial" selected="true">Residencial</option>
										<%} %>
									</select>
								</div>
							</div>
							</br>
							<div class="row">
								<div>
									Observação: <textarea class="form-control" type="text" maxlength="200"
										name="observacaoEndereco" id="observacaoEndereco"><%=endereco.getObservacao() != null ? endereco.getObservacao() : ""%></textarea>
								</div>
							</div>
								<input type="hidden" name="acao" value="alterar" />
								<input type="hidden" name="viewHelper" value="AlterarEnderecoVH" />
								<input type="hidden" name="id" value="<%=endereco.getId()%>" />
								<br/>
								
								<button class="btn btn-secondary w-25" type="submit" title="Salvar" alt="Salvar">
									<i class="fas fa-save"></i>	
								</button>
								<a href="/ecommerce/view/listaClientes.jsp" class="btn white border w-25" alt="Voltar" title="Voltar">
									<i class="fas fa-long-arrow-alt-left"></i>
								</a>								
							</form>
						</div>
					<br/>
			</body>
</html>