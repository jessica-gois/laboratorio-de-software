<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<body>
<c:import url="template-header-admin.jsp" />
	<div class="container mb-5">
		<p class="h4 mb-3 mt-5">Cadastrar livro</p>
		<form id="formCadastroLivro" action="" method="post" novalidate>
			<div class="card shadow mb-5 pb-4">
				<div class="card-body">
					<div class="row mt-4">
						<div class="col-8">
							<p class="h5">Título</p>
							<input class="form-control" type="text" id="titulo" name="titulo"
								required />
						</div>
					</div>
					<div class="row mt-1">
						<div class="col-6">
							<p class="h5">Autor</p>
							<input class="form-control" type="text" id="autor" name="autor"
								required />
						</div>
						<div class="col-1">
							<p class="h5">Ano</p>
							<input class="form-control" type="number" id="ano" name="ano"
								min="1500" max="2021" required />
						</div>
						<div class="col-5">
							<p class="h5">Editora</p>
							<input class="form-control" type="text" id="editora"
								name="editora" required />
						</div>
					</div>
					<div class="row mt-1">
						<div class="col-4">
							<p class="h5">ISBN</p>
							<input class="form-control" type="text" id="isbn" name="isbn"
								required />
						</div>
						<div class="col-4">
							<p class="h5">Código de barras</p>
							<input class="form-control" type="text" id="codigoBarras"
								name="codigoBarras" required />
						</div>
						<div class="col-4">
							<p class="h5">Edição</p>
							<input class="form-control" type="text" id="edicao" name="edicao"
								required />
						</div>
					</div>

					<div class="row mt-1">
						<div class="col-4">
							<p class="h5">Altura (cm)</p>
							<input class="form-control" type="number" id="altura"
								name="altura" max="100" required />
						</div>
						<div class="col-4">
							<p class="h5">Largura (cm)</p>
							<input class="form-control" type="number" id="largura"
								name="largura" max="100" required />
						</div>
						<div class="col-4">
							<p class="h5">Profundidade (cm)</p>
							<input class="form-control" type="number" id="profundidade"
								name="profundidade" max="100" required />
						</div>
					</div>
					<div class="row mt-1">
						<div class="col-4">
							<p class="h5">Peso (g)</p>
							<input class="form-control" type="number" id="peso" name="peso"
								max="2000" required />
						</div>
						<div class="col-4">
							<p class="h5">Quantidade de páginas</p>
							<input class="form-control" type="number" id="qtdPaginas"
								name="largura" required />
						</div>
					</div>
					<div class="row mt-1">
						<div class="col">
							<p class="h5">Sinopse</p>
							<textarea class="form-control" id="sinopse" name="sinopse"
								required></textarea>
						</div>
					</div>
					<div class="row mt-1">
						<div class="col">
							<p class="h5">Upload de imagem</p>
							<input class="form-control" type="file" accept="image/*"
								id="imagem" name="imagem" required />
						</div>
					</div>
				</div>
			</div>
			<div class="card shadow mb-5 pb-4">
				<div class="card-body">
					<div class="row mt-1 d-flex align-items-center">					
						<div class="col-4">	
							<p class="h5">Categorias</p>
							<div class="form-check">					
								<input class="form-check-input" type="checkbox" value="" id="categoria" checked>
								<label  for="categoria">
	    							Aventura
	  							</label>
  							</div>	
  							<div class="form-check">
	  							<input class="form-check-input" type="checkbox" value="" id="categoria-2">
								<label  for="categoria-2">
	    							Fábulas
	  							</label>
  							</div>
  							<div class="form-check">
	  							<input class="form-check-input" type="checkbox" value="" id="categoria-3">
								<label  for="categoria-3">
	    							Gibi
	  							</label>
  							</div>
						</div>
						<div class="col-4">
							<p class="h5">Grupo de precificação</p>
							<select class="form-control" id="grupoPrecificacao"
								name="grupoPrecificacao" required>
								<option value="">Escolha...</option>	
								</select>
						</div>
					</div>
				</div>
			</div>
			
			<div class="card shadow mb-5 pb-4">
				<div class="card-body">
					<div class="row mt-1 d-flex align-items-center">
						<div class="col-4">
							<p class="h5">Preço de venda</p>
							<input class="form-control" type="number" id="precoVenda"
								name="precoVenda" required />	
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
<!--<c:import url="template-footer.jsp" />-->
</html>