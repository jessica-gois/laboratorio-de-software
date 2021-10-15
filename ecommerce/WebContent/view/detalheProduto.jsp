<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="model.domain.Livro"%>
<c:url value="/controlador" var="stub"/>
<!DOCTYPE html>
<html>
	<head>
		<c:import url="template-head.jsp" />
	<title>Detalhe do produto</title>
	</head>
	<%
		Livro livro = (Livro) request.getAttribute("livro");
	%>
	<fmt:setLocale value = "pt_BR"/>							

	<body>
		<header>
			<c:import url="template-header.jsp"/>
		</header>
		<div class="container">
			<div class="card shadow mb-5 pb-4">
				<div>
					<div class="card-body">
						<div class="d-flex  justify-content-between">
						<h3><%=livro.getTitulo() %></h3>
						<p class="h3 pe-4"><fmt:formatNumber value = "<%=livro.getPrecoVenda()%>" type = "currency"/></p>
						</div>
						<hr class="my-2">
						<div class="row">
							<div class="col-3 me-4">
								 <img src="view/<%=livro.getCaminhoImagem()%>" height="280" />
								<center> Categoria: Aventura</center>							 
							</div>
							<div class="col-8">
								<div class="row mb-3">
									<div class="col-4">
										<p class="h5">Autor</p>
										<%=livro.getAutor() %>
									</div>
									<div class="col-4">
										<p class="h5">Ano</p>
										<%=livro.getAno()%>
									</div>	
									<div class="col-4">
										<p class="h5">Editora</p>
										<%=livro.getEditora() %>
									</div>																
								</div>
								<div class="row mb-3">
									<div class="col-4">
										<p class="h5">ISBN</p>
										<%=livro.getIsbn() %>
									</div>
									<div class="col-4">
										<p class="h5">Código de barras</p>
										 <%=livro.getCodigoBarras() %>
									</div>
									<div class="col-4">
										<p class="h5">Edição</p>
										<%=livro.getEdicao() %>
									</div>
								</div>	
								<div class="row mb-3">
									<div class="col-4">
										<p class="h5">Altura</p>
										<%=livro.getAltura()%> cm
									</div>
									<div class="col-4">
										<p class="h5">Largura</p>
										 <%=livro.getLargura() %> cm
									</div>
									<div class="col-4">
										<p class="h5">Profundidade</p>
										<%=livro.getProfundidade() %> cm
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-4">
										<p class="h5">Peso</p>
										<%=livro.getPeso() %>g
									</div>
									<div class="col-4">
										<p class="h5">Páginas</p>
										 <%=livro.getQtdPaginas() %>
									</div>
									<div class="col-4">
										<p class="h5">Status</p>
										<%=livro.getQtdEstoque() != null && livro.getQtdEstoque() > 0 ? "Em " : "Sem "%>estoque
									</div>
								</div>							
							</div>
							</div>				
								<div class="row">
									<div class="col-12">
										<br/>
										<h4>Sinopse</h4>
										<%=livro.getSinopse() %>
									</div>
							</div>
							<br/>
							<form id="formAdicionarCarrinho" action="${stub }" method="get" novalidate>
								<div class="row d-flex justify-content-space-between">
									<%if(livro.getQtdDisponivelCompra() != null && livro.getQtdDisponivelCompra() > 0){%>
										<div class="col-4">
											<h4>Quantidade:</h4>
											<input class="form-control" type="number" name="quantidade"
												id="quantidade" min="1" max="<%=livro.getQtdDisponivelCompra()%>"
												required="true" placeholder="Informe a quantidade..."  />
										</div>
									<%}%>
									
									<input type="hidden" name="acao" value="consultar" />
									<input type="hidden" name="acaoCarrinho" value="adicionarItem" />
									<input type="hidden" name="viewHelper" value="AdicionarCarrinhoVH" />
									<input type="hidden" name="id" value="<%=livro.getId()%>"/>
									
									<%if(livro.getQtdDisponivelCompra() != null && livro.getQtdDisponivelCompra() > 0){%>
										<div class="col-auto d-flex align-items-end">
											<button class="btn btn-blue" type="submit" title="Adicionar ao carrinho"
												alt="Adicionar ao carrinho">Adicionar ao carrinho</button>
										</div>
									<%} %>
									<div class="col-auto d-flex align-items-end">
										<a class="btn btn-secondary" href="view/index">Voltar</a>
									</div>
								</div>
							</form>	
							<div class="row">
								<!--  <div class="col-4 mt-3">
									<a class="btn btn-blue w-100"href="#" >Comprar</a>
								</div>-->
								<div class="col-auto d-flex align-items-end">									
									
								</div>
							</div>			
				</div>
			</div>
		</div>
	</body>
</html>