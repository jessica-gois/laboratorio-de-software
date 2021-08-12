<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,model.domain.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<title>Sucesso cadastro</title>
<style>
.cabecalho-ecomm {
	background: #7209b7;
	color: white;
	font-size: 20px;
	font-family: Verdana;
	padding: 20px;
}

.fonte-admin {
	color: white;
	font-size: 16px;
	font-family: Verdana;
}
</style>
</head>
<body>
		<c:if test="${not empty cliente}">
			Cliente ${ cliente } cadastrado com sucesso!
		</c:if>
		
		<c:if test="${empty cliente}">
			Nenhum cliente cadastrado.
		</c:if>

</body>
</html>