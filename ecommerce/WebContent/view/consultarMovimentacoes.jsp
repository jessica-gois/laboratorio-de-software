<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<body>
<c:import url="template-header-admin.jsp" />
<div class="container">
	<p class="h4 mb-3 mt-5">Consultar movimentações</p>
	<div class="card shadow mb-5 pb-4">
    	<div class="card-body">
    		<div class="row mt-4">
				<div class="col">
					<p class="h5">Data</p>
				</div>
				<div class="col">
					<p class="h5">Tipo</p>
				</div>
				<div class="col">
					<p class="h5">Livro</p>
				</div>
				<div class="col">
					<p class="h5">Quantidade</p>
				</div>
				<div class="col">
					<p class="h5">Fornecedor</p>
				</div>
				<div class="col-2">
					<p class="h5" style="color: #FFF;"></p>
				</div>
			</div>
			<div class="row mt-2 mb-4">
				<div class="col">
					<input class="form-control" type="text" id="buscaData" name="buscaData" />
				</div>
				<div class="col">
					<select class="form-control" id="buscaTipo" name="buscaTipo">
						<option value="">Escolha...</option>	
					</select>
				</div>
				<div class="col">
					<select class="form-control" id="buscaLivro" name="buscaLivro">
						<option value="">Escolha...</option>	
					</select>
				</div>
				<div class="col">
					<input class="form-control" type="number" id="buscaQuantidade" name="buscaQuantidade"/>
				</div>
				<div class="col">
					<input class="form-control" type="text" id="buscaFornecedor" name="buscaFornecedor"/>
				</div>
				<div class="col-2">
					<a class="btn btn-blue w-100 pb-2" href="#"
                   	role="button">Pesquisar</a>
				</div>
			</div>
			
			<hr class="my-4">
			
			<div class="row mb-4">
				<div class="col">
					<p>18/07/2021</p>
				</div>
				<div class="col">
					<p>Entrada por compra</p>	
					</select>
				</div>
				<div class="col">
					<p>Amoras</p>
				</div>
				<div class="col">
					<p>2</p>
				</div>
				<div class="col">
					<p>Companhia das letrinhas</p>
				</div>
				<div class="col-2">
					<a class="btn btn-blue w-100 pb-2" href="#"
                   	role="button">Visualizar</a>
				</div>
			</div>
    	</div>
    </div>
</div>
</body>
<c:import url="template-footer.jsp" />
</html>