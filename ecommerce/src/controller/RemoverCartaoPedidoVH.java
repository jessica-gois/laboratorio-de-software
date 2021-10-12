package controller;

import java.io.IOException;

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
			Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
			for(FormaPagamento formaPagamento : pedido.getFormasPagamento()) {
				if(formaPagamento.getCartao() != null && formaPagamento.getCartao().equals(cartao)) {
					formaPagamentoRemover = formaPagamento;
				}
			}
			if (formaPagamentoRemover != null) {
				pedido.getFormasPagamento().remove(formaPagamentoRemover);
			}
			request.getSession().setAttribute("pedido", pedido);
			response.sendRedirect(request.getContextPath() + "/view/finalizarPedido");
		}
	}

}