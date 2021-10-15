package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.Cupom;
import model.domain.EntidadeDominio;
import model.domain.Result;

public class ConsultarCuponsVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cupom cupom = new Cupom();
		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
		if (cliente != null) {
			cupom.setIdCliente(cliente.getId());
		}
		cupom.setPesquisa("validadeAtiva");
		return cupom;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// if(resultado.getResposta()==null) {
		if (resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			request.getSession().setAttribute("cupons", resultado.getEntidades());

			response.sendRedirect(request.getContextPath() + "/view/cuponsDisponiveis.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/view/listaClientes.jsp");
		}
		// }
	}

}