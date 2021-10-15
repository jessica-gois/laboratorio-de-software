<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />

<body>
    <c:import url="template-header-admin.jsp" />

    <div class="container">
        <div class="card-body">
            <div class="row">
                <div>
                    <div class="col-12 mb-3">
                        <div class="row d-flex justify-content-between">
                            <table class="table">
                                <thead class="table table-striped ">
                                    <tr>
                                        <table>
                                            <thead>
                                                <tr>
                                              

                                                    <th class="th-sm">Pedido</th>         
                                                    <th class="th-sm">Data</th>
                                                    <th class="th-sm">Email</th>
                                                    <th class="th-sm">CPF</th>
                                                    <th class="th-sm">Total</th>
                                                    <th class="th-sm">Status</th>
                                                    <th class="th-sm"></th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                                
                                                <tr>
                                                    <td><input type="text" id="pedido" name="buscaPedido"/></td>
                                                    <td><input type="text" id="pedido" name="buscaData"/></td>
                                                    <td><input type="text" id="pedido" name="buscaEmail"/></td>
                                                    <td><input type="text" id="pedido" name="buscaCPF"/></td>
                                                    <td><input type="text" id="pedido" name="buscaTotal"/></td>
                                                    <td><input type="text" id="pedido" name="buscaStatus"/></td>
                                                   <td><a class="btn btn-primary" href="#" role="button">pesquisar</a>
</td>
                                                    
       											<td>
												</td>
                                                </tr>
                                                
                                                <tr>
                                                    <td>001</td>
                                                    <td>12/10/2021</td>
                                                    <td>nome@gmail.com</td>
                                                    <td>310.650.088-96</td>
                                                    <td>120.00</td>
                                                    <td>Ativo</td>
       											<td>
       											<a class="btn btn-primary" href="#" role="button">visualizar</a>
												</td>
                                                </tr>
                                                       
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>