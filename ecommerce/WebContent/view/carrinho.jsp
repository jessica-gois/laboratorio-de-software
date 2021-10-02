<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List,model.domain.Cliente, model.domain.PedidoItem" %>
<c:url value="/carrinho" var="stub"/>
<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp" />
<title>Carrinho de compras</title>
</head>
<%
	List<PedidoItem> itens = (List<PedidoItem>) request.getSession().getAttribute("carrinho");
	System.out.println("Quantidade de itens no carrinho" + itens.size());
%>
<body>
	<header>
		<c:import url="template-header.jsp" />
	</header>
	<div class="container">
		<p class="h4 mb-3">Carrinho de compras</p>
		<div class="card shadow mb-5 pb-5">
			<div class="card-body">
				<h4>Itens selecionados</h4>
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
				<%if(itens != null && !itens.isEmpty()){
					for (PedidoItem item : itens) {%>
				<div class="row pt-2">
					<div class="d-flex align-items-end col ">
						<p><%=item.getLivro().getTitulo()%></p>
					</div>
					<div class="col">
						<p>R$ <%=item.getValorUnitario()%></p>
					</div>
					<div class="col">
						<div class="row">
							<form class="w-25" id="formAumentarQuantidade" action="${stub}" novalidate>
								<input type="hidden" name="acaoCarrinho" value="aumentarQuantidade" />
								<input type="hidden" name="livroId" value="<%=item.getLivro().getId()%>" />
								<button class="btn white border w-10" type="submit"  title="Aumentar quantidade"
								alt="Aumentar quantidade">
									<i class="fas fa-plus"></i>
								</button>	
							</form>
							<input class="form-control w-25" type="text" name="quantidadeItem" id="quantidadeItem"							
							style="background-color: #FFF; text-align: center;" value="<%=item.getQuantidade()%>" readonly/>
							<form class="w-25" id="formDiminuirQuantidade" action="${stub}" novalidate>
								<input type="hidden" name="acaoCarrinho" value="diminuirQuantidade" />
								<input type="hidden" name="livroId" value="<%=item.getLivro().getId()%>" />							
								<button class="btn white border w-10" type="submit" title="Diminuir quantidade"
								alt="Diminuir quantidade">
									<i class="fas fa-minus"></i>
								</button>
							</form>
						</div>
					</div>
					<div class="col">
						<p>R$ <%=item.getValorTotal()%></p>
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
				<h4>Total: R$59,80</h4>
			</div>
			<div class="col-3">
				<a class="btn btn-blue w-100"href="#" >Comprar</a>
			</div>
		</div>
	</div>
</body>
</html>