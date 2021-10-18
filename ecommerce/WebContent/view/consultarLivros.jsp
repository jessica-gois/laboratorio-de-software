<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />

<body>
    <c:import url="template-header-admin.jsp" />
    <div class="container">
        <p class="h4 mb-3 mt-5">Consultar livros</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <form id="formConsultaCliente" action="" method="post" novalidate>
                    <div class="row pt-2 mb-2 d-flex align-items-center">

                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-2">
                                    <p class="h5">Código</p>
                                </div>
                                <div class="col-5">
                                    <p class="h5">Título</p>
                                </div>
                                <div class="col-5">
                                    <p class="h5">Editora</p>
                                </div>
                            </div>
                            <div class="row d-flex align-items-center">
                                <div class="col-2">
                                    <input class="form-control mt-2" type="text" id="codigo" name="codigo"
                                        required="true" />
                                </div>
                                <div class="col-5">
                                    <input class="form-control mt-2" type="text" id="titulo" name="titulo"
                                        required="true" />
                                </div>
                                <div class="col-5">
                                    <input class="form-control mt-2" type="text" id="editora" name="editora"
                                        required="true" />
                                </div>
                            </div>
                        </div>

                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-4">
                                    <p class="h5">Autor</p>
                                </div>
                                <div class="col-2">
                                    <p class="h5">Ano</p>
                                </div>
                                <div class="col-4">
                                    <p class="h5">Edição</p>
                                </div>
                                <div class="col-2">
                                    <p class="h5">Nº de páginas</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <input class="form-control mt-2" type="text" id="autor" name="autor"
                                        required="true" />
                                </div>
                                <div class="col-2">
                                    <input class="form-control mt-2" type="text" id="ano" name="ano" required="true" />
                                </div>
                                <div class="col-4">
                                    <input class="form-control mt-2" type="text" id="edicao" name="edicao"
                                        required="true" />
                                </div>
                                <div class="col-2">
                                    <input class="form-control mt-2" type="text" id="pagina" name="pagina"
                                        required="true" />
                                </div>
                            </div>
                        </div>

                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-5">
                                    <p class="h5">ISBN</p>
                                </div>
                                <div class="col-5">
                                    <p class="h5">Código de barras</p>
                                </div>
                                <div class="col-2">
                                    <p class="h5">Preço</p>
                                </div>
                            </div>
                            <div class="row d-flex align-items-center">
                                <div class="col-5">
                                    <input class="form-control mt-2" type="text" id="isbn" name="isbn"
                                        required="true" />
                                </div>
                                <div class="col-5">
                                    <input class="form-control mt-2" type="text" id="codBarras" name="codBarras"
                                        required="true" />
                                </div>
                                <div class="col-2">
                                    <input class="form-control mt-2" type="text" id="preco" name="preco"
                                        required="true" />
                                </div>
                            </div>
                        </div>

                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-5">
                                    <p class="h5">Categoria</p>
                                </div>
                                <div class="col-5">
                                    <p class="h5">Grupo precificação</p>
                                </div>
                                <div class="col-2">
                                    <p class="h5">Status</p>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-5">
                                    <select class="form-control" name="categoria" id="categoria" required="true">
                                        <option value="">Escolha...</option>
                                        <option value="Infantil">Infantil</option>
                                        <option value="Juvenil">Juvenil</option>
                                    </select>
                                </div>
                                <div class="col-5">
                                    <select class="form-control" name="precificacao" id="precificacao" required="true">
                                        <option value="">Escolha...</option>
                                        <option value="MaisVendidos">Mais vendidos</option>
                                        <option value="BaixaProcura">Baixa procura</option>
                                    </select>
                                </div>
                                <div class="col-2">
                                    <select class="form-control" name="status" id="status" required="true">
                                        <option value="">Escolha...</option>
                                        <option value="Ativo">Ativo</option>
                                        <option value="Inativo">Inativo</option>
                                    </select>
                                </div>


                            </div>
                        </div>

                        <div class="row mt-4">
                            <div class="col-2">
                                <a class="btn btn-blue w-100" id="buscar" name="buscar" href="#" title="Buscar"
                                    alt="Botão de busca">Buscar</a>
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
                        <p class="h5">Código</p>
                    </div>
                    <div class="col-2">
                        <p class="h5">Título</p>
                    </div>
                    <div class="col-2">
                        <p class="h5">Editora</p>
                    </div>
                    <div class="col-1">
                        <p class="h5">Preço</p>
                    </div>
                    <div class="col-1">
                        <p class="h5">Score</p>
                    </div>
                    <div class="col-2">
                        <p class="h5">Categoria</p>
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
                            <p>8754
                                <p />
                        </div>
                        <div class="col-2">
                            <p>Amoras
                                <p />
                        </div>
                        <div class="col-2">
                            <p>FTD
                                <p />
                        </div>
                        <div class="col-1">
                            <p>29,90
                                <p />
                        </div>
                        <div class="col-1">
                            <p>900
                                <p />
                        </div>
                        <div class="col-2">
                            <p>Infantil
                                <p />
                        </div>
                        <div class="col-1">
                            <p>Ativo
                                <p />
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
        <div class="col-2 mb-5">
            <a class="btn btn-secondary w-100" href="" title="Voltar">Voltar</a>
        </div>
    </div>
</body>
<!-- 
<c:import url="template-footer.jsp" />
 -->

</html>