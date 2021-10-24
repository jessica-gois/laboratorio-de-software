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

public class ConsultarPedidoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
		Pedido pedido = new Pedido();
		
		if(cliente != null) {
		pedido.setCliente(cliente);
		}
		
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
		//if(resultado.getResposta()==null) {
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			Pedido pedido = (Pedido) resultado.getEntidades().get(0);
			String caminhoRedirecionar = request.getParameter("caminhoRedirecionar") != null ?
				request.getParameter("caminhoRedirecionar") : "/view/detalhePedido.jsp";
			request.getSession().setAttribute("pedido", pedido);
			
			response.sendRedirect(request.getContextPath() + caminhoRedirecionar);		
		}else {
			response.sendRedirect(request.getContextPath() + "/view/index");
		}
		//}
	}

}
