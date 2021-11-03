package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cartao;
import model.domain.EntidadeDominio;
import model.domain.FormaPagamento;
import model.domain.Pedido;
import model.domain.Result;
import util.Conversao;

public class RemoverCartaoPedidoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cartao cartao = new Cartao();		
		cartao.setId(Conversao.parseStringToInt(request.getParameter("id")));
		cartao.setPesquisa("id");
			
		return cartao;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			Cartao cartao = (Cartao) resultado.getEntidades().get(0);
			FormaPagamento formaPagamentoRemover = null;
			Pedido pedido = (Pedido) request.getSession().getAttribute("novoPedido");
			
			for(FormaPagamento formaPagamento : pedido.getFormasPagamento()) {
				if(formaPagamento.getCartao() != null && formaPagamento.getCartao().equals(cartao)) {
					formaPagamentoRemover = formaPagamento;
				}
			}
			if (formaPagamentoRemover != null && (pedido.getValorTotal() == 0 || pedido.getFormasPagamento().size() > 1)) {
				pedido.getFormasPagamento().remove(formaPagamentoRemover);
			}else {
				request.setAttribute("erroCartao", "Não foi possível remover o cartão.\n"
				+ " É necessário no mínimo 1 forma de pagamento no pedido.");
			}
			request.getSession().setAttribute("novoPedido", pedido);
			RequestDispatcher rd = request.getRequestDispatcher("/view/finalizarPedido");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
