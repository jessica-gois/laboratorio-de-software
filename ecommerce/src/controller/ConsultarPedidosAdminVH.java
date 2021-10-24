package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Pedido;
import model.domain.Result;
import model.domain.Usuario;

public class ConsultarPedidosAdminVH implements IViewHelper {
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {		
		
		Usuario usuario = new Usuario();
		Cliente cliente = new Cliente();
		Pedido pedido = new Pedido();
		return pedido;
	}
	

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			request.getSession().setAttribute("pedidos", resultado.getEntidades());
			response.sendRedirect(request.getContextPath() + "/view/consultarPedidos.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/view/consultarPedidos.jsp");
		}
	}
}
