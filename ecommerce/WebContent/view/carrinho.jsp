<%@page import="model.domain.CarrinhoItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List,model.domain.Cliente, model.domain.Carrinho" %>
<c:url value="/carrinho" var="stub"/>
<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp" />
<title>Carrinho de compras</title>
</head>
<fmt:setLocale value = "pt_BR"/>						

<%
	Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
%>
<body>
	<header>
		<c:import url="template-header.jsp" />
	</header>
	<div class="container">
		<p class="h4 mb-3">Carrinho de compras</p>
		<div class="card shadow mb-5 pb-5">
			<div class="card-body">
				<h4>Itens selecionados (<fmt:formatNumber value = "<%=carrinho != null ? carrinho.getQuantidadeTotal() : 0%>" type = "number" maxFractionDigits="0"/>)</h4>
				<hr class="my-3">
				<div class="row">
					<div class="col">
						<p class="h5">Título</p>
					</div>
					<div class="col">
						<p class="h5">Valor</p>
					</div>
					<div class="col">
						<p class="h5">Quantidade</p>
					</div>
					<div class="col">
						<p class="h5">Subtotal</p>
					</div>
					<div class="col">
						<p class="h5" style="color:#FFF;"></p>
					</div>				
				</div>
				<hr class="my-2">
				<%if(carrinho != null && carrinho.getItens()!= null && !carrinho.getItens().isEmpty()){
					for (CarrinhoItem item : carrinho.getItens()) {%>
				<div class="row pt-2">
					<div class="d-flex align-items-end col ">
						<p><%=item.getLivro().getTitulo()%></p>
					</div>
					<div class="col">
						<p><fmt:formatNumber value = "<%=item.getValorUnitario()%>" type = "currency"/></p>
					</div>
					<div class="col">
						<div class="row">							
							<form class="w-25" id="formDiminuirQuantidade" action="${stub}" novalidate>
								<input type="hidden" name="acaoCarrinho" value="diminuirQuantidade" />
								<input type="hidden" name="livroId" value="<%=item.getLivro().getId()%>" />							
								<button class="btn white border w-10" type="submit" title="Diminuir quantidade"
								alt="Diminuir quantidade">
									<i class="fas fa-minus"></i>
								</button>
							</form>
							<input class="form-control w-25" type="text" name="quantidadeItem" id="quantidadeItem"							
							style="background-color: #FFF; text-align: center;" 
							value="<fmt:formatNumber value = "<%=item.getQuantidade()%>" type = "number" minFractionDigits="0"/>" readonly/>
							<form class="w-25" id="formAumentarQuantidade" action="${stub}" novalidate>
								<input type="hidden" name="acaoCarrinho" value="aumentarQuantidade" />
								<input type="hidden" name="livroId" value="<%=item.getLivro().getId()%>" />
								<button class="btn white border w-10" type="submit"  title="Aumentar quantidade"
								alt="Aumentar quantidade">
									<i class="fas fa-plus"></i>
								</button>	
							</form>
						</div>
					</div>
					<div class="col">		
					<p><fmt:formatNumber value = "<%=item.getValorTotal()%>" type = "currency"/></p>
					</div>
					<div class="col">
					<form id="formRemoverCarinho" action="${stub}" method="get" novalidate>
						<input type="hidden" name="acaoCarrinho" value="removerItem" />
						<input type="hidden" name="livroId" value="<%=item.getLivro().getId()%>" />
						<button class="btn btn-red w-50" type="submit"  title="Excluir"
							alt="Excluir">
								Excluir
						</button>	
					</form>
					</div>				
				</div>
				<% }
				}%>
			</div>		
		</div>
		<div class="row">
			<div class="col-auto">
				<h4>Total: <fmt:formatNumber value = "<%=carrinho != null ? carrinho.getValorTotal() : 0%>" type = "currency"/></h4>
			</div>
			<%if(carrinho != null && carrinho.getItens() != null && !carrinho.getItens().isEmpty()){%>
				<div class="col-3">
					<a class="btn btn-blue w-100"href="finalizarPedido" >Comprar</a>
				</div>
			<%}%>
			<div class="col-3">
				<a class="btn btn-secondary w-100"href="index" >Continuar comprando</a>
			</div>
		</div>
	</div>
</body>
</html>