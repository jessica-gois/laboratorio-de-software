<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<body>
    <c:import url="template-header-admin.jsp" />
    <div class="container">
        <p class="h4 mb-3 mt-5">Consultar Clientes</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <form id="formConsultaCliente" action="" method="post" novalidate>
                    <div class="row pt-2 mb-2 d-flex align-items-center">
                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-3">
                                    <p class="h5">C�digo</p>
                                </div>
                                <div class="col-3">
                                    <p class="h5">Data cadastro</p>
                                </div>
                                <div class="col-6">
                                    <p class="h5">E-mail</p>
                                </div>
                            </div>
                            <div class="row d-flex align-items-center">
                                <div class="col-3">
                                    <input class="form-control mt-2" type="text" id="codigo" name="codigo"
                                        required="true" />
                                </div>
                                <div class="col-3">
                                    <input class="form-control mt-2" type="date" id="dataCadastro" name="dataCadastro"
                                        required="true" />
                                </div>
                                <div class="col-6">
                                    <input class="form-control mt-2" type="email" id="email" name="Email"
                                        required="true" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-6">
                                    <p class="h5">CPF</p>
                                </div>
                                <div class="col-4">
                                    <p class="h5">Score</p>
                                </div>
                                <div class="col-2">
                                    <p class="h5">Status</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <input class="form-control mt-2" type="text" id="cpf" name="cpf" required="true" />
                                </div>
                                <div class="col-4">
                                    <input class="form-control mt-2" type="text" id="score" name="score"
                                        required="true" />
                                </div>
                                <div class="col-2">
                                    <input class="form-control mt-2" type="text" id="status" name="status"
                                        required="true" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-2">
                                    <p class="h5">G�nero</p>
                                </div>
                                <div class="col-2">
                                    <p class="h5">DDD</p>
                                </div>
                                <div class="col-3">
                                    <p class="h5">Telefone residencial</p>
                                </div>
                                <div class="col-2">
                                    <p class="h5">DDD</p>
                                </div>
                                <div class="col-3">
                                    <p class="h5">Telefone celular</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-2">
                                    <select class="form-control" name="genero" id="genero" required="true">
                                        <option value="">Escolha...</option>
                                        <option value="F">Feminino</option>
                                        <option value="M">Masculino</option>
                                    </select>
                                </div>
                                <div class="col-2">
                                    <input class="form-control mt-2" type="text" id="ddd" name="ddd" required="true" />
                                </div>
                                <div class="col-3">
                                    <input class="form-control mt-2" type="tel" id="telefoneResidencial"
                                        name="telefoneResidencial" required="true" />
                                </div>
                                <div class="col-2">
                                    <input class="form-control mt-2" type="text" id="ddd" name="ddd" required="true" />
                                </div>
                                <div class="col-3">
                                    <input class="form-control mt-2" type="tel" id="telefoneCelular"
                                        name="telefoneCelular" required="true" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-4">
                                    <p class="h5">Nome</p>
                                </div>
                                <div class="col-4">
                                    <p class="h5">Sobrenome</p>
                                </div>
                                <div class="col-4">
                                    <p class="h5">Data de nascimento</p>
                                </div>
                            </div>
                            <div class="row d-flex align-items-center">
                                <div class="col-4">
                                    <input class="form-control mt-2" type="text" id="nome" name="nome"
                                        required="true" />
                                </div>
                                <div class="col-4">
                                    <input class="form-control mt-2" type="text" id="sobrenome" name="sobrenome"
                                        required="true" />
                                </div>
                                <div class="col-4">
                                    <input class="form-control mt-2" type="date" id="dataNascimento"
                                        name="dataNascimento" required="true" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col-2">
                                <a class="btn btn-blue w-100" id="buscar" name="buscar" href="#" title="Buscar"
                                    alt="Bot�o de busca">Buscar</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <p class="h4 mb-3 mt-5">Resultados filtrados</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <div class="row mt-4">
                    <div class="col-1">
                        <p class="h5">C�digo</p>
                    </div>
                    <div class="col-2">
                        <p class="h5">Nome</p>
                    </div>
                    <div class="col-2">
                        <p class="h5">CPF</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">E-mail</p>
                    </div>
                    <div class="col-1">
                        <p class="h5">Score</p>
                    </div>
                    <div class="col-1">
                        <p class="h5">Status</p>
                    </div>
                    <div class="col-2">
                        <p class="h5" style="color: #FFF;"></p>
                    </div>
                </div>
                <form id="formConsultarClientes" action="" method="get" novalidate>
                    <div class="row pt-2 mb-2 d-flex align-items-center">
                        <div class="col-1">
                            <p>Exemplo<p/>
                        </div>
                        <div class="col-2">
                            <p>Exemplo<p/>
                        </div>
                        <div class="col-2">
                            <p>Exemplo<p/>
                        </div>
                        <div class="col-3">
                            <p>exemplo@exemplo.com<p/>
                        </div>
                        <div class="col-1">
                            <p>Exemplo<p/>
                        </div>
                        <div class="col-1">
                            <p>Exemplo<p/>
                        </div>
                        <div class="col-2">
                            <a class="btn btn-blue w-100" id="consultar" name="consultar"
                                href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarClientesVH&id="
                                title="Consultar" alt="Consultar">Visualizar</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<!-- 
<c:import url="template-footer.jsp" />
 -->
</html>