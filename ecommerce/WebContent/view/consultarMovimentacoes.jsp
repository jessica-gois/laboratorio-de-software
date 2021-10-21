<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, model.domain.MovimentacaoEstoque,model.domain.enums.TipoMovimentacao, model.domain.Livro" %>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<fmt:setLocale value="pt_BR" />
<c:url value="/controlador" var="stub" />
<%
		List<MovimentacaoEstoque> movimentacoes = (List<MovimentacaoEstoque>) request.getSession().getAttribute("movimentacoes");
		List<TipoMovimentacao> tipos = TipoMovimentacao.getTiposMovimentacao(); 
		List<Livro> livros = (List<Livro>) request.getSession().getAttribute("livros");
	%>

<body>
    <c:import url="template-header-admin.jsp" />
    <div class="container">
        <p class="h4 mb-3 mt-5">Consultar movimentações</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <!-- Início Rótulos das consultas / Títulos colunas-->
                <div class="row mt-4">
                    <div class="col">
                        <p class="h5">Data</p>
                    </div>
                    <div class="col">
                        <p class="h5">Tipo</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Livro</p>
                    </div>
                    <div class="col">
                        <p class="h5">Quantidade</p>
                    </div>
                    <div class="col">
                        <p class="h5">Fornecedor</p>
                    </div>
                    <div class="col">
                        <p class="h5">Preço de custo</p>
                    </div>
                    <div class="col-2">
                        <p class="h5" style="color: #FFF;"></p>
                    </div>
                </div>
                <!-- Fim Rótulos das consultas / Títulos colunas-->
                <!-- Início inputs-->
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
                    <div class="col-3">
                        <input class="form-control" type="text" id="livro" name="livro" />
                    </div>
                    <div class="col">
                        <input class="form-control" type="number" id="quantidade" name="quantidade" />
                    </div>
                    <div class="col">
                        <input class="form-control" type="text" id="fornecedor" name="fornecedor" />
                    </div>
                    <div class="col">
                        <input class="form-control" type="text" id="precoCusto" name="precoCusto" />
                    </div>
                    <div class="col-2">
                        <a class="btn btn-blue w-100 pb-2" id="consultar" name="consultar"
                            href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarMovimentacoesVH&id="
                            title="Consultar" alt="Consultar">Consultar</a>
                    </div>
                </div>
                <!-- Fim inputs-->
                <!-- Início gets das consultas / retorno do banco-->
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
                            <p><%=mov.getTipo().getDescricao()%></p>
                        </div>
                        <div class="col-3">
                            <p><%=mov.getItemEstoque() != null && mov.getItemEstoque().getLivro() != null ? 
                       		    mov.getItemEstoque().getLivro().getTitulo() : ""%></p>
                        </div>
                        <div class="col">
                            <fmt:formatNumber value="<%=mov.getQuantidade()%>" type="number" maxFractionDigits="0" />
                        </div>
                        <div class="col">
                            <p><%=mov.getFornecedor()%></p>
                        </div>
                        <div class="col-2">
                            <p>
                                <fmt:formatNumber value="<%=mov.getPrecoCusto()%>" type="currency" />
                            </p>
                        </div>
                        <div class="col">
                        </div>
                    </div>
                    <!-- Fim gets das consultas / retorno do banco-->
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