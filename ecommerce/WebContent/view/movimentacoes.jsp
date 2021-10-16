<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />

<body>
    <c:import url="template-header-admin.jsp" />
    <div class="container">
        <p class="h4 mb-3 mt-5">Movimentação no estoque</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <form id="formCadastroMovimentacao" action="" method="post" novalidate>
                    <div class="row pt-2 mb-2 d-flex align-items-center">
                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-4">
                                    <p class="h5">Data</p>
                                </div>
                                <div class="col-4">
                                    <p class="h5">Tipo de movimentação</p>
                                </div>
                                <div class="col-4">
                                    <p class="h5">Livro</p>
                                </div>
                            </div>


                            <div class="row d-flex align-items-center">
                                <div class="col-4">
                                    <input class="form-control mt-2" type="text" id="data" name="data"
                                        required="true" />
                                </div>
                                <div class="col-4 mt-2">
                                    <select class="form-control" name="tipoMovimentacao" id="tipoMovimentacao" required="true">
										<option value="">Escolha...</option>	
									</select>
                                </div>
                                <div class="col-4 mt-2	">
									 <select class="form-control" name="livro" id="livro" required="true">
										<option value="">Escolha...</option>	
									</select>
                                </div>
                            </div>
                        </div>


                        <div class="row mt-4">
                            <div class="row">
                                <div class="col-4">
                                    <p class="h5">Quantidade</p>
                                </div>
                                <div class="col-4">
                                    <p class="h5">Fornecedor</p>
                                </div>
                                <div class="col-4">
                                    <p class="h5">Preço de compra</p>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-4">
                                    <input class="form-control mt-2" type="number" id="qtdMovimentada"
                                        name="qtdMovimentada" required="true" />
                                </div>
                                <div class="col-4">
                                    <input class="form-control mt-2" type="text" id="fornecedor" name="fornecedor"
                                        required="true" />
                                </div>
                                <div class="col-4">
                                    <input class="form-control mt-2" type="text" id="precoCusto" name="precoCusto"
                                        required="true" />
                                </div>
                            </div>
                        </div>


                        <div class="row mt-4">
                            <div class="col-2">
                                <a class="btn btn-blue w-100" id="salvar" name="salvar"
                                    href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarPedidoVH&id="
                                    title="Salvar" alt="Salvar">Salvar</a>
                            </div>
                        </div>

                    </div>
                </form>
            </div>
        </div>


        <div class="row">
            <div class="col-2">
                <a class="btn btn-blue w-100" id="consultar" name="consultar"
                    href="/ecommerce/controlador?acao=consultar&viewHelper=ConsultarMovimentacoesVH&id="
                    title="Consultar" alt="Consultar">Consultar</a>
            </div>
            <div class="col-2">
                <a class="btn btn-secondary w-100" href="" title="Voltar">Voltar</a>
            </div>
        </div>
	</div>
</body>
<c:import url="template-footer.jsp" />

</html>