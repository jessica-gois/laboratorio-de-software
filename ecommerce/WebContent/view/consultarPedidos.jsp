<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, model.domain.Pedido,model.domain.enums.StatusPedido" %>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<fmt:setLocale value="pt_BR" />
<c:url value="/controlador" var="stub" />
<%
		//List<Pedido> pedidos = (List<Pedido>) request.getSession().getAttribute("pedidos");
		  List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");

		List<StatusPedido> tipos = StatusPedido.getTiposStatus();
	%>
<body>
    <c:import url="template-header-admin.jsp" />
    <div class="container">
        <p class="h4 mb-3 mt-5">Consultar pedidos</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <!-- In�cio R�tulos das consultas / T�tulos colunas-->
                <div class="row mt-4">
                    <div class="col">
                        <p class="h5">C�digo pedido</p>
                    </div>
                    <div class="col">
                        <p class="h5">Data</p>
                    </div>
                    <div class="col">
                        <p class="h5">Email</p>
                    </div>
                    <div class="col">
                        <p class="h5">CPF</p>
                    </div>
                    <div class="col">
                        <p class="h5">Total</p>
                    </div>
                    <div class="col">
                        <p class="h5">Status</p>
                    </div>
                    <div class="col-2">
                        <p class="h5" style="color: #FFF;"></p>
                    </div>
                </div>
                <!-- Fim R�tulos das consultas / T�tulos colunas-->
                <!-- In�cio inputs-->
                <div class="row mt-2 mb-4">
                    <div class="col">
                        <select class="form-control" name="id" id="id" required="true">
                            <option value="">Escolha...</option>
                            <%if(pedidos != null){ 
														for(Pedido pedido : pedidos){%>
                            <option value="<%=pedido.getId()%>">
                                <%=pedido.getId() %></option>
                            <%}
												} %>
                        </select>
                    </div>
                    <div class="col">
                        <input class="form-control" type="text" id="dtCadastro" name="dtCadastro" />
                    </div>
                    <div class="col">
                        <input class="form-control" type="email" id="email" name="email" />
                    </div>
                    <div class="col">
                        <input class="form-control" type="text" id="cpf" name="cpf" />
                    </div>
                    <div class="col">
                        <input class="form-control" type="text" id="valorTotal" name="valorTotal" />
                    </div>
                    <div class="col">
                        <select class="form-control" name="tipo" id="tipo" required="true">
                            <option value="">Escolha...</option>
                            <%if(tipos != null){ 
							for(StatusPedido tipo : tipos){%>
                            <option value="<%=tipo.name()%>"> <%=tipo.getDescricao() %> </option>
                            <%}
							} %>
                        </select>
                    </div>
                    <div class="col-2">
                        <a class="btn btn-blue w-100 pb-2" id="consultar" name="consultar"
                            href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarPedidoVH&id="
                            title="Consultar" alt="Consultar">Consultar</a>
                    </div>
                </div>
                <!-- Fim inputs-->
                <!-- In�cio gets das consultas / retorno do banco-->
                <hr class="my-4">
                <%if(pedidos != null){ 
				for(Pedido pedido : pedidos){%>
                <form action="${stub}" method="post" novalidate>
                    <div class="row mb-4">
                        <div class="col">
                            <p><%=pedido.getId()%></p>         		    
                        </div>
                        <div class="col">
                            <p>
                                <fmt:formatDate value="<%=pedido.getDtCadastro()%>" pattern="dd/MM/yyyy" />
                            </p>
                        </div>
                        <div class="col">
                            <p><%=pedido.getCliente().getUsuario().getEmail() %></p>
                        </div>
                        <div class="col">
                            <p><%=pedido.getCliente().getCpf() %></p>
                        </div>
                        <div class="col">
                            <p>
                                <fmt:formatNumber value="<%=pedido.getValorTotal() %>" type="currency" />
                            </p>
                        </div>
                        <div class="col">                  
                            <p><%=pedido.getStatus() != null ? pedido.getStatus().getDescricao() : ""%></p>
                        </div>
                        <div class="col-2">
                            <a class="btn btn-blue w-100" id="consultar" name="consultar"
                                href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarMovimentacoesVH&id="
                                title="Consultar" alt="Consultar">Consultar</a>
                        </div>
                    </div>
                    <!-- Fim gets das consultas / retorno do banco-->
                </form>
                <%}
			} %>
            </div>
        </div>
             <div class="col-2">
                <a class="btn btn-secondary w-100" href="" title="Voltar">Voltar</a>
            </div>
    </div>
</body>
<!--  
<c:import url="template-footer.jsp" />
-->
</html>