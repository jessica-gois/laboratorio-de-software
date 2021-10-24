package controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Carrinho;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Livro;
import model.domain.MovimentacaoEstoque;
import model.domain.Result;
import model.domain.enums.TipoMovimentacao;
import util.Conversao;

public class ConsultarClientesVH implements IViewHelper {


	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cliente cliente = new Cliente();
		if(request.getParameter("tipoPesquisa") != null && !request.getParameter("tipoPesquisa").isBlank() ) {
			cliente.setPesquisa(request.getParameter("tipoPesquisa"));
		}
		return cliente;
	}


	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			request.getSession().setAttribute("clientes", resultado.getEntidades());
			response.sendRedirect(request.getContextPath() + "/view/consultarClientes.jsp");
		}
	}

}