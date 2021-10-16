<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />

<body>
    <c:import url="template-header-admin.jsp" />

    <div class="container mt-5">
        <h3>Consultar pedidos</h3>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body d-flex justify-content-center">
                <div class="row">
                    <div>
                        <div class="col-12 mb-5">
                            <div class="row d-flex justify-content-between">
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
                                                <div class="row mb-3">

                                                    <tr>
                                                        <td><input type="text" id="pedido" name="buscaPedido" /></td>
                                                        <td><input type="text" id="pedido" name="buscaData" /></td>
                                                        <td><input type="text" id="pedido" name="buscaEmail" /></td>
                                                        <td><input type="text" id="pedido" name="buscaCPF" /></td>
                                                        <td><input type="text" id="pedido" name="buscaTotal" /></td>

                                                        <td>
                                                            <select class="form-control pb-2 ps-4"" name=" status"
                                                                id="status" required="true">
                                                                <option value="">Escolha...</option>
                                                                <option value="ENTREGUE">Entregue</option>
                                                                <option value="TROCADO">Trocado</option>
                                                            </select>
                                                        </td>

                                                        <td><a class="btn btn-blue w-100 pb-2" href="#"
                                                                role="button">pesquisar</a></td>
                                                    </tr>


                                                    <tr>
                                                        <td>001</td>
                                                        <td>12/10/2021</td>
                                                        <td>nome@gmail.com</td>
                                                        <td>310.650.088-96</td>
                                                        <td>120.00</td>
                                                        <td>Entregue</td>
                                                        <td><a class="btn btn-green w-100 pb-2" href="#"
                                                                role="button">detalhar</a></td>
                                                    </tr>

                                                    <tr>
                                                        <td>002</td>
                                                        <td>15/10/2021</td>
                                                        <td>alguem@gmail.com</td>
                                                        <td>310.650.088-96</td>
                                                        <td>150.00</td>
                                                        <td>Troca</td>
                                                        <td><a class="btn btn-green w-100 pb-2" href="#"
                                                                role="button">detalhar</a></td>
                                                    </tr>
                                                </div>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                     </div>
                </div>
                <div class="row mt-4">
                    <div class="col-3">
                        <a class="btn btn-secondary w-100" href="#" role="button">voltar</a>
               </div>
        </div>
    </div>
    <c:import url="template-footer.jsp" />
    </body>
</html>