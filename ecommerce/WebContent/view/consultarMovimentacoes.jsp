<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<body>
<c:import url="template-header-admin.jsp" />
<div class="container">
	<p class="h4 mb-3 mt-5">Consultar movimentações</p>
	<div class="card shadow mb-5 pb-4">
    	<div class="card-body d-flex justify-content-center">
    		<div class="row mt-4">
				<div class="col-3">
					<p class="h5">Data</p>
				</div>
				<div class="col-3">
					<p class="h5">Tipo</p>
				</div>
				<div class="col-3">
					<p class="h5">Livro</p>
				</div>
				<div class="col-3">
					<p class="h5">Qtd</p>
				</div>
				<div class="col-3">
					<p class="h5">Fornecedor</p>
				</div>
				<div class="col-3">
					<p class="h5" style="color: #FFF;"></p>
				</div>
				<div class="col-3">
					<p class="h5" style="color: #FFF;"></p>
				</div>
			</div>
    	</div>
    </div>
</div>
</body>
<c:import url="template-footer.jsp" />
</html>