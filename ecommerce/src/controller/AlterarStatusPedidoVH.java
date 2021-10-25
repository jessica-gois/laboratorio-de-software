package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.EntidadeDominio;
import model.domain.Pedido;
import model.domain.Result;
import model.domain.enums.StatusPedido;

public class AlterarStatusPedidoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		
		if (request.getParameter("status") != null && !request.getParameter("status").isBlank()) {
			pedido.setStatus(StatusPedido.valueOf(request.getParameter("status")));
		}
		
		return pedido;
	}
	

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String caminhoRedirecionar = "/view/detalharPedido.jsp";
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		response.sendRedirect("/ecommerce/controlador?acao=consultar&viewHelper=ConsultarPedidoVH&caminhoRedirecionar=" + 
		caminhoRedirecionar + "&id=" + pedido.getId());	
	}
}
