<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<body>
<c:import url="template-header-admin.jsp" />
<div class="container">
	<p class="h4 mb-3 mt-5">Grupo de precificação</p>
	<div class="card shadow mb-5 pb-4">
		<div class="card-body">
			<p class="h5">Cadastro</p>
				<div class="row mt-4">
					<div class="col-5">
						<p class="h5">Descrição</p>
					</div>
					<div class="col-3">
						<p class="h5">Margem de lucro (%)</p>
					</div>
					<div class="col-2">
						<p class="h5" style="color: #FFF;"></p>
					</div>
				</div>
				<form id="formCadastroPrecificacao" action="" method="post"
					novalidate>
					<div class="row pt-2 mb-2 d-flex align-items-center">
						<div class="col-5">
							<input class="form-control mt-2" type="text" id="descricao"
								name="descricao" required="true" />
						</div>
						<div class="col-2">
							<input class="form-control mt-2" type="text" id="margemLucro"
								name="margemLucro" required="true" />
						</div>
						<div class="col-2">
							<a class="btn btn-blue w-100" id="salvar" name="salvar"
								href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarPedidoVH&id="
								title="Salvar" alt="Salvar">Salvar</a>
						</div>
					</div>
				</form>
			</div>
	</div>

	<div class="card shadow mb-5 pb-4">
		<div class="card-body">
			<p class="h5">Grupos cadastrados</p>
			<div class="row mt-4">
				<div class="col-3">
					<p class="h5">Descrição</p>
				</div>
				<div class="col-2">
					<p class="h5">Margem de lucro</p>
				</div>
				<div class="col-2">
					<p class="h5">Data de cadastro</p>
				</div>
				<div class="col-2">
					<p class="h5" style="color: #FFF;"></p>
				</div>
				<div class="col-2">
					<p class="h5" style="color: #FFF;"></p>
				</div>
			</div>
			<div class="row pt-2 mb-2 d-flex align-items-center">
				<div class="col-3">
					<input class="form-control mt-2" type="text" id="descricaoAtualizar"
						name="descricaoAtualizar" value="Mais vendidos" required="true" />
				</div>
				<div class="col-2">
					<input class="form-control mt-2" type="text" id="margemLucroAtualizar"
						name="margemLucroAtualizar" value="1,50" required="true" />
				</div>
				<div class="col-2">
					<p>20/08/2021 08:20h</p>
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
	</div>
</body>
<c:import url="template-footer.jsp" />
</html>