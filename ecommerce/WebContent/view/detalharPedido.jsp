<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List,model.domain.Cliente, model.domain.Carrinho,
	model.domain.Cupom,model.domain.Endereco,model.domain.Cartao,model.domain.FormaPagamento,model.domain.PedidoItem,model.domain.enums.StatusPedido, model.domain.Endereco,model.domain.Pedido" %>

<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<c:url value="/controlador" var="stub" />
<fmt:setLocale value="pt_BR" />
<%
	Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
%>

<body>
    <c:import url="template-header-admin.jsp" />
    <div class="container">
        <p class="h4 mb-3 mt-5">Detalhar pedido</p>
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <div class="row">
                    <div class="col-3">
                        <h5>Pedido: <%=pedido.getId() %></h5>
                    </div>
                    <div class="col-3">
                        <h5>Status: <%=pedido.getStatus() %></h5>
                    </div>
                </div>
                <!-- Começo do bloco resumo -->
                <hr class="my-4">
                <div class="row mt-2">
                    <div class="row mb-3">
                        <h4>Resumo</h4>
                    </div>
                    <div class="col-3">
                        <p class="h5">Valor total dos itens</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Frete</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Valor total descontos (cupons)</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Total</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <fmt:formatNumber value="<%=pedido.getValorTotalItens()%>" type="currency" />
                    </div>
                    <div class="col-3">
                        <fmt:formatNumber value="<%=pedido.getValorFrete() %>" type="currency" />
                    </div>
                    <div class="col-3">
                        <fmt:formatNumber value="<%=pedido.getValorTotalDescontos() %>" type="currency" />
                    </div>
                    <div class="col-3">
                        <fmt:formatNumber value="<%=pedido.getValorTotal()%>" type="currency" />
                    </div>
                </div>
            </div>
            <!-- Fim do bloco resumo -->

            <!-- Começo do bloco cliente -->
            <div class="card-body">
                <div class="row">
                    <h4>Cliente</h4>
                    <div class="col-3">
                        <p class="h5">Id cliente</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">E-mail</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Status</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Score</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <p><%=pedido.getCliente().getId() %></p>
                    </div>
                    <div class="col-3">
                        <p><%=pedido.getCliente().getUsuario().getEmail() %></p>
                    </div>
                    <div class="col-3">
                        <p><%=pedido.getStatus() != null ? pedido.getStatus().descricao : "" %></p>
                    </div>
                    <div class="col-3">
                        <p><%=pedido.getCliente().getScore()!= null ? pedido.getCliente().getScore() : "" %></p>
                    </div>
                </div>
            </div>
            <!-- Fim do bloco cliente-->

            <!-- Começo do bloco endereço entrega-->
            <div class="card-body">
                <div class="row">
                    <h4>Endereço entrega</h4>
                    <div class="col-3">
                        <p class="h5">Logradouro</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Número</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Cidade</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <p><%=pedido.getEnderecoEntrega().getLogradouro() %></p>
                    </div>
                    <div class="col-3">
                        <p><%=pedido.getEnderecoEntrega().getNumero() %></p>
                    </div>
                    <div class="col-3">
                        <p><%=pedido.getEnderecoEntrega().getCidade().getNome() %></p>
                    </div>
                </div>
            </div>
            <!-- Fim do bloco endereço entrega -->

            <!-- Começo do bloco endereço cobrança-->
            <div class="card-body">
                <div class="row">
                    <h4>Endereço cobrança</h4>
                    <div class="col-3">
                        <p class="h5">Logradouro</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Número</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Cidade</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <p><%=pedido.getEnderecoCobranca().getLogradouro() %></p>
                    </div>
                    <div class="col-3">
                        <p><%=pedido.getEnderecoCobranca().getNumero() %></p>
                    </div>
                    <div class="col-3">
                        <p><%=pedido.getEnderecoCobranca().getCidade().getNome() %></p>
                    </div>
                </div>
            </div>
            <!-- Fim do bloco endereço cobrança -->

            <!-- Começo do bloco pagamento-->
            <div class="card-body">
                <div class="row">
                    <h4>Pagamento</h4>
                    <div class="col-3">
                        <p class="h5">Bandeira</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Número</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Nome Cartão</p>
                    </div>
                </div>
                <div class="row">
                    <%if(pedido.getFormasPagamento() != null){
						for (FormaPagamento formaPagamento : pedido.getFormasPagamento()) {
							if(formaPagamento.getCartao() != null && formaPagamento.getCartao().getId() > 0){%>
                    <div class="col-3">
                        <p><%=formaPagamento.getCartao().getBandeira() %></p>
                    </div>
                    <div class="col-3">
                        <p><%=formaPagamento.getCartao().getNumero()%></p>
                    </div>
                    <div class="col-3">
                        <p><%=formaPagamento.getCartao().getNomeImpresso() %></p>
                    </div>
                </div>
            </div>
            <%}
						}
					}%>
            <!-- Fim do bloco pagamento -->

            <!-- Começo do bloco cupom-->
            <div class="card-body">
                <div class="row">
                    <h4>Cupons</h4>
                    <div class="col-3">
                        <p class="h5">Tipo</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Código</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Valor</p>
                    </div>
                </div>
                <div class="row">
                    <%if(pedido.getFormasPagamento() != null){
						for ( FormaPagamento formaPagamento : pedido.getFormasPagamento()) {
							if(formaPagamento.getCupom() != null && formaPagamento.getCupom().getId() > 0){%>
                    <div class="col-3">
                        <p><%=formaPagamento.getCupom().getTipo() != null ? formaPagamento.getCupom().getTipo().getDescricao() : ""%>
                        </p>
                    </div>
                    <div class="col-3">
                        <p><%=formaPagamento.getCupom().getCodigo()%></p>
                    </div>
                    <div class="col-3">
                        <p>
                            <fmt:formatNumber value="<%=formaPagamento.getCupom().getValor()%>" type="currency" />
                        </p>
                    </div>
                </div>
                <%}
						}
					}%>
            </div>
            <!-- Fim do bloco cupom -->

            <!-- Começo do bloco itens compra-->
            <div class="card-body">
                <div class="row">
                    <h4>Itens do pedido</h4>
                    <div class="col-3">
                        <p class="h5">Código</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Título</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Quantidade</p>
                    </div>
                    <div class="col-3">
                        <p class="h5">Valor</p>
                    </div>
                </div>
                <div class="row">
                    <%if(pedido.getItens() != null){
						for ( PedidoItem item : pedido.getItens()) {%>
                    <div class="col-3">
                        <p><%=item.getLivro().getId() %></p>
                    </div>
                    <div class="col-3">
                        <p><%=item.getLivro() != null ? item.getLivro().getTitulo() : "" %></p>
                    </div>
                    <div class="col-3">
                        <p><%=item.getQuantidade() %></p>
                    </div>
                    <div class="col-3">
                        <p>R$ 29,90</p>
                    </div>
                </div>
                <% }
					}
					%>
            </div>
            <!-- Fim do bloco itens compra -->
        </div>




        <!-- Início do bloco gerenciamento do pedido -->
        <div class="card shadow mb-5 pb-4">
            <div class="card-body">
                <h4>
                    Gerenciamento do pedido
                </h4>
                <div class="row mt-4">
                    <div class="col">

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault1">
                                Em processamento </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status" checked>
                            <label class="form-check-label" for="flexRadioDefault2">
                                Pagamento aprovado </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault3">
                                Pagamento reprovado </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault4">
                                Enviado para transportadora </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault5">
                                Em transporte </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault6">
                                Entregue </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault7">
                                Troca solicitada </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault8">
                                Troca autorizada </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault9">
                                Troca reprovada </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault10">
                                Item enviado para troca/cancelamento </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault11">
                                Item recebido para troca/cancelamento </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault12">
                                Troca realizada </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="status">
                            <label class="form-check-label" for="flexRadioDefault13">
                                Finalizado</label>
                        </div>
                    </div>
                </div>

                <div class="col-2 mt-5">
                    <a class="btn btn-blue w-100" id="salvar" name="salvar"
                        href="/ecommerce/controlador?acao=salvar&viewHelper=ConsultarPedidoVH&id=" title="Salvar"
                        alt="Salvar">Salvar</a>
                </div>
            </div>
        </div>

        <!-- Fim do bloco gerenciamento do pedido -->
        <div class="col-2 mb-5">
            <a class="btn btn-secondary w-100" href="" title="Voltar">Voltar</a>
        </div>
    </div>
</body>
</html>