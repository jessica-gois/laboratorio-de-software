<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/cadastraCliente" var="stub"/>

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
	
		Nome: <input type="text" name="nome" />
		Data de Nascimento: <input type="text" name="dataNascimento" />
		CPF: <input type="text" name="cpf" />
		Score: <input type="text" name="score" />
		Status: <input type="text" name="status" />
		<input type="submit" />

</body>
</html>