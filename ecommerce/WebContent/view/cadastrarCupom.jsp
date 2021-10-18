<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/controlador" var="stub"/>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<body>
<c:import url="template-header-admin.jsp" />
<div class="container">
	<p class="h4 mb-3 mt-5">Cadastrar cupom</p>
	<div class="card shadow mb-5 pb-4">
		<div class="card-body">
				<div class="row mt-4">			
					<div class="col-1">
						<p class="h5">Código</p>
					</div>		
					<div class="col-4">
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
				</div>
				
				<form id="formCadastroCupom" action="${stub }" method="post" novalidate>
					
					<div class="row pt-2 mb-2 d-flex align-items-center">
						<div class="col-1">
							<input class="form-control mt-2" type="text" id="codigo"
								name="codigo" required="true" />
						</div>			
						<div class="col-4">
							<input class="form-control mt-2" type="text" id="nome"
								name="nome" required="true" />
						</div>			
						<div class="col-1">
							<input class="form-control mt-1" type="text" id="valor"
								name="valor" required="true" />
						</div>		
						<div class="col-2">
							<input class="form-control mt-2" type="date" id="validade"
								name="validade" required="true" />
						</div>			
						<div class="col-2">
									<select	class="form-control" name="tipo" id="tipo" required="true">
										<option value="">Escolha...</option>
										<option value="PROMOCIONAL">Promocional</option>
										<option value="TROCA">Troca</option>
									</select>
						</div>	
						
						<input type="hidden" name="acao" value="salvar" />
						<input type="hidden" name="viewHelper" value="CadastroCupomVH" />
						
						
							<div class="col-2">									
								<button class="btn btn-blue w-100" type="submit" title="Salvar" alt="Salvar">
								Salvar
								</button>	
							</div>						
					</div>
				</form>
			</div>
	</div>
				<div class="col-2">
					<a class="btn btn-secondary w-100" href="" title="Voltar">Voltar</a>	
				</div>				
			</div>
</body>
<c:import url="template-footer.jsp" />
</html>