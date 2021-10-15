<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List,model.domain.Livro"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<c:url value="/cadastraCliente" var="stub" />

<!DOCTYPE html>
<html>
	<fmt:setLocale value = "pt_BR"/>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Turma do Livro</title>
<link rel="stylesheet" href="css/styles.css">
<style>
.btn-custom {
	border-radius: 50px;
}

.btn-blue {
	background-color: #4e82dd;
	color: #FFF;
}
</style>
</head>
<%
	List<Livro> livros = (List<Livro>)request.getAttribute("livros");
%>
<body>
	<header>
		<div class="content">
			<nav>
				<p class="brand">
					Turma do <strong>livro</strong>
				</p>
				<ul>
					<li><a href="#"></a>catálogo</li>
					<li><a href="/ecommerce/view/login.jsp">entrar</a></li>
					<li><a href="/ecommerce/view/cadastraCliente.jsp">cadastro</a></li>
					<button onClick="window.location.href='http://localhost:8080/ecommerce/carrinho'">carrinho</button>
				</ul>
			</nav>
			<div class="header-block">
				<div class="text">
					<h2>Livros infantis</h2>
					<p>compre e ganhe um brinde</p>
				</div>
				<img src="imagens/book.jpg" alt="Menina lendo livro">
			</div>
		</div>
	</header>
	<section class="catalog" id="catalog">
		<div class="content">
			<div class="title-wrapper-catalog">
				<p>Encontre seu favorito</p>
				<h3>catálogo</h3>
			</div>
			<div class="filter-card">
				<input type="text" class="search-input"
					placeholder="digite o livro que procura" />
				<button class="search-button">Busca</button>
			</div>

			<br>
			<div class="container">
				<%if(livros != null){ %>
				<%for(Livro livro : livros){ %>
				<div class="card shadow mb-5 pb-4">
					<div class="card-body">
						<div class="">
							<p class="h4 ps-3 "><%=livro.getTitulo()%></p>
							<div class="row">
								<table>
									<thead>
										<tr>
											<th class="col-4 pb-2 ps-4"></th>
											<th></th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody class="">
										<tr>
											<td><img src="<%=livro.getCaminhoImagem()%>" class="col-6 ps-4"
												alt="Capa do livro <%=livro.getTitulo() %>" height="120%"></td>
											<td><div class="col"><p class="h5">Preço</p><p class="h5"><fmt:formatNumber value = "<%=livro.getPrecoVenda()%>" type = "currency"/></p></div></td>
											<td></td>
											<td></td>
											<td>
												<div class="d-flex justify-content-around">
													<a class="btn btn-blue w-50"
														href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarLivroVH&id=<%=livro.getId()%>"
														title="Visualizar">Visualizar</a>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
					<%} %>
				<%}%>
			</div>
	</section>
	<footer>
		<div>&copy; Copyright Turma do Livro- 2021</div>
	</footer>
</body>

</html>