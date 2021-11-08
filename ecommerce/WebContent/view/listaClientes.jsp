<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List,model.domain.Cliente,model.domain.Cartao,
	 model.domain.Endereco, model.domain.Cidade, model.domain.PedidoItemTroca" %>
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
	<p>Usuário logado: ${cliente.usuario.email} </p>
	</div>-->	
	<fmt:setLocale value = "pt_BR"/>
	<%
		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
		List<PedidoItemTroca> itensTrocaNotificar = (List<PedidoItemTroca>) request.getSession().getAttribute("itensTrocaNotificacao");
		%>

			<div class="container">
				<%if(itensTrocaNotificar != null && !itensTrocaNotificar.isEmpty()){%>
					<div class="alert alert-primary d-flex align-items-center" role="alert">
						<div class="col">
							  <h5 class="alert-heading"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" 
							  class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
							    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
							  </svg>
							  Trocas aprovadas!</h5>
							 <hr>			  
							  <%for(PedidoItemTroca itemTroca : itensTrocaNotificar){ %>
							  <div>					  
							    Pedido <%=itemTroca.getItem().getPedido().getId()%> - Item <%=itemTroca.getItem().getLivro().getTitulo()%> - <fmt:formatNumber value = "<%=itemTroca.getQuantidade()%>" type = "number" maxFractionDigits="0"/> unidade(s)
							  </div>
							  <%}%>
							  <a class="btn mt-3 btn-outline-primary" href="/ecommerce/view/marcarNotificacaoTrocaComoLida" style="color:#084298;">Marcar como lido</a>
		 				 </div>
					</div>
				<%}%>
				
				<div class="card shadow">
				<div>
				<h1 class="card-header"><%=cliente != null ? cliente.getNomeCompleto() : "" %></h1>
				<h3 class="ps-3 pt-2" >Score: <%=cliente != null ? cliente.getScore(): "" %></h3>
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
        					<th>Número Residencial</th>
        					<th>Número Celular</th>
        					<th>Data de nascimento</th>
        					<th>CPF</th>
        					<th>E-mail</th>
    				 	</tr>
    				</thead>
						<tbody> 
						
							<tr>  				
        						<td><%=cliente.getNomeCompleto()%></td>
        						<td>(<%=cliente.getTelefoneResidencial().getDdd()%>)<%=cliente.getTelefoneResidencial().getNumero() %></td>
        						
        						<td>(<%=cliente.getTelefoneCelular().getDdd()%>)<%=cliente.getTelefoneCelular().getNumero() %></td>
        						<td><fmt:formatDate value="<%=cliente.getDataNascimento()%>" pattern="dd/MM/yyyy"/></td>
       							<td><%=cliente.getCpf()%></td>
        						<td><%=cliente.getUsuario().getEmail() %></td>
       						<td>
	       						<a class="btn btn-secondary w-20" alt="Alterar dados da conta"
	       							title="Alterar dados da conta"
	       							 href="/ecommerce/controlador?acao=consultar&viewHelper=PreparaAlteracaoClienteVH&id=<%=cliente.getId()%>">
	       							<i class="far fa-edit"></i>
	       						</a>
	       					</td>
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
       						<td><a class="btn btn-secondary w-20" alt="Alterar senha" title="Alterar senha" 
       						href="/ecommerce/view/confirmaSenhaAtual.jsp"><i class="far fa-edit"></i></a></td>
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
						<a href="/ecommerce/view/cadastraCartao.jsp" class="btn white" alt="Novo cartão" title="Novo cartão">
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
        					<th>Bandeira</th>
        					<!--<th>Código do cartão</th> -->
        					<th>Cartão principal?</th>
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
        						<td><%=cartao.getPreferencial() != null && cartao.getPreferencial() ? "Sim" : "Não"%></td>
       						<td>
	       						<a class="btn btn-secondary w-20" alt="Excluir cartão" title="Excluir cartão"
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
								<h2>Endereços</h2>
								<a href="/ecommerce/view/cadastraEndereco.jsp"
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
    						<th>Descrição</th>
        					<th>Tipo</th>
        					<th>Logradouro</th>
        					<th>Número</th>
        					<!--<th>Número</th>-->
        					<!--<th>Bairro</th> -->
        					<!--<th>CEP</th>-->
        					<th>Cidade</th>
        					<!-- <th>Estado</th>-->
        					<!--<th>País</th>-->
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
       						<td><a class="btn btn-secondary w-20" alt="Alterar endereço" title="Alterar endereço" 
								href="/ecommerce/controlador?acao=consultar&viewHelper=PreparaAlteracaoEnderecoVH&id=<%=endereco.getId()%>">
									<i class="far fa-edit"></i></a>
									<a class="btn btn-secondary w-20" alt="Excluir cartão" title="Excluir cartão"
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