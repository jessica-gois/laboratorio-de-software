<%@page import="model.domain.CarrinhoItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List,model.domain.Cliente, model.domain.Carrinho,
	model.domain.Cupom,model.domain.Endereco,model.domain.Cartao, model.domain.Endereco,model.domain.Pedido" %>
<c:url value="/controlador" var="stub"/>
<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp" />
<title>Finalizar compra</title>
</head>
<%
	Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
	Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
	List<Cupom> cupons = (List<Cupom>)request.getAttribute("cupons");
	List<Endereco> enderecos = (List<Endereco>)request.getAttribute("enderecos");
	List<Cartao> cartoes = (List<Cartao>) request.getAttribute("cartoes");
	
%>
<body>
	<header>
		<c:import url="template-header.jsp" />
	</header>
	<div class="container">
		<div class="card shadow mb-5 pb-5">
			<div class="card-body">				
				<form id="formFinalizarPedido" action="${stub}" novalidate>
				<h4>Finalizar compra</h4>
				<hr class="my-3">
				<div class="row mt-4">
					<p class="h5">1. Resumo do pedido</p>
				</div>
				<div class="row mt-2">
					<div class="col-3">
						<p class="h5">Valor total itens</p>
					</div>
					<div class="col-2">
						<p class="h5">Frete</p>
					</div>
					<div class="col-4">
						<p class="h5">Valor total descontos (cupons)</p>
					</div>
					<div class="col-3">
						<p class="h5">Valor final do pedido</p>
					</div>
				</div>
				<div class="row mt-2">
					<div class="col-3">
						R$ <%=pedido.getValorTotalItens()%>
					</div>
					<div class="col-2">
						R$ <%=pedido.getValorFrete() %>
					</div>
					<div class="col-4">
						R$ <%=pedido.getValorTotalDescontos() %>
					</div>
					<div class="col-3">
						R$ <%=pedido.getValorTotal()%>
					</div>
				</div>
				<div class="row mt-4">
					<p class="h5">2. Endereço de entrega</p>
				</div>
				
				<div class="row mt-2">
					<div class="col">				
						<select class="form-control" name="enderecoEntrega" id="enderecoEntrega" required="true">
						<option value="">Escolha o endereco...</option>	
						<% for ( Endereco endereco : enderecos) {  %>
							<option value="<%=endereco.getId()%>"><%=endereco.getLabel()%></option>
						<% } %>	
						</select>
					</div>
				</div>
				<div class="row mt-4">
					<p class="h5">3. Endereço de cobrança</p>
				</div>
				<div class="row mt-2">
					<div class="col">
						<%if(enderecos != null){%>			
							<select class="form-control" name="enderecoCobranca" id="enderecoCobranca" required="true">
							<option value="">Escolha o endereco...</option>	
							<% for ( Endereco endereco : enderecos) {  %>
								<option value="<%=endereco.getId()%>"><%=endereco.getLabel()%></option>
							<% } %>	
							</select>
						<% } %>	
				</div>
				<div class="row mt-2">
					<div class="col-auto d-flex align-items-end">
						<a class="btn btn-blue" href="#">Cadastrar endereço</a>
					</div>
				</div>			
				<div class="row mt-4">
					<p class="h5">4. Cupons disponíveis</p>
				</div>
				<div class="row mt-2">
					<div class="col-3">
						<p class="h5">Tipo</p>
					</div>
					<div class="col-2">
						<p class="h5">Código</p>
					</div>
					<div class="col-4">
						<p class="h5">Valor</p>
					</div>
				</div>
				<%if(cupons != null){%>
					 <% for ( Cupom cupom : cupons) {  %>
						<div class="row mt-2">
							<div class="col-3">
								<%=cupom.getTipo().getDescricao()%>
							</div>
							<div class="col-2">
								<%=cupom.getCodigo()%>
							</div>
							<div class="col-2">
								R$ <%=cupom.getValor()%>
							</div>
							<div class="col-3">
								<%if(!cupom.isAplicado()){%>
									<a class="btn btn-blue" href="/ecommerce/controlador?acao=consultar&viewHelper=AplicarCupomVH&id=<%=cupom.getId()%>">Aplicar cupom</a>	
								<%}else{ %>
									<a class="btn btn-secondary w-50" href="#">Aplicado</a>	
								<%}%>
							</div>
						</div>
					<% } %>
				<% } %>
				
					<div class="row mt-3">
					<p class="h5">5. Pagamento</p>
				</div>
				<div class="row mt-2">
					<div class="col-3">
						<p class="h5">Bandeira</p>
					</div>
					<div class="col-2">
						<p class="h5">Número</p>
					</div>
					<div class="col-2">
						<p class="h5">Nome impreso</p>
					</div>
				</div>
				<%if(cartoes != null && !cartoes.isEmpty()){
					for(Cartao cartao : cartoes){%>
				<div class="row mt-2">
					<div class="col-3">
						<%=cartao.getBandeira().name() %>
					</div>
					<div class="col-2">
						<%=cartao.getNumero() %>
					</div>
					<div class="col-2">
						<%=cartao.getNomeImpresso() %>
					</div>
					<div class="col-3">
						<%if(!cartao.isUsado()){%>
							<a class="btn btn-blue w-50" href="/ecommerce/controlador?acao=consultar&viewHelper=UsarCartaoVH&id=<%=cartao.getId()%>">Usar</a>	
						<%}else{ %>
							<a class="btn btn-secondary w-50" href="/ecommerce/controlador?acao=consultar&viewHelper=RemoverCartaoPedidoVH&id=<%=cartao.getId()%>">Remover</a>	
						<%}%>	
					</div>
				</div>
				<%}
					}%>
				<div class="row mt-2">
					<div class="col-auto d-flex align-items-end">
						<a class="btn btn-blue" href="#">Cadastrar cartão</a>
					</div>
					<!--<div class="col-auto d-flex align-items-end">
						<a class="btn btn-secondary" href="#">Alterar</a>
					</div> -->
				</div>
					
				<div class="row mt-4">
					<p class="h5">6. Revisar itens</p>
				</div>
				<div class="row mt-2">
					<div class="col-3">
						<p class="h5">Título</p>
					</div>
					<div class="col-2">
						<p class="h5">Valor</p>
					</div>
					<div class="col-2">
						<p class="h5">Quantidade</p>
					</div>	
					<div class="col-3">
						<p class="h5">Subtotal</p>
					</div>					
				</div>
				<%if(carrinho != null && carrinho.getItens() != null){
					for(CarrinhoItem item : carrinho.getItens()){%>
						<div class="row mt-2">
							<div class="col-3">
								<%=item.getLivro().getTitulo()%>
							</div>
							<div class="col-2">
								R$ <%=item.getValorUnitario()%>
							</div>
							<div class="col">
						<div class="row">							
								<!--  <input type="hidden" name="caminhoRedirecionar" value="/view/finalizarPedido" />	-->					
								<a class="btn white border w-10" title="Diminuir quantidade"
								 href="/ecommerce/carrinho?acaoCarrinho=diminuirQuantidade&caminhoRedirecionar=/view/finalizarPedido&livroId=<%=item.getLivro().getId()%>" alt="Diminuir quantidade">
									<i class="fas fa-minus"></i>
								</a>
							<input class="form-control w-25" type="text" name="quantidadeItem" id="quantidadeItem"							
							style="background-color: #FFF; text-align: center;" value="<%=item.getQuantidade()%>" readonly/>
								<a class="btn white border w-10" type="submit" title="Aumentar quantidade"
								 href="/ecommerce/carrinho?acaoCarrinho=aumentarQuantidade&caminhoRedirecionar=/view/finalizarPedido&livroId=<%=item.getLivro().getId()%>" alt="Aumentar quantidade">
									<i class="fas fa-plus"></i>
								</a>
						</div>
					</div>	
							<div class="col-2">
								<%=item.getValorTotal()%>
							</div>
							<div class="col">
									<input type="hidden" name="caminhoRedirecionar" value="/view/finalizarPedido" />
									<a class="btn btn-red w-50" type="submit" title="Excluir"
										href="/ecommerce/carrinho?acaoCarrinho=removerItem&caminhoRedirecionar=/view/finalizarPedido&livroId=<%=item.getLivro().getId()%>"alt="Excluir">Excluir
									</a>
							</div>
						</div>
					<%}%>
				<%}%>
				<input type="hidden" name="acao" value="salvar" />	
				<input type="hidden" name="viewHelper" value="CadastroPedidoVH" />
				<div class="row mt-4">					
					<div class="col-3">						
						<button class="btn btn-blue w-100" type="submit" Alt="Finalizar compra" title="Finalizar compra">Finalizar compra</button>
					</div>
				</div>
			</div>	
			</form>
		</div>	
	</div>
	</div>
</body>
</html>