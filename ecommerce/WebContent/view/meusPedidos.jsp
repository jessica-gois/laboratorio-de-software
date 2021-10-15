<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List,model.domain.Pedido" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp" />
<title>Meus pedidos</title>
</head>
<%
	List<Pedido> pedidos = (List<Pedido>) request.getSession().getAttribute("pedidos");
%>
<body>
	<header>
		<c:import url="template-header.jsp" />
	</header>
	<div class="container">
		<p class="h4 mb-3">Histórico de pedidos</p>
		<div class="card shadow mb-5 pb-4">
			<div class="card-body">
				<hr class="my-4">
				<div class="row">
					<div class="col-3">
						<p class="h5">Número do pedido</p>
					</div>
					<div class="col-1 me-4">
						<p class="h5">Valor</p>
					</div>
					<div class="col-2 me-4">
						<p class="h5">Status</p>
					</div>
					<div class="col-2">
						<p class="h5">Data</p>
					</div>
					<div class="col-2">
						<p class="h5" style="color:#FFF;"></p>
					</div>				
				</div>
				<%if(pedidos != null){
					for(Pedido pedido : pedidos){%>
						<div class="row pt-2 mb-2">
							<div class="col-3">
								<p><%=pedido.getId()%></p>
							</div>
							<div class="col-1 me-4">
								<fmt:setLocale value = "pt_BR"/>								
								<p><fmt:formatNumber value = "<%=pedido.getValorTotal()%>" type = "currency"/></p>
							</div>
							<div class="col-2 me-4">
								<%=pedido.getStatus() != null ? pedido.getStatus().getDescricao() : ""%>
							</div>
							<div class="col-2">
								<p><fmt:formatDate value="<%=pedido.getDtCadastro()%>" pattern="dd/MM/yyyy"/></p>
							</div>
							<div class="col-2">
								<a class="btn btn-blue w-100" href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarPedidoVH&id=<%=pedido.getId()%>" title="Detalhes">Detalhes</a>	
							</div>				
						</div>
					<%}
					}%>
				<!--  <hr class="my-2 mt-3">-->
			</div>		
		</div>
		<div class="row mt-4">					
			<div class="col-3">
				<a class="btn btn-secondary w-100"href="#" >Voltar</a>
			</div>
		</div>
	</div>
</body>
</html>