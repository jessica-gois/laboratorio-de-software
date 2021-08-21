<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	</header>


			<div class="container">
				<div class="card shadow">
					<div>
					<h1 class="card-header">ATUALIZAÇÃO DE ENDEREÇO</h1>
					</div>
					
					<div class="card-header">
						<h2>Atualize seus dados</h2>
					</div>

				<div class="card-body">
					<div class="row">
					 	<div class="col-10 mb-3">
							<form action="${stub}" method="post">	
							
								
							
							<div class="row">
								<div>
									Descrição: <input class="form-control" type="text"
										name="descricaoEndereco" required="true" />
								</div>
							</div>

							<div class="row d-flex">
								<div class="col-3">
									<label for="tipoLogradouro">Tipo de logradouro:</label> <select
										class="form-control" name="tipoLogradouro" id="tipoLogradouro">
										<option value="">Escolha...</option>
										<option value="RUA">Rua</option>
										<option value="TRAVESSA">Travessa</option>
										<option value="AVENIDA">Avenida</option>
										<option value="ALAMEDA">Alameda</option>
										<option value="ESTRADA">Estrada</option>
										<option value="RODOVIA">Rodovia</option>
										<option value="JARDIM">Jardim</option>
									</select>
								</div>
								<div class="col-md-9">
									Logradouro: <input class="form-control" type="text"
										name="logradouro" required="true" />
								</div>
							</div>

							<div class="row d-flex">
								<div class="col-3">
									Nº: <input class="form-control" type="text"
										name="numeroEndereco" required="true" />
								</div>
								<div class="col-6">
									Complemento: <input class="form-control" type="text"
										name="complemento" required="true" />
								</div>

								<div class="col-3">
									<label for="tipoResidencia">Tipo de residência:</label> <select
										class="form-control" name="tipoResidencia" id="tipoResidencia">
										<option value="">Escolha...</option>
										<option value="CASA">Casa</option>
										<option value="APARTAMENTO">Apartamento</option>
										<option value="FLAT">Flat</option>
										<option value="KITNET">Kitnet</option>
										<option value="LOFT">Loft</option>
									</select>
								</div>
							</div>

							<div class="row d-flex">
								<div class="col-4">
									Bairro: <input class="form-control" type="text" name="bairro"
										required="true" />
								</div>
								<div class="col-2">
									CEP: <input class="form-control" type="text" name="cep"
										required="true" />
								</div>
								<div class="col-3">
									<label for="estado">Estado:</label> <select
										class="form-control" name="estado">
										<option value="estado">Escolha o estado...</option>
										<option value="ac">Acre</option>
										<option value="al">Alagoas</option>
										<option value="am">Amazonas</option>
										<option value="ap">Amapá</option>
										<option value="ba">Bahia</option>
										<option value="ce">Ceará</option>
										<option value="df">Distrito Federal</option>
										<option value="es">Espírito Santo</option>
										<option value="go">Goiás</option>
										<option value="ma">Maranhão</option>
										<option value="mt">Mato Grosso</option>
										<option value="ms">Mato Grosso do Sul</option>
										<option value="mg">Minas Gerais</option>
										<option value="pa">Pará</option>
										<option value="pb">Paraíba</option>
										<option value="pr">Paraná</option>
										<option value="pe">Pernambuco</option>
										<option value="pi">Piauí</option>
										<option value="rj">Rio de Janeiro</option>
										<option value="rn">Rio Grande do Norte</option>
										<option value="ro">Rondônia</option>
										<option value="rs">Rio Grande do Sul</option>
										<option value="rr">Roraima</option>
										<option value="sc">Santa Catarina</option>
										<option value="se">Sergipe</option>
										<option value="sp">São Paulo</option>
										<option value="to">Tocantins</option>
									</select>
								</div>
								<div class="col-3">
									<label for="cidade">Cidade:</label> <select
										class="form-control" name="cidade">
										<option value="">Escolha...</option>
										<option value="Acrelândia">Acrelândia</option>
										<option value="Assis Brasil">Assis Brasil</option>
										<option value="Brasiléia">Brasiléia</option>
										<option value="Bujari">Bujari</option>
										<option value="Capixaba">Capixaba</option>
										<option value="Cruzeiro do Sul">Cruzeiro do Sul</option>
										<option value="Epitaciolândia">Epitacolândia</option>
										<option value="Feijó">Feijó</option>
										<option value="Jordão">Jordão</option>
									</select>
								</div>
							</div>
							<br />

							<div class="row mb-2">
								<div class="col-4">
									<input class="form-check-input" type="checkbox" value=""
										id="enderecoEntrega"> <label class="form-check-label"
										for="enderecoEntrega"> Endereço de
										entrega?</label>
								</div>
								<div class="col-4">
									<input class="form-check-input" type="checkbox" value=""
										id="enderecoCobranca"> <label class="form-check-label"
										for="enderecoCobranca">Endereço de
										cobrança?</label>
								</div>
								<div class="col-4">
									<input class="form-check-input" type="checkbox" value=""
										id="enderecoResidencial"> <label class="form-check-label"
										for="enderecoResidencial">Endereço residencial?</label>
								</div>
							</div>
								
												
								<input type="hidden" name="acao" value="AtualizaCliente" />
								<br/>
								
								<button class="btn btn-secondary w-25" type="submit" alt="Salvar" title="Salvar"><i class="fas fa-save"></i></button>
								
								
								<a href="/ecommerce/controlador?acao=ListaClientes" class="btn white border w-25" type="submit" alt="Voltar" title="Voltar">
									<i class="fas fa-long-arrow-alt-left"></i>
								</a>								
							</form>
						</div>
					<br/>
			</body>
</html>