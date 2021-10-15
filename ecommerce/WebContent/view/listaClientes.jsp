<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List,model.domain.Cliente,model.domain.Cartao,
	 model.domain.Endereco, model.domain.Cidade" %>
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
	<p>Usu�rio logado: ${cliente.usuario.email} </p>
	</div>-->	
	<fmt:setLocale value = "pt_BR"/>
	<%
		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
		%>

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
        					<!--<th>G�nero</th>-->
        					<!--<th>DDD Residencial</th>-->
        					<th>N�mero Residencial</th>
     						<!--<th>DDD Celular</th>-->
        					<th>N�mero Celular</th>
        					<th>Data de nascimento</th>
        					<th>CPF</th>
        					<th>E-mail</th> 
        					<th>Score</th>
        					<!-- <th>Status</th>-->
    				 	</tr>
    				</thead>
						<tbody> 
						
							<tr>  				
        						<td><%=cliente.getNome()%></td>
        						<td><%=cliente.getSobrenome()%></td>
        						<td>(<%=cliente.getTelefoneResidencial().getDdd()%>)<%=cliente.getTelefoneResidencial().getNumero() %></td>
        						
        						<td>(<%=cliente.getTelefoneCelular().getDdd()%>)<%=cliente.getTelefoneCelular().getNumero() %></td>
        						<td><fmt:formatDate value="<%=cliente.getDataNascimento()%>" pattern="dd/MM/yyyy"/></td>
       							<td><%=cliente.getCpf()%></td>
        						<td><%=cliente.getUsuario().getEmail() %></td>
        						<td><%=cliente.getScore() %></td>
        					<!--	<td>${cliente.usuario.status}</td>-->
       						<td>
	       						<a class="btn btn-secondary w-20" alt="Alterar dados da conta"
	       							title="Alterar dados da conta"
	       							 href="/ecommerce/controlador?acao=consultar&viewHelper=PreparaAlteracaoClienteVH&id=<%=cliente.getId()%>">
	       							<i class="far fa-edit"></i>
	       						</a
       						></td>
  							<!-- <a href="/ecommerce/controlador?acao=RemoveCliente&id=${cliente.id }">remove</a>-->	
    					    							
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
							<tr>  	
								<td><%=cliente.getUsuario().getEmail() %></td>			
        						<td>********</td>					
        					<!--	<td>cliente.usuario.status/</td>-->
        					
       						<td><a class="btn btn-secondary w-20" alt="Alterar senha" title="Alterar senha" 
       						href="/ecommerce/view/confirmaSenhaAtual.jsp"><i class="far fa-edit"></i></a></td>
  								<!-- <a href="/ecommerce/controlador?acao=RemoveCliente&id=${cliente.id }">remove</a>-->	
  								     							
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
						<h2>Meus cart�es</h2>
						<a href="/ecommerce/view/cadastraCartao.jsp" class="btn white" alt="Novo cart�o" title="Novo cart�o">
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
        					<th>N�mero do cart�o</th>
        					<th>Bandeira</th>
        					<!--<th>C�digo do cart�o</th> -->
        					<th>Cart�o principal?</th>
        					<!-- <th>Status</th>-->
        					<th></th>
    				 	</tr>
    				</thead>
						<tbody> 
						<%if(request.getSession().getAttribute("cartoes")!=null){	
						List<Cartao>cartoes = (List<Cartao>)request.getSession().getAttribute("cartoes");%>
						 <% for (Cartao cartao : cartoes) {
						 System.out.println(cartao.getNomeImpresso());%> 						
							<tr>  				
        						<td><%=cartao.getNomeImpresso()%></td>
        						<td><%=cartao.getNumero()%></td>
       							<td><%=cartao.getBandeira().toString()%></td>
        						<!--<td>***</td>-->
        						<td><%=cartao.getPreferencial() != null && cartao.getPreferencial() ? "Sim" : "N�o"%></td>
       						<td>
	       						<a class="btn btn-secondary w-20" alt="Excluir cart�o" title="Excluir cart�o"
	       							href="/ecommerce/controlador?acao=excluir&viewHelper=ExcluirCartaoVH&id=<%=cartao.getId()%>">
	       							<i class="far fa-trash-alt"></i>
	       						</a>
       						</td>
  							<!-- <a href="/ecommerce/controlador?acao=excluir&id=${cliente.id }">remove</a>-->	
    					    							
        					</tr>
        						<% } %>
	<% } %>
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
								<h2>Endere�os</h2>
								<a href="/ecommerce/view/cadastraEndereco.jsp"
									class="btn white" alt="Novo endere�o" title="Novo endere�o">
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
    						<th>Descri��o</th>
        					<th>Tipo</th>
        					<th>Logradouro</th>
        					<th>N�mero</th>
        					<!--<th>N�mero</th>-->
        					<!--<th>Bairro</th> -->
        					<!--<th>CEP</th>-->
        					<th>Cidade</th>
        					<!-- <th>Estado</th>-->
        					<!--<th>Pa�s</th>-->
        					<!-- <th>Status</th>-->
        					<th></th>
    				 	</tr>
    				</thead>
						<tbody> 
						<%if(request.getSession().getAttribute("enderecos")!=null){	
						List<Endereco> enderecos = (List<Endereco>)request.getSession().getAttribute("enderecos");%>
						 <% for (Endereco endereco : enderecos) {
						 System.out.println(endereco.getDescricao());%> 			
							<tr>  				
        						<td><%=endereco.getDescricao()%></td>
        						<td><%=endereco.getTipoEndereco().name()%></td>
        						<td><%=endereco.getLogradouro()%></td>
       							<td><%=endereco.getNumero()%></td>
       							<td><%=endereco.getCidade().getNome()%>-<%=endereco.getCidade().getEstado().getSigla()%></td>
        						<!--<!--<td>00</td>-->
        						<!--<td>Leblon</td>-->
        						<!--<td>1111-1111</td>-->
        						<!--<td>Rio de Janeiro</td>-->
        						<!--<td>Brasil</td>-->
        					<!--	<td>cliente.usuario.status</td>-->
       						<td><a class="btn btn-secondary w-20" alt="Alterar endere�o" title="Alterar endere�o" 
								href="/ecommerce/controlador?acao=consultar&viewHelper=PreparaAlteracaoEnderecoVH&id=<%=endereco.getId()%>">
									<i class="far fa-edit"></i></a>
									<a class="btn btn-secondary w-20" alt="Excluir cart�o" title="Excluir cart�o"
	       							href="/ecommerce/controlador?acao=excluir&viewHelper=ExcluirEnderecoVH&id=<%=endereco.getId()%>">
	       							<i class="far fa-trash-alt"></i>
	       						</a></td>
									
  							<!-- <a href="/ecommerce/controlador?acao=RemoveCliente&id=${cliente.id }">remove</a>-->	
    						<!--< -->     							
        					</tr>
        					<% } %>
						<% } %>
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
					<a class="btn white border" href="/ecommerce/view/inativarConta.jsp">Desativar conta</a>
				</div>				
				<br/>
		</body>
</html>