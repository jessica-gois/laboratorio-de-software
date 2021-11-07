<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/controlador" var="stub" />
<!DOCTYPE html>
<html>

<head>
<c:import url="template-head.jsp" />
<title>Pedido recebido</title>
</head>

<body>
	<header>
		<c:import url="template-header.jsp" />
	</header>
	<form id="formSucesso" action="${stub}">
		<div class="container">
			<p class="h4 mb-3">Pedido recebido</p>
			<div class="card shadow mb-5 pb-4">
				<div class="card-body">
					<div class="row">
						<div class="row pt-2">
							<div class="col-12">
								<p>Seu pedido foi recebido com sucesso pela Turma do Livro.
									Estamos processando as informações o mais rápido possível.</p>
							</div>
							<div class="row">
								<div class="col-auto mt-4 form-control pt-3 pb-3 alerta">PAGAMENTO
									EM PROCESSAMENTO</div>
							</div>
							<div class="row "></div>
							<div class="col-10 mt-4">Os produtos serão enviados em até
								3 dias utéis após a aprovação de pagamento.</div>
							<!--  </div>-->
						</div>
					</div>
				</div>
			</div>
			<input type="hidden" name="acao" value="consultar" /> <input
				type="hidden" name="viewHelper" value="ConsultarPedidoVH" /> <input
				type="hidden" name="tipoPesquisa" value="ultimoCadastrado" />
			<div class="row mt-4">
				<div class="col-3">
					<a class="btn btn-blue w-100"
						href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarPedidosVH">
						Ver pedidos</a>
				</div>
				<div class="col-3">
					<a class="btn btn-secondary w-100" href="index">Voltar</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>