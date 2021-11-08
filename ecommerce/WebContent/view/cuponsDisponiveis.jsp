<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List,model.domain.Cupom" %>
<!DOCTYPE html>
<html>

<head>
    <c:import url="template-head.jsp" />
    <title>Cupons</title>
</head>
<%
	List<Cupom> cupons = (List<Cupom>) request.getSession().getAttribute("cupons");
%>
<fmt:setLocale value = "pt_BR"/>
<body>
    <header>
        <c:import url="template-header.jsp" />
    </header>
    <div class="container">
        <div class="card shadow mb-5 pb-5">
            <div class="card-body">
                <h3>Cupons</h3>
                <hr class="my-3">
                <div class="row">
                    <div class="col">
                        <p class="h5">Tipo</p>
                    </div>
                    <div class="col">
                        <p class="h5">Descrição</p>
                    </div>                    
                    <div class="col">
                        <p class="h5">Código</p>
                    </div>
                    <div class="col">
                        <p class="h5">Valor</p>
                    </div>
                    <div class="col">
                        <p class="h5">Status</p>
                    </div>
                </div>
                <hr class="my-2">
                <%if(cupons != null){
                	for(Cupom cupom : cupons){%>                
	                <div class="row pt-2">
	                    <div class="d-flex align-items-end col ">
	                        <p><%=cupom.getTipo() != null ? cupom.getTipo().getDescricao() : "" %></p>
	                    </div>
	                    <div class="col">
	                        <p><%=cupom.getNome()%></p>
	                    </div>
	                    <div class="col">
	                        <p><%=cupom.getCodigo() %></p>
	                    </div>
	                    <div class="col">
	                        <p><fmt:formatNumber value = "<%=cupom.getValor() %>" type = "currency"/></p>
	                    </div>
	                    <div class="col">
	                        <p><%=cupom.isAplicado() ? "Utilizado" : "Disponível" %></p>
	                    </div>
	                </div>
                <%} 
                }%>
            </div>
        </div>
        <div class="row mt-4"> 
            <div class="col-3">
                <a class="btn btn-secondary w-100" href="listaClientes.jsp">Voltar</a>
            </div>
        </div>
    </div>
</body>
</html>