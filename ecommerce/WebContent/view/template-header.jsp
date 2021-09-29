		<link href="fontawesome/css/all.css" rel="stylesheet">
		
		<div class="cabecalho-ecomm mb-3 p-3 d-flex justify-content-between shadow">
		 <a href="/ecommerce/view/index.jsp"><img src="imagens/logo.png" alt="Logo" height="80" width="200px" ></a>
		 <!-- <span class="logo "alt="Administrador" title="Administrador"><i class="fas fa-user-tie"></i></span>-->	

	<div class="dropdown d-flex align-items-center">
		<button class="btn btn-primary btn-lg btn-block btn-custom dropdown-toggle" type="button"
			id="dropdownMenuButton" data-bs-toggle="dropdown" alt="Minha conta" title="Minha conta"
			aria-expanded="false">
			<i class="fas fa-user-circle"></i>
		</button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			<%if (request.getSession().getAttribute("clienteLogado")==null){%>
			<li><a class="dropdown-item" href="/ecommerce/view/login.jsp">Entrar</a></li>
			<li><a class="dropdown-item" href="/ecommerce/view/cadastraCliente.jsp">Cadastro</a></li>
			<%} %>
			<%if (request.getSession().getAttribute("clienteLogado")!=null){%>
				<li><a class="dropdown-item" href="/ecommerce/view/listaClientes.jsp">Minha conta</a></li>			
			<li><a class="dropdown-item" href="#">Meus pedidos</a></li>
			<li><a class="dropdown-item" href="/ecommerce/controlador?acao=Logout">Sair</a></li>	
			<%}%>		
		</ul>
	</div>
</div>


		<!--<div class="container">
			<nav class="navbar navbar-expand navbar-light bg-light mb-3 shadow">
				<div class="navbar-nav col-8 me-2">					
					<a class="nav-link " href="">Comprar livros</a>
					<a class="nav-link " href="">Categorias</a>
					<a class="nav-link " href="">Cupons</a>
					<a class="nav-link "><i class="fas fa-shopping-cart"></i></a>
				</div>

				 <div class="container-fluid">
					<form class="d-flex">
						<input class="form-control me-2 shadow-sm" type="search" placeholder="Escreva o que procura">
						<button class="btn btn-secondary w-20" type="submit" alt="Buscar" title="Buscar">
							<i class="fas fa-search"></i>
						</button>
					</form>
				</div>
			</nav>
		</div> -->