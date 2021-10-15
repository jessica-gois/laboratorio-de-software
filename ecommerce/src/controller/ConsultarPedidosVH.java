package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.Cupom;
import model.domain.EntidadeDominio;
import model.domain.Pedido;
import model.domain.Result;

public class ConsultarPedidosVH implements IViewHelper {
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Pedido pedido = new Pedido();
		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
		if (cliente != null) {
			pedido.setCliente(cliente);
		}
		pedido.setPesquisa("cliente");
		return pedido;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// if(resultado.getResposta()==null) {
		if (resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			request.getSession().setAttribute("pedidos", resultado.getEntidades());

			response.sendRedirect(request.getContextPath() + "/view/meusPedidos.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/view/listaClientes.jsp");
		}
		// }
	}


}
