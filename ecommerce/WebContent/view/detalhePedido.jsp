<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="template-head.jsp" />
<title>Detalhe do pedido</title>
</head>

<body>
	<header>
		<c:import url="template-header.jsp" />
	</header>
	<div class="container">
		<div class="card shadow mb-5 pb-5">
			<div class="card-body">
				<h4>Detalhe do pedido #12345</h3>
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
						R$ 59,80
					</div>
					<div class="col-2">
						R$ 10,00
					</div>
					<div class="col-4">
						R$ 1,90
					</div>
					<div class="col-3">
						R$ 67,90
					</div>
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
				<div class="row mt-2">
					<div class="col-3">
						Francisco Rodrigues Filho
					</div>
					<div class="col-2">
						2022
					</div>
					<div class="col-4">
						Mogi das Cruzes
					</div>
					<div class="col-3">
						06974-200
					</div>
				</div>
				<div class="row mt-3">
					<p class="h5"><strong>Previsão de entrega:</strong> 30/11/2021</p>
				</div>
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
				<div class="row mt-2">
					<div class="col-3">
						Visa
					</div>
					<div class="col-2">
						123456789101112
					</div>
					<div class="col-4">
						Jéssica Góis Scala
					</div>
				</div>
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
				<div class="row mt-2">
					<div class="col-3">
						Promocional
					</div>
					<div class="col-2">
						12345
					</div>
					<div class="col-2">
						R$ 0,90
					</div>
				</div>
				<div class="row mt-2">
					<div class="col-3">
						Troca
					</div>
					<div class="col-2">
						34
					</div>
					<div class="col-2">
						R$ 1,00
					</div>
				</div>	
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
				<div class="row mt-2">
					<div class="col-3">
						Amoras
					</div>
					<div class="col-2">
						R$ 29,90
					</div>
					<div class="col-2 d-flex justify-content-start">
						<p>2</p>
					</div>	
					<div class="col-2">
						R$ 59,80
					</div>				
				</div>
				<div class="row mt-4">					
					<div class="col-3">
						<a class="btn btn-blue w-100"href="#" >Solicitar troca</a>
					</div>
					<div class="col-3">
						<a class="btn btn-secondary w-100"href="#" >Voltar</a>
					</div>
				</div>
			</div>		
		</div>		
	</div>
</body>
</html>