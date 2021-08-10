<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,entidades.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de Sucesso</title>
<link rel="stylesheet" href="style.css">
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