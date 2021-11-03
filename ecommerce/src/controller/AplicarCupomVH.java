package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cupom;
import model.domain.EntidadeDominio;
import model.domain.FormaPagamento;
import model.domain.Pedido;
import model.domain.Result;
import util.Conversao;

public class AplicarCupomVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cupom cupom = new Cupom();		
		cupom.setId(Conversao.parseStringToInt(request.getParameter("id")));
		cupom.setPesquisa("id");
			
		return cupom;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			Cupom cupom = (Cupom) resultado.getEntidades().get(0);
			FormaPagamento formaPagamento = new FormaPagamento(cupom);
			Pedido pedido = (Pedido) request.getSession().getAttribute("novoPedido");
			pedido.getFormasPagamento().add(formaPagamento);
			request.getSession().setAttribute("novoPedido", pedido);
			
			response.sendRedirect(request.getContextPath() + "/view/finalizarPedido");
		}
	}

}
