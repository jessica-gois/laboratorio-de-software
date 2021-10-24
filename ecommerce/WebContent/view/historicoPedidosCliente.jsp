<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, model.domain.Pedido,model.domain.Cliente" %>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<%
	List<Pedido> pedidos = (List<Pedido>) request.getSession().getAttribute("pedidos");
	String nomeCliente = (String) request.getSession().getAttribute("nomeCliente");
	String idCliente = (String) request.getSession().getAttribute("idCliente");
	String caminhoRedirecionar = "/view/detalharPedido.jsp";
%>
<body>
    <c:import url="template-header-admin.jsp" />
    <fmt:setLocale value = "pt_BR"/>
    <div class="container">
        <p class="h4 mb-3 mt-5">Histórico de pedidos</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <div class="row">
                    <div class="col-8">
                        <p class="h3"><%=nomeCliente%></p>
                    </div>
                    <div class="col-2">
                        <p class="h3"><%=idCliente%></p>
                    </div>
                </div>
                <hr class="my-4">
                <div class="row mt-4">
                    <div class="col">
                        <p class="h5">Número do pedido</p>
                    </div>
                    <div class="col">
                        <p class="h5">Valor</p>
                    </div>
                    <div class="col">
                        <p class="h5">Status</p>
                    </div>
                    <div class="col">
                        <p class="h5">Data</p>
                    </div>
                    <div class="col-2">
                        <p class="h5" style="color: #FFF;"></p>
                    </div>
                </div>


                <hr class="my-4">
                <%if(pedidos != null && !pedidos.isEmpty()){
                	for(Pedido pedido : pedidos){%>
	                <div class="row mb-4">
	                    <div class="col">
	                        <p><%=pedido.getId()%></p>
	                    </div>
	                    <div class="col">
	                        <p><fmt:formatNumber value = "<%=pedido.getValorTotal()%>" type="currency"/></p>
	                        </select>
	                    </div>
	                    <div class="col">
	                        <p><%=pedido.getStatus().getDescricao()%></p>
	                    </div>
	                    <div class="col">
	                        <p><fmt:formatDate value="<%=pedido.getDtCadastro()%>" pattern="dd/MM/yyyy"/></p>
	                    </div>
	                    <div class="col-2">
	                        <a class="btn btn-blue w-100 pb-2" href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarPedidoVH&caminhoRedirecionar=<%=caminhoRedirecionar%>&id=<%=pedido.getId()%>" role="button">Visualizar</a>
	                    </div>
	                </div>
                <%}
                }%>
            </div>
        </div>
        <div class="col-2">
            <a class="btn btn-secondary w-100" href="/ecommerce/view/consultarClientes.jsp" title="Voltar">Voltar</a>
        </div>
    </div>
</body>
<c:import url="template-footer.jsp" />

</html>