<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,model.domain.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<head>
<c:import url="template-head.jsp"/>
<title>Sucesso</title>
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