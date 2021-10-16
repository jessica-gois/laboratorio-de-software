<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<body>
<c:import url="template-header-admin.jsp" />
<div class="container">
	<p class="h4 mb-3 mt-5">Consultar cupons</p>
	<div class="card shadow mb-5 pb-4">
		<div class="card-body">
			<div class="row mt-4">
				<div class="col-1">
					<p class="h5">Código</p>
				</div>
				<div class="col-2">
					<p class="h5">Nome</p>
				</div>
				<div class="col-1">
					<p class="h5">Valor</p>
				</div>
				<div class="col-2">
					<p class="h5">Validade</p>
				</div>
				<div class="col-2">
					<p class="h5">Tipo</p>
				</div>
				<div class="col-2">
					<p class="h5" style="color: #FFF;"></p>
				</div>
				<div class="col-2">
					<p class="h5" style="color: #FFF;"></p>
				</div>
			</div>
			<div class="row mt-4 d-flex align-items-center">
				<div class="col-1">
					<input class="form-control mt-2" type="text" id="codigo"
						name="codigo" value="BF10" required="true" />
				</div>
				<div class="col-2">
					<input class="form-control mt-2" type="text" id="codigo"
						name="codigo" value="BlackFriday" required="true" />
				</div>
				<div class="col-1">
					<input class="form-control mt-2" type="number" id="valor"
						name="valor" value="10.00" required="true" />
				</div>
				<div class="col-2">
					<input class="form-control mt-2" type="text" id="validade"
						name="validade" value="20/10/2021" required="true" />
				</div>
				<div class="col-2">
					<input class="form-control mt-2" type="text" id="tipo"
						name="tipo" value="Promocional" required="true" />
				</div>
				<div class="col-2">
					<a class="btn btn-blue w-100" id="atualizar" name="atualizar"
					href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarPedidoVH&id="
					title="Atualizar" alt="Autalizar">Atualizar</a>
				</div>
				<div class="col-2">
					<a class="btn btn-secondary w-100" href="" title="Excluir">Excluir</a>	
				</div>	
			</div>
		</div>
	</div>
	<div class="col-2">
		<a class="btn btn-secondary w-100" href="#" title="Voltar">Voltar</a>	
	</div>	
</div>
</body>
<c:import url="template-footer.jsp" />
</html>