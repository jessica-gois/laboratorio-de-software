<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp" />
<title>Meus pedidos</title>
</head>

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
				<div class="row pt-2">
					<div class="col-3">
						<p>12345</p>
					</div>
					<div class="col-1 me-4">
						<p>R$ 59,80</p>
					</div>
					<div class="col-2 me-4">
						EM PROCESSAMENTO
					</div>
					<div class="col-2">
						<p>15/11/2021</p>
					</div>
					<div class="col-2">
						<a class="btn btn-blue w-100" href="#" title="Detalhes">Detalhes</a>	
					</div>				
				</div>
				<hr class="my-2 mt-3">
				<div class="row pt-2">
					<div class="col-3">
						<p>12344</p>
					</div>
					<div class="col-1 me-4">
						<p>R$ 15,00</p>
					</div>
					<div class="col-2 me-4">
						ENTREGUE
					</div>
					<div class="col-2">
						<p>20/04/2021</p>
					</div>
					<div class="col-2">
						<a class="btn btn-blue w-100" href="#" title="Detalhes">Detalhes</a>	
					</div>				
				</div>
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