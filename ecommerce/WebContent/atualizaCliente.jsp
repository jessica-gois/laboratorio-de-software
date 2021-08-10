<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/atualizaCliente" var="stub"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1> Cadastro Cliente: </h1>

	

	<form action="${stub }" method="post">
	
		Nome: <input type="text" name="nome" value="${cliente.nome}" />
		Data de nascimento: <input type="text" name="dataNascimento" value="<fmt:formatDate value="${cliente.dataNascimento }" pattern="dd/MM/yyyy"/> " />
		CPF: <input type="text" name="cpf" value="${cliente.cpf}"/>
		Score: <input type="text" name="score" value="${cliente.score}" />
		Status: <input type="text" name="status" value="${cliente.status}" />
		<input type="hidden" name="id" value="${cliente.id }" />
		<input type="submit" />

</body>
</html>