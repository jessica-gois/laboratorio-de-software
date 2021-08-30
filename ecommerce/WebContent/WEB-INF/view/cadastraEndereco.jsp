<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp"/>
<title>Cadastro de endere�o</title>
</head>
<body>
	<header>
	<c:import url="template-header.jsp"/>
	<script src="javascript/validacaoFormulario/validaFormCadastroEndereco.js" charset="UTF-8"></script>
	</header>

	<div class="container">
		<div class="card shadow">
			<div>
				<h1 class="card-header">CADASTRO DE ENDERE�O</h1>
			</div>
			

			<div class="card-body">
				<div class="row">
					<div class="col-8 mb-3">

						<form id="formCadastroEndereco" action="${stub }" method="post" novalidate>
							
							<div class="row">
								<div>
									Descri��o: <input class="form-control" type="text"
										name="descricao" required="true"  placeholder="Exemplo: Minha Casa"  />
								</div>
							</div>

							<div class="row d-flex">
								<div class="col-3">
									<label for="tipoLogradouro">Tipo de logradouro:</label> <select
										class="form-control" name="tipoLogradouro" id="tipoLogradouro">
										<option value="">Escolha...</option>
										<option value="Rua">Rua</option>
										<option value="Avenida">Avenida</option>
										<option value="Rodovia">Rodovia</option>
									</select>
								</div>
								<div class="col-md-9">
									Logradouro: <input class="form-control" type="text"
										name="logradouro" required="true" placeholder="Digite o logradouro..." />
								</div>
							</div>

							<div class="row d-flex">
								<div class="col-3">
									N�: <input class="form-control" type="text"
										name="numero" required="true" placeholder="0000" />
								</div>
								<div class="col-6">
									Complemento: <input class="form-control" type="text"
										name="complemento" placeholder="Digite o complemento..." />
								</div>

								<div class="col-3">
									<label for="tipoResidencia">Tipo de resid�ncia:</label> <select
										class="form-control" name="tipoResidencia" id="tipoResidencia">
										<option value="">Escolha...</option>
										<option value="Casa">Casa</option>
										<option value="Apartamento">Apartamento</option>
									</select>
								</div>
							</div>

							<div class="row d-flex">
								<div class="col-4">
									Bairro: <input class="form-control" type="text" name="bairro"
										required="true" placeholder="Digite o bairro..." />
								</div>
								<div class="col-2">
									CEP: <input class="form-control" type="text" name="cep" placeholder="00000-000"
										required="true" />
								</div>
								<div class="col-3">
									<label for="estado">Estado:</label> <select
										class="form-control" name="estado">
										<option value="">Escolha o estado...</option>
										<option value="ac">Acre</option>
										<option value="al">Alagoas</option>
										<option value="am">Amazonas</option>
										<option value="ap">Amap�</option>
										<option value="ba">Bahia</option>
										<option value="ce">Cear�</option>
										<option value="df">Distrito Federal</option>
										<option value="es">Esp�rito Santo</option>
										<option value="go">Goi�s</option>
										<option value="ma">Maranh�o</option>
										<option value="mt">Mato Grosso</option>
										<option value="ms">Mato Grosso do Sul</option>
										<option value="mg">Minas Gerais</option>
										<option value="pa">Par�</option>
										<option value="pb">Para�ba</option>
										<option value="pr">Paran�</option>
										<option value="pe">Pernambuco</option>
										<option value="pi">Piau�</option>
										<option value="rj">Rio de Janeiro</option>
										<option value="rn">Rio Grande do Norte</option>
										<option value="ro">Rond�nia</option>
										<option value="rs">Rio Grande do Sul</option>
										<option value="rr">Roraima</option>
										<option value="sc">Santa Catarina</option>
										<option value="se">Sergipe</option>
										<option value="sp">S�o Paulo</option>
										<option value="to">Tocantins</option>
									</select>
								</div>
								<div class="col-3">
									<label for="cidade">Cidade:</label> <select
										class="form-control" name="cidade">
										<option value="">Escolha...</option>
										<option value="Acrel�ndia">Acrel�ndia</option>
										<option value="Assis Brasil">Assis Brasil</option>
										<option value="Brasil�ia">Brasil�ia</option>
										<option value="Bujari">Bujari</option>
										<option value="Capixaba">Capixaba</option>
										<option value="Cruzeiro do Sul">Cruzeiro do Sul</option>
										<option value="Epitaciol�ndia">Epitacol�ndia</option>
										<option value="Feij�">Feij�</option>
										<option value="Jord�o">Jord�o</option>
									</select>
								</div>
							</div>
							<br />
							<div class="row">
								<div>
									Observa��o: <textarea class="form-control" type="text" maxlength="200" 
										name="observacao"></textarea>
								</div>
							</div>
							<br/>

							<div class="row mb-2">
								<div class="col-4">
									<input class="form-check-input" type="checkbox" name="tipoEndereco" value="Entrega"
										id="enderecoEntrega"> <label class="form-check-label"
										for="enderecoEntrega"> Endere�o de
										entrega?</label>
								</div>
								<div class="col-4">
									<input class="form-check-input" type="checkbox" name="tipoEndereco" value="Cobranca"
										id="enderecoCobranca"> <label class="form-check-label"
										for="enderecoCobranca">Endere�o de
										cobran�a?</label>
								</div>
								<div class="col-4">
									<input class="form-check-input" type="checkbox" name="tipoEndereco" value="Residencial"
										id="enderecoResidencial"> <label class="form-check-label"
										for="enderecoResidencial">Endere�o residencial?</label>
								</div>
							</div>
							<input type="hidden" name="acao" value="CadastraEndereco" />
							<div>									
								<button class="btn btn-secondary w-25" type="submit" alt="Salvar" title="Salvar">
									<i class="fas fa-save"></i>
								
								</button>	
								<a href="/ecommerce/controlador?acao=ListaClientes" class="btn white border w-25" type="submit" alt="Voltar" title="Voltar">
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