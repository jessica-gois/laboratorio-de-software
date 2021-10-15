<%@page import="model.domain.enums.StatusPedido"%>
<%@page import="model.domain.PedidoItem"%>
<%@page import="model.domain.FormaPagamento"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List,model.domain.Cliente, model.domain.Carrinho,
	model.domain.Cupom,model.domain.Endereco,model.domain.Cartao, model.domain.Endereco,model.domain.Pedido" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp" />
<title>Detalhe do pedido</title>
</head>
<%
	Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
%>
<body>
	<header>
		<c:import url="template-header.jsp" />
	</header>
	<div class="container">
		<div class="card shadow mb-5 pb-5">
			<div class="card-body">
				<div class="d-flex  justify-content-between">
					<h4>Detalhe do pedido #<%=pedido.getId() %></h4>
					<p class="h4 pe-4"><%=pedido.getStatus().getDescricao()%></p>
				</div>				
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
						<div class="col-3"><fmt:formatNumber value = "<%=pedido.getValorTotalItens()%>" type="currency"/></div>
						<div class="col-2"><fmt:formatNumber value = "<%=pedido.getValorFrete()%>" type="currency"/></div>
						<div class="col-4"><fmt:formatNumber value = "<%=pedido.getValorTotalDescontos()%>" type="currency"/></div>
						<div class="col-3"><fmt:formatNumber value = "<%=pedido.getValorTotal()%>" type="currency"/></div>
					</div>
					<div class="row mt-4">
						<p class="h5">2. Endereço de entrega</p>
					</div>
					<div class="row mt-2">
						<div class="col-3">
							<p class="h5">Logradouro</p>
						</div>
						<div class="col-2">
							<p class="h5">Número</p>
						</div>
						<div class="col-4">
							<p class="h5">Cidade</p>
						</div>
						<div class="col-3">
							<p class="h5">CEP</p>
						</div>
					</div>
					<%if(pedido.getEnderecoEntrega() != null){ %>
					<div class="row mt-2">
						<div class="col-3"><%=pedido.getEnderecoEntrega().getLogradouro() %></div>
						<div class="col-2"><%=pedido.getEnderecoEntrega().getNumero() %></div>
						<div class="col-4"><%=pedido.getEnderecoEntrega().getCidade().getNome() + " - "
							+ pedido.getEnderecoEntrega().getCidade().getEstado().getSigla()%></div>
						<div class="col-3"><%=pedido.getEnderecoEntrega().getCep()%></div>
					</div>
					<%}%>
					<div class="row mt-3">
						<p class="h5">3. Pagamento</p>
					</div>
					<div class="row mt-2">
						<div class="col-3">
							<p class="h5">Bandeira</p>
						</div>
						<div class="col-2">
							<p class="h5">Número</p>
						</div>
						<div class="col-4">
							<p class="h5">Nome impreso no cartão</p>
						</div>
					</div>
					<%if(pedido.getFormasPagamento() != null){
						for ( FormaPagamento formaPagamento : pedido.getFormasPagamento()) {
							if(formaPagamento.getCartao() != null && formaPagamento.getCartao().getId() > 0){%>		
								<div class="row mt-2">
									<div class="col-3"><%=formaPagamento.getCartao().getBandeira()%></div>
									<div class="col-2"><%=formaPagamento.getCartao().getNumero()%></div>
									<div class="col-4"><%=formaPagamento.getCartao().getNomeImpresso()%></div>
								</div>
							<%}
						}
					}%>		
					<div class="row mt-4">
						<p class="h5">4. Cupons utilizados</p>
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
					<%if(pedido.getFormasPagamento() != null){
						for ( FormaPagamento formaPagamento : pedido.getFormasPagamento()) {
							if(formaPagamento.getCupom() != null && formaPagamento.getCupom().getId() > 0){%>
								<div class="row mt-2">
									<div class="col-3"><%=formaPagamento.getCupom().getTipo() != null ? formaPagamento.getCupom().getTipo().getDescricao() : ""%></div>
									<div class="col-2"><%=formaPagamento.getCupom().getCodigo()%></div>
									<div class="col-2"><fmt:formatNumber value = "<%=formaPagamento.getCupom().getValor()%>" type="currency"/></div>
								</div>
							<%}
						}
					}%>
					<div class="row mt-4">
						<p class="h5">5. Itens comprados</p>
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
					<%if(pedido.getItens() != null){
						for ( PedidoItem item : pedido.getItens()) {%>
							<div class="row mt-2">
								<div class="col-3"><%=item.getLivro() != null ? item.getLivro().getTitulo() : "" %></div>
								<div class="col-2"><fmt:formatNumber value = "<%=item.getValorUnitario()%>" type="currency"/></div>
								<div class="col-2 d-flex justify-content-start">
									<p>2</p>
								</div>
								<div class="col-2"><fmt:formatNumber value = "<%=item.getValorTotal()%>" type="currency"/></div>
							</div>
					<% }
					}
					%>
					<div class="row mt-4">
						<%if(pedido != null && pedido.getStatus().equals(StatusPedido.ENTREGUE)){ %>
							<div class="col-3">
								<a class="btn btn-blue w-100"href="/ecommerce/controlador?acao=alterar&viewHelper=SolicitarTrocaVH&id=<%=pedido.getId()%>">Solicitar troca</a>
							</div>
						<%}%>
						<div class="col-3">
							<a class="btn btn-secondary w-100" href="meusPedidos.jsp">Voltar</a>
						</div>
					</div>
			</div>
		</div>
	</div>
</body>
</html>