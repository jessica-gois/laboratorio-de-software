<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<body>
	<c:import url="template-header-admin.jsp" />
	<div class="container">
		<p class="h1 mb-3 mt-5">Login</p>
		<div class="card shadow mb-5 pb-5">
			<div class="card-body">
				<p class="mp-4">Insira o e-mail e a senha do usuário cadastrado</p>
				
				<div class="col-10 mb-3">
					<form id="formLoginAdmin" action="" method="post" novalidate>
						<span class="error"><%=request.getParameter("mensagemErro") != null ? (String) request.getParameter("mensagemErro") : ""%></span>
						<div class="col-6">
							E-mail: <input class="form-control mt-2" type="email" name="email"
								id="email" required="true" />
						</div>
						<div class="col-6 mt-4">
							Senha: <input class="form-control mt-2" type="password" name="senha"
								id="senha" required="true" />
						</div>						
						<div>
							<br/>
							<button class="btn btn-blue w-25" alt="Entrar"
								title="Entrar" type="submit">
								Entrar
								<!--<i class="fas fa-sign-in-alt"></i>-->
							</button>
							<button class="btn white border w-25" alt="Limpar" title="Limpar"
								type="reset">
								Limpar
								<!--<i class="fas fa-eraser"></i>-->
							</button>
						</div>

					</form>
				</div>
				
			</div>
		</div>
	</div>
</body>
<c:import url="template-footer.jsp" />
</html>