package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Pedido;
import model.domain.Result;
import util.Conversao;

public class ConsultarPedidoAdminVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Pedido pedido = new Pedido();
		
		if (request.getParameter("tipoPesquisa") != null) {
			pedido.setPesquisa(request.getParameter("tipoPesquisa"));
		}else if(request.getParameter("id") != null) {
			pedido.setId(Conversao.parseStringToInt(request.getParameter("id")));
			pedido.setPesquisa("id");
		}
		return pedido;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			Pedido pedido = (Pedido) resultado.getEntidades().get(0);
			request.getSession().setAttribute("pedidoAdmin", pedido);
			
			response.sendRedirect(request.getContextPath() + "/view/detalharPedido.jsp");		
		}else {
			response.sendRedirect(request.getContextPath() + "/view/index");
		}
	}

}
