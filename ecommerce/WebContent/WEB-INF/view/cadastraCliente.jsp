<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="stub"/>

<!DOCTYPE html>
<html>
<head>
	<c:import url="template-head.jsp"/>
	<title>Cadastro</title>
</head>
<body>

		
<header>
	<c:import url="template-header.jsp"/>
	</header>
			<div class="container">
				<div class="card shadow">
					<div>
						<h1 class="card-header">CADASTRO</h1>
					</div>				
						
		
					<div class="card-body">
						<div class="row">
							<div class="col-12 mb-3">
								
								<form action="${stub }" method="post">
								<div class="row mb-2">
									<h4>Dados pessoais:</h4>								
								</div>
								
								<div class="row d-flex justify-content-between">
								<div class="col-md-5">Nome: <input class="form-control" type="text" name="nome" required="true" /></div>
								<div class="col-md-5">Sobrenome: <input class="form-control" type="text" name="sobrenome" required="true" /></div>
								<div class="col-md-2">G�nero: <input class="form-control" type="text" name="genero" required="true" /></div>								
								</div>
								
								<div class="row d-flex justify-content-between">
								<div class="col-md-5">Tipo Telefone: <input class="form-control" type="text" name="tipoTelefone" required="true" /></div>
								<div class="col-md-2">DDD: <input class="form-control" type="text" name="ddd" required="true" /></div>
								<div class="col-md-5">N�mero Telefone: <input class="form-control" type="tel" name="numeroTelefone" required="true" /></div>								
								</div>								
								
								
								<div class="row d-flex justify-content-between">
								<div class="col-md-6">Data de Nascimento: <input class="form-control" type="text" name="dataNascimento" required="true" /></div>
								<div class="col-md-6">CPF: <input class="form-control" type="text" name="cpf" required="true"/></div>
								</div>
																
								<br/>
								
								<div class="row mb-2">
									<h4>Endere�o</h4>								
								</div>
								
								<div class="row">
									<div>
										Descri��o: <input class="form-control" type="text"  name="descricaoEndereco" required="true" />
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
										Logradouro: <input class="form-control" type="text"  name="logradouro" required="true" />	
									</div>									
								</div>

								<div class="row d-flex">
									<div class="col-3">
										N�: <input class="form-control" type="text"  name="numeroEndereco" required="true" />	
									</div>
									<div class="col-6">
										Complemento: <input class="form-control" type="text"  name="complemento" required="true" />	
									</div>
									
									<div class="col-3">
										<label for="tipoResidencia">Tipo de resid�ncia:</label> <select
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
							<br/>
							
							<div class="row">
								<div class="col-4">
									<input class="form-check-input" type="checkbox" value="" id="enderecoEntrega">
									<label class="form-check-label" for="enderecoEntrega">
										Definir como endere�o de entrega?</label>									
								</div>
								<div class="col-6">
									<input class="form-check-input" type="checkbox" value="" id="enderecoCobranca">
									<label class="form-check-label" for="enderecoCobranca">
										Definir como endere�o de cobran�a?</label>									
								</div>
							</div>
							
							<br/>

							<div class="row">
							<h4>Dados da conta:</h4>
							</div>

							<div class="col-md-12">E-mail: <input class="form-control" type="email" name="email" required="true" /></div>								
			
								<div class="row d-flex justify-content-between">
								<div class="col-md-6">Senha: <input class="form-control" type="password"  name="senha" required="true" /></div>
								<div class="col-md-6">Confirme a senha: <input class="form-control" type="password"  name="confirmacaoSenha" required="true"/></div>
								</div>
							<br/>
								
								<div><input type="hidden"  name="score" value ="700" /></div>
								<div><input type="hidden" name="status"  value ="true"/></div>	
								
								<input type="hidden" name="acao" value="CadastraCliente" />	
						
								
								<br/>	
								<div>
									<button class="btn btn-secondary w-25" type="submit" title="Salvar" alt="Salvar"> <i class="fas fa-save"></i>	
									</button>	
									<button class="btn white border w-25" type="reset" title="Limpar" alt="Limpar"><i class="fas fa-eraser"></i>
									</button>	
								</div>
								</form>			
			   </div>	
		</body>
</html>