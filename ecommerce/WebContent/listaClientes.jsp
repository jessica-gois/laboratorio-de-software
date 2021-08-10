<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,entidades.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

		<c:if test="${not empty cliente}">
			Cliente ${ cliente } cadastrado com sucesso!
		</c:if>
	
	Clientes listados: <br />
	
	<ul>
		<c:forEach items="${clientes}" var="cliente">
			
			<li>
				${cliente.nome } - <fmt:formatDate value="${cliente.dataNascimento }" pattern="dd/MM/yyyy"/> 
				<a href="/ecommerce/mostraCliente?id=${cliente.id }">edita</a>
				<a href="/ecommerce/removeCliente?id=${cliente.id }">remove</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>