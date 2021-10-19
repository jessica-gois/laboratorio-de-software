<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, model.domain.GrupoPrecificacao" %>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<c:url value="/controlador" var="stub"/>
	<%
		List<GrupoPrecificacao> grupos = (List<GrupoPrecificacao>) request.getAttribute("grupos");
	%>
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
				<form id="formCadastroPrecificacao" action="${stub}" method="post"
					novalidate>
					<div class="row pt-2 mb-2 d-flex align-items-center">
						<div class="col-5">
							<input class="form-control mt-2" type="text" id="descricao"
								name="descricao" required="true" />
						</div>
						<div class="col-2">
							<input class="form-control mt-2" type="number" id="margemLucro"
								name="margemLucro" required="true" min="1" />
						</div>
						<input type="hidden" name="acao" value="salvar" />
						<input type="hidden" name="viewHelper" value="CadastroGrupoPrecificacaoVH" />
						<div class="col-2">
							<!-- <a class="btn btn-blue w-100"
								href="/ecommerce/controlador?acao=salvar&viewHelper=CadastroGrupoPrecificacaoVH"
								title="Salvar" alt="Salvar">Salvar</a>-->
								<button class="btn btn-blue w-100" type="submit" title="Salvar" alt="Salvar">
									Salvar
								</button>
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
			<%if(grupos != null){ 
				for(GrupoPrecificacao grupo : grupos){%>
				<form action="${stub}" method="post" novalidate>
					<div class="row pt-2 mb-2 d-flex align-items-center">
						<div class="col-3">
							<input class="form-control mt-2" type="text" id="descricaoAtualizar"
								name="descricaoAtualizar" value="<%=grupo.getDescricao()%>" required="true" />
						</div>
						<div class="col-2">
							<input class="form-control mt-2" type="number" id="margemLucroAtualizar"
								name="margemLucroAtualizar" value="<%=grupo.getMargemLucro()%>" required="true" min="1"/>
						</div>
						<div class="col-2">
							<p><fmt:formatDate value="<%=grupo.getDtCadastro()%>" pattern="dd/MM/yyyy"/></p>
						</div>
						<input type="hidden" name="id" value="<%=grupo.getId()%>" />
						<input type="hidden" name="acao" value="alterar" />
						<input type="hidden" name="viewHelper" value="AlterarGrupoPrecificacaoVH" />
						<div class="col-2">
							<button class="btn btn-blue w-100" type="submit" title="Atualizar" alt="Atualizar">
								Atualizar
							</button>
						</div>
						<div class="col-2">
							<a class="btn btn-secondary w-100" href="/ecommerce/controlador?acao=excluir&viewHelper=ExcluirGrupoPrecificacaoVH&id=<%=grupo.getId()%>" title="Excluir">Excluir</a>	
						</div>				
					</div>
				</form>
			<%}
			} %>
			</div>
	</div>
	</div>
</body>
<!--<c:import url="template-footer.jsp" />-->
</html>