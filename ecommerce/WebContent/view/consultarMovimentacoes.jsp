<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, model.domain.MovimentacaoEstoque,model.domain.enums.TipoMovimentacao, model.domain.Livro" %>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<c:url value="/controlador" var="stub" />
<%
		List<MovimentacaoEstoque> movimentacoes = (List<MovimentacaoEstoque>) request.getAttribute("movimentacoes");
		List<TipoMovimentacao> tipos = TipoMovimentacao.getTiposMovimentacao(); 
		List<Livro> livros = (List<Livro>) request.getSession().getAttribute("livros");
	%>

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
                        <input class="form-control" type="text" id="data" name="data" />
                    </div>

                    <div class="col">
                        <select class="form-control" name="tipo" id="tipo" required="true">
                            <option value="">Escolha...</option>
                            <%if(tipos != null){ 
							for(TipoMovimentacao tipo : tipos){%>
                            <option value="<%=tipo.name()%>"> <%=tipo.getDescricao() %> </option>
                            <%}
							} %>
                        </select>
                    </div>
                    <div class="col">
                        <input class="form-control" type="text" id="livro" name="livro" />
                    </div>
                    <div class="col">
                        <input class="form-control" type="number" id="quantidade" name="quantidade" />
                    </div>
                    <div class="col">
                        <input class="form-control" type="text" id="fornecedor" name="fornecedor" />
                    </div>
                    <div class="col-2">
                        <a class="btn btn-blue w-100 pb-2" id="consultar" name="consultar"
                            href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarMovimentacoesVH&id="
                            title="Consultar" alt="Consultar">Consultar</a>
                    </div>
                </div>
                <hr class="my-4">

                <%if(movimentacoes != null){ 
				for(MovimentacaoEstoque mov : movimentacoes){%>
                <form action="${stub}" method="post" novalidate>
                    <div class="row mb-4">

                        <div class="col">
                            <p>
                                <fmt:formatDate value="<%=mov.getDtCadastro()%>" pattern="dd/MM/yyyy" />
                            </p>
                        </div>

                        <div class="col">
                           <select class="form-control mt-2" name="tipo" id="tipo" required="true">
                            	<option value="">Escolha...</option>
                                  	<%if(tipos != null){ 
										for(TipoMovimentacao tipo : tipos){%>
                                        	<option value="<%=tipo.name()%>" <%= mov.getTipo().name() == tipo.name() ?
                                        		"selected" : ""%>> <%=tipo.getDescricao() %> </option>
                                        <%}
                                  	} %>
                            </select>
                        </div>

                        <div class="col">
                        </div>

                        <div class="col">
                        </div>

                        <div class="col">
                        </div>

                        <input type="hidden" name="id" value="<%=mov.getId()%>" />

                        <div class="col-2">
                            <a class="btn btn-blue w-100 pb-2" href="#" role="button">Visualizar</a>
                        </div>

                    </div>
                </form>
                <%}
			} %>

            </div>
        </div>
    </div>
</body>
<!--  
<c:import url="template-footer.jsp" />
-->

</html>