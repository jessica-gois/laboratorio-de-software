<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />

<body>
    <c:import url="template-header-admin.jsp" />
    <div class="container">
        <p class="h4 mb-3 mt-5">Histórico de pedidos</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <div class="row">
                    <div class="col-8">
                        <p><strong>Maria dos Santos</strong> </p>
                    </div>
                    <div class="col-2">
                        <p><strong>2421</strong></p>
                    </div>
                </div>
                <hr class="my-4">
                <div class="row mt-4">
                    <div class="col">
                        <p class="h5">Número do pedido</p>
                    </div>
                    <div class="col">
                        <p class="h5">Valor</p>
                    </div>
                    <div class="col">
                        <p class="h5">Livro</p>
                    </div>
                    <div class="col">
                        <p class="h5">Status</p>
                    </div>
                    <div class="col">
                        <p class="h5">Data</p>
                    </div>
                    <div class="col-2">
                        <p class="h5" style="color: #FFF;"></p>
                    </div>
                </div>


                <hr class="my-4">
                <div class="row mb-4">
                    <div class="col">
                        <p>198723</p>
                    </div>
                    <div class="col">
                        <p>R$ 256,89</p>
                        </select>
                    </div>
                    <div class="col">
                        <p>Amoras</p>
                    </div>
                    <div class="col">
                        <p>Entregue</p>
                    </div>
                    <div class="col">
                        <p>10/10/2021</p>
                    </div>
                    <div class="col-2">
                        <a class="btn btn-blue w-100 pb-2" href="#" role="button">Visualizar</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-2">
            <a class="btn btn-secondary w-100" href="" title="Voltar">Voltar</a>
        </div>
    </div>
</body>
<c:import url="template-footer.jsp" />

</html>