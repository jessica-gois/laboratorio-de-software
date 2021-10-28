<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List, model.domain.PedidoItemTroca"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp" />
<title>Solicitação de troca</title>
</head>
<% 
	List<PedidoItemTroca> itensTroca = (List<PedidoItemTroca>) request.getSession().getAttribute("itensTroca");
%>

<body>
	<header>
		<c:import url="template-header.jsp" />
	</header>
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
						<p class="h5">Valor</p>
					</div>
					<div class="col me-4">
						<p class="h5">Subtotal</p>
					</div>
					<div class="col">
						<p class="h5">Quantidade para troca<p>
					</div>			
				</div>
				<div class="row pt-2">
					<div class="col">
						<p>Amoras</p>
					</div>
					<div class="col me-4">
						<p>2</p>
					</div>
					<div class="col me-4">
						R$ 29,90
					</div>
					<div class="col me-4">
						R$ 59,80
					</div>
					<div class="col">
						<input class="form-control" type="number" name="quantidade"
							id="quantidade" min="0" max="2"
							required="true" placeholder="Informe a quantidade..." />
					</div>				
				</div>
			</div>		
		</div>
		<div class="row mt-4">					
			<div class="col-3">
				<a class="btn btn-blue w-100"href="#" >Trocar</a>
			</div>
			<div class="col-3">
				<a class="btn btn-secondary w-100"href="#" >Voltar</a>
			</div>
		</div>
	</div>
</body>
</html>