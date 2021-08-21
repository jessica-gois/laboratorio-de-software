<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List,model.domain.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	<!-- <div class="card-header hidden">
	<p>Usuário logado: ${usuarioLogado.email} </p>
	</div>-->	
	

			<div class="container">
				<div class="card shadow">
				<div>
				<h1 class="card-header">MINHA CONTA</h1>
				<div class="card-body">
				<div class="row"></div>
    					
 				<div class="card shadow">
					<div>				
					<div class="card-header">
						<h2>Dados pessoais</h2>
					</div>
					</div>

				<div class="card-body">
				<div class="row">
					<div>
					<div class="col-12 mb-3">							
					<div class="row d-flex justify-content-between">
					<table class="table">
					<thead class="table table-striped ">
    					<tr>
        					<th>Nome</th>
        					<th>Sobrenome</th>
        					<th>Data de nascimento</th>
        					<th>CPF</th>
        					<th>E-mail</th> 
        					<th>Score</th>
        					<!-- <th>Status</th>-->
        					<th></th>
    				 	</tr>
    				</thead>
						<tbody> 
						<c:forEach items="${clientes}" var="cliente"> 
							<tr>  				
        						<td>${cliente.nome}</td>
        						<td>${cliente.sobrenome}</td>
        						<td><fmt:formatDate value="${cliente.dataNascimento }" pattern="dd/MM/yyyy"/></td>
       							<td>${cliente.cpf}</td>
        						<td>${cliente.email}</td>
        						<td>${cliente.score}</td>
        					<!--	<td>${cliente.status}</td>-->
       						<td>
	       						<a class="btn btn-secondary w-20" alt="Alterar dados da conta"
	       							title="Alterar dados da conta" href="/ecommerce/controlador?acao=MostraCliente&id=${cliente.id}">
	       							<i class="far fa-edit"></i>
	       						</a
       						></td>
  							<!-- <a href="/ecommerce/controlador?acao=RemoveCliente&id=${cliente.id }">remove</a>-->	
    						</c:forEach>      							
        					</tr>
        				</tbody>
					</table>	
					<br/>
    				</div>
    			</div>  
    		 </div> 
    		</div> 
    	</div> 
    </div> 
 <br/>
    				
				 	<div class="card shadow">
					<div>				
					<div class="card-header">
						<h2>Alterar senha</h2>
						
					</div>
					</div>

				<div class="card-body">
				<div class="row">
					<div>
					<div class="col-12 mb-3">							
					<div class="row d-flex justify-content-between">
					<table class="table">
					<thead class="table table-striped ">
    					<tr>
        					<th>E-mail</th>
        					<th>Senha</th>
        					<th></th>
    				 	</tr>
    				</thead>
						<tbody> 
						<c:forEach items="${clientes}" var="cliente"> 
							<tr>  	
								<td>${cliente.email}</td>			
        						<td>********</td>					
        					<!--	<td>${cliente.status}</td>-->
       						<td><a class="btn btn-secondary w-20" alt="Alterar senha" title="Alterar senha" 
       						href="/ecommerce/controlador?acao=ConfirmaSenhaAtualFormulario"><i class="far fa-edit"></i></a></td>
  								<!-- <a href="/ecommerce/controlador?acao=RemoveCliente&id=${cliente.id }">remove</a>-->	
    						</c:forEach>      							
        					</tr>
        				</tbody>
					</table>	
					<br/>
    				</div>
    			</div>  
    		 </div> 
    		</div> 
    	</div> 
    </div> 
 <br/>
 
 
  				<div class="card shadow">
					<div>				
					<div class="card-header d-flex justify-content-between">
						<h2>Meus cartões</h2>
						<a href="/ecommerce/controlador?acao=CadastraCartaoFormulario" class="btn white" alt="Novo cartão" title="Novo cartão">
							<i width="7px" heigth="100%" class="far fa-plus-square"></i>
						</a>
					</div>
					</div>

				<div class="card-body">
				<div class="row">
					<div>
					<div class="col-12 mb-3">							
					<div class="row d-flex justify-content-between">
					<table class="table">
					<thead class="table table-striped ">
    					<tr>
        					<th>Nome do titular</th>
        					<th>Número do cartão</th>
        					<th>Data de vencimento</th>
        					<th>Bandeira</th>
        					<th>Código do cartão</th> 
        					<th>Cartão principal?</th>
        					<!-- <th>Status</th>-->
        					<th></th>
    				 	</tr>
    				</thead>
						<tbody> 
						<!--<c:forEach items="${clientes}" var="cliente"> -->
							<tr>  				
        						<td>Zeca Pagodinho</td>
        						<td>123.654.00</td>
        						<td>14/05/2021</td>
       							<td>Visa</td>
        						<td>***</td>
        						<td>Sim</td>
       						<td>
	       						<a class="btn btn-secondary w-20" alt="Excluir cartão" title="Excluir cartão"
	       							href="/ecommerce/controlador?acao=MostraCliente&id=${cliente.id}">
	       							<i class="far fa-trash-alt"></i>
	       						</a>
       						</td>
  							<!-- <a href="/ecommerce/controlador?acao=RemoveCliente&id=${cliente.id }">remove</a>-->	
    						<!--<</c:forEach> -->     							
        					</tr>
        				</tbody>
					</table>	
					<br/>
    				</div>
    			</div>  
    		 </div> 
    		</div> 
    	</div> 
    </div> 
 <br/>
 
 
  				<div class="card shadow">
						<div>
							<div class="card-header d-flex justify-content-between"">
								<h2>Endereços</h2>
								<a href="/ecommerce/controlador?acao=CadastraEnderecoFormulario"
									class="btn white" alt="Novo endereço" title="Novo endereço">
									<i class="far fa-plus-square"></i>
								</a>

							</div>
						</div>

						<div class="card-body">
				<div class="row">
					<div>
					<div class="col-12 mb-3">							
					<div class="row d-flex justify-content-between">
					<table class="table">
					<thead class="table table-striped ">
    					<tr>
    						<th>Tipo de endereço</th>
        					<th>Tipo de residência</th>
        					<th>Tipo de logradouro</th>
        					<th>Logradouro</th>
        					<th>Número</th>
        					<th>Bairro</th> 
        					<th>CEP</th>
        					<th>Cidade</th>
        					<th>Estado</th>
        					<th>País</th>
        					<!-- <th>Status</th>-->
        					<th></th>
    				 	</tr>
    				</thead>
						<tbody> 
						<!--<c:forEach items="${clientes}" var="cliente"> -->
							<tr>  				
        						<td>Residencial</td>
        						<td>Casa</td>
        						<td>Rua</td>
       							<td>Paulino Souza</td>
        						<td>22</td>
        						<td>Leblon</td>
        						<td>08830-755</td>
        						<td>Rio de Janeiro</td>
        						<td>RJ</td>
        						<td>Brasil</td>
        					<!--	<td>${cliente.status}</td>-->
       						<td><a class="btn btn-secondary w-20" alt="Alterar endereço" title="Alterar endereço" href="/ecommerce/controlador?acao=MostraCliente&id=${cliente.id}"><i class="far fa-edit"></i></a></td>
  							<!-- <a href="/ecommerce/controlador?acao=RemoveCliente&id=${cliente.id }">remove</a>-->	
    						<!--<</c:forEach> -->     							
        					</tr>
        				</tbody>
					</table>	
					<br/>
    				</div>
    			</div>  
    		 </div> 
    		</div> 
    	</div> 
    </div> 
 <br/>
    				
    			 				
    						
    				
				<div class="container">
					<a href="/ecommerce/controlador?acao=InativarContaFormulario">Desativar conta</a>
				</div>				
				<br/>
		</body>
</html>