<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, model.domain.Cupom,model.domain.enums.TipoCupom" %>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<c:url value="/controlador" var="stub"/>
	<%
		List<Cupom> cupons = (List<Cupom>) request.getAttribute("cupons");
		List<TipoCupom> tipos = TipoCupom.getTiposCupom(); 
	%>
<body>
<c:import url="template-header-admin.jsp" />

<div class="container">
	<p class="h4 mb-3 mt-5">Cupons cadastrados</p>
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
			
			
			<div class="row d-flex align-items-center">
			
			<%if(cupons != null){ 
				for(Cupom cupom : cupons){%>
				<form action="${stub}" method="post" novalidate>
					<div class="row pt-2 mb-2 d-flex align-items-center">
					
						<div class="col-1">
							<input class="form-control mt-2" type="text" id="codigo"
								name="codigo" value="<%=cupom.getCodigo()%>" required="true" min="1"/>
						</div>				
					
						<div class="col-2">
							<input class="form-control mt-2" type="text" id="nome"
								name="nome" value="<%=cupom.getNome()%>" required="true" />
						</div>
						
					
						<div class="col-1">
							<input class="form-control mt-2" type="text" id="valor"
								name="valor" value="<%=cupom.getValor()%>" required="true" />
						</div>
						
						
						<div class="col-2">
						<fmt:formatDate var="fmtDate" value="<%=cupom.getValidade()%>" pattern="dd/MM/yyyy"/>
						<input class="form-control mt-2" type="text" id="validade" name="validade" value="${fmtDate}"/>			
						</div>

						<div class="col-2"> 
							<select class="form-control mt-2" name="tipo" id="tipo" required="true">
                            	<option value="">Escolha...</option>
                                  	<%if(tipos != null){ 
										for(TipoCupom tipo : tipos){%>
                                        	<option value="<%=tipo.name()%>" <%= cupom.getTipo().name() == tipo.name() ?
                                        		"selected" : ""%>> <%=tipo.getDescricao() %> </option>
                                        <%}
                                  	} %>
                            </select>
                                
						</div>
					
					
						
						<input type="hidden" name="id" value="<%=cupom.getId()%>" />
						<input type="hidden" name="acao" value="alterar" />
						<input type="hidden" name="viewHelper" value="AlterarCupomVH" />
						<div class="col-2">
							<button class="btn btn-blue w-100" type="submit" title="Atualizar" alt="Atualizar">
								Atualizar
							</button>
						</div>
						<div class="col-2">
							<a class="btn btn-secondary w-100" href="/ecommerce/controlador?acao=excluir&viewHelper=ExcluirCupomVH&id=<%=cupom.getId()%>" title="Excluir">Excluir</a>	
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