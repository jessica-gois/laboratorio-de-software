<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List, model.domain.PedidoItemTroca, model.domain.PedidoItem, model.domain.Livro"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp" />
<title>Solicitação de troca</title>
</head>
<% 
	List<PedidoItemTroca> itensTroca = (List<PedidoItemTroca>) request.getSession().getAttribute("itensTroca");
%>
<c:url value="/view/solicitarTroca" var="stub"/>
<fmt:setLocale value = "pt_BR"/>
<body>
	<header>
		<c:import url="template-header.jsp" />
	</header>
	<form id="formSolicitarTroca" action="${stub }" method="post" novalidate>
		<div class="container">
			<p class="h4 mb-3">Itens do pedido</p>
			<div class="card shadow mb-5 pb-4">
				<div class="card-body">
					<h5>Selecione os itens que deseja trocar:</h5>
					<hr class="my-4">
					<div class="row">
						<div class="col">
							<p class="h5">Título</p>
						</div>
						<div class="col me-4">
							<p class="h5">Quantidade no pedido</p>
						</div>
						<div class="col me-4">
							<p class="h5">Valor unitário</p>
						</div>
						<div class="col me-4">
							<p class="h5">Subtotal</p>
						</div>
						<div class="col">
							<p class="h5">Quantidade para troca<p>
						</div>			
					</div>
					<%if(itensTroca != null && !itensTroca.isEmpty()){
						for(PedidoItemTroca itemTroca : itensTroca){
							PedidoItem itemPedido = itemTroca.getItem();
							Livro livro = itemPedido != null ? itemPedido.getLivro() : null;%>				
						<div class="row pt-2">
							<div class="col">
								<p><%=livro != null ? livro.getTitulo() : ""%></p>
							</div>
							<div class="col me-4">
								<p><fmt:formatNumber value ="<%=itemPedido.getQuantidade()%>"
									type = "number" maxFractionDigits="0"/></p>
							</div>
							<div class="col me-4">
								<fmt:formatNumber value = "<%=itemPedido.getValorUnitario()%>" type = "currency"/>
							</div>
							<div class="col me-4">
								<fmt:formatNumber value = "<%=itemPedido.getValorTotal()%>" type = "currency"/>
							</div>
							<div class="col">
								<input class="form-control" type="number" name="quantidadeTrocaItem<%=itemPedido.getId()%>"
									id="quantidadeTrocaItem<%=itemPedido.getId()%>" min="0" max="<%=itemPedido.getQuantidade()%>"
									value="<fmt:formatNumber value ="<%=itemTroca.getQuantidade()%>"
									type = "number" maxFractionDigits="0"/>" required="true" placeholder="Informe a quantidade..."
									onkeyup="this.value = this.value <= <%=itemTroca.getQuantidade()%> ? parseInt(this.value, 10) : <%=itemTroca.getQuantidade()%> "/>
							</div>				
						</div>
					<%}
					}%>
				</div>		
			</div>
			<div class="row mt-4">					
				<div class="col-3">
					<button class="btn btn-blue w-100" type="submit" alt="Trocar" title="Trocar">Trocar</button>
				</div>
				<div class="col-3">
					<a class="btn btn-secondary w-100"href="#" >Voltar</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>