<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, model.domain.Cliente" %>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<fmt:setLocale value="pt_BR" />
<c:url value="/controlador" var="stub" />
<% 
	List<Cliente> clientes = (List<Cliente>) request.getSession().getAttribute("clientes");
%>
<body>
    <c:import url="template-header-admin.jsp" />
    <div class="container">
        <p class="h4 mb-3 mt-5">Consultar Clientes</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <form id="formConsultaCliente" action="${stub}" method="post" novalidate>
                    <div class="row pt-2 mb-2 d-flex align-items-center">
                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-2">
                                    <p class="h5">C�digo</p>
                                </div>
                                <div class="col-6">
                                    <p class="h5">E-mail</p>
                                </div>
                                 <div class="col-2">
                                    <p class="h5">CPF</p>
                                </div>
                                <div class="col-2">
                                    <p class="h5">Status</p>
                                </div>
                            </div>
                            <div class="row d-flex align-items-center">
                                <div class="col-2">
                                    <input class="form-control mt-1" type="text" id="codigo" name="codigo"
                                        required="true" />
                                </div>
                                <div class="col-6">
                                    <input class="form-control mt-1" type="email" id="email" name="email"
                                        required="true" />
                                </div>
                                <div class="col-2">
                                    <input class="form-control mt-1" type="text" id="cpf" name="cpf" required="true" />
                                </div>
                                <div class="col-2">
                                    <select class="form-control mt-1" id="status" name="status" required="true">
                                        <option value="">Escolha...</option>
                                        <option value="true">Ativo</option>
                                        <option value="false">Inativo</option>
                                   	</select>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="row">
                                <div class="col-4">
                                    <p class="h5">Nome</p>
                                </div>
                                <div class="col-6">
                                    <p class="h5">Sobrenome</p>
                                </div>
                                <div class="col-2">
                                    <p class="h5">Data de nascimento</p>
                                </div>
                            </div>
                            <div class="row d-flex align-items-center">
                                <div class="col-4">
                                    <input class="form-control mt-1" type="text" id="nome" name="nome"
                                        required="true" />
                                </div>
                                <div class="col-6">
                                    <input class="form-control mt-1" type="text" id="sobrenome" name="sobrenome"
                                        required="true" />
                                </div>
                                <div class="col-2">
                                    <input class="form-control mt-1" type="date" id="dataNascimento"
                                        name="dataNascimento" required="true" />
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="acao" value="consultar" />
						<input type="hidden" name="viewHelper" value="ConsultarClientesVH" />
						<input type="hidden" name="tipoPesquisa" value="filtros"/>
                        <div class="row mt-4">
                            <div class="col-2">
                                <button class="btn btn-blue w-100" id="buscar" type="submit" name="buscar"title="Buscar"
                                    alt="Bot�o de busca">Buscar</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <p class="h4 mb-3 mt-5">Resultados filtrados</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <div class="row mt-4">
                    <div class="col-1">
                        <p class="h5">C�digo</p>
                    </div>
                    <div class="col-2">
                        <p class="h5">Nome</p>
                    </div>
                    <div class="col-2">
                        <p class="h5">Nascimento</p>
                    </div>
                    <div class="col-2">
                        <p class="h5">CPF</p>
                    </div>
                    <div class="col-2">
                        <p class="h5">E-mail</p>
                    </div>
                    <div class="col-1">
                        <p class="h5">Score</p>
                    </div>
                    <div class="col-1">
                        <p class="h5">Status</p>
                    </div>
                    <div class="col-1">
                        <p class="h5" style="color: #FFF;"></p>
                    </div>
                </div>
                 <%if(clientes != null){ 
					for(Cliente cliente : clientes){%>
		                <form action="${stub}" method="get" novalidate>
		                    <div class="row pt-2 mb-2 d-flex align-items-center">
		                        <div class="col-1">
		                            <p><%=cliente.getId()%><p/>
		                        </div>
		                        <div class="col-2">
		                            <p><%=cliente.getNomeCompleto()%><p/>
		                        </div>
		                        <div class="col-2">
                       				<p><fmt:formatDate value="<%=cliente.getDataNascimento()%>" pattern="dd/MM/yyyy" /></p>
                    			</div>
		                        <div class="col-2">
		                            <p><%=cliente.getCpf()%><p/>
		                        </div>
		                        <div class="col-2">
		                            <p><%=cliente.getUsuario().getEmail()%><p/>
		                        </div>
		                        <div class="col-1">
		                            <p><%=cliente.getScore()%><p/>
		                        </div>
		                        <div class="col-1">
		                            <p><%=cliente.getUsuario().getStatus() != null && cliente.getUsuario().getStatus() ? "Ativo" : "Inativo" %><p/>
		                        </div>
		                        <input type="hidden" name="acao" value="consultar" />
								<input type="hidden" name="viewHelper" value="ConsultarPedidosVH" />
								<input type="hidden" name="nomeCliente" value="<%=cliente.getNome() + " " + cliente.getSobrenome()%>" />
								<input type="hidden" name="idCliente" value="<%=cliente.getId()%>" />
		                        <div class="col-1">
		                            <button class="btn btn-blue w-100" id="visualizarPedidos" name="visualizarPedidos"
		                               type="submit" title="Visualizar pedidos" alt="Visualizar pedidos">Pedidos</button>
		                        </div>
		                    </div>             
		                </form>
	                <%}
				}else{%>
				  <p class="h5">Nenhum resultado encontrado</p>				
				<%} %>
            </div>
        </div>
    </div>
</body>
<!-- 
<c:import url="template-footer.jsp" />
 -->
</html>