		<link href="fontawesome/css/all.css" rel="stylesheet">
		
		<div class="cabecalho-ecomm mb-3 p-3 d-flex justify-content-between shadow">
		 <img src="imagens/logo.png" alt="Logo" height="80" width="200px" >
		 <span class="logo "alt="Administrador" title="Administrador"><i class="fas fa-user-tie"></i></span>
		</div>


		<div class="container">
			<nav class="navbar navbar-expand navbar-light bg-light mb-3">
				<div class="navbar-nav col-8 me-2">
					<a class="nav-link " href="/ecommerce/controlador?acao=IndexFormulario">
						<i class="fas fa-home" alt="Home" title="Home"></i>
					</a> 
					<a class="nav-link " href="">Comprar livros</a> 
					<a class="nav-link " href="/ecommerce/controlador?acao=ListaClientes"> Minha conta </a> 
					<a class="nav-link " href="/ecommerce/controlador?acao=CadastraClienteFormulario"> Cadastro </a> 
					<a class="nav-link " href=""> Meus pedidos</a> 
					<a class="nav-link " href="/ecommerce/controlador?acao=LoginFormulario"> Login </a> 
					<a class="nav-link " href="/ecommerce/controlador?acao=Logout">Sair</a>
					<a class="nav-link "><i class="fas fa-shopping-cart"></i></a>
				</div>

				<div class="container-fluid">
					<form class="d-flex">
						<input class="form-control me-2 shadow-sm" type="search" placeholder="escreva o que procura">
						<button class="btn btn-secondary w-20" type="submit" alt="Buscar" title="Buscar">
							<i class="fas fa-search"></i>
						</button>
					</form>
				</div>
			</nav>
		</div>