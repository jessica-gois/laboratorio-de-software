package controller;

import java.io.IOException;

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
import util.Conversao;

public class ConsultarMovimentacoesVH implements IViewHelper {


	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
		return movimentacao;
	}


	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			if (resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
				request.getSession().setAttribute("movimentacoes", resultado.getEntidades());
				response.sendRedirect(request.getContextPath() + "/view/consultarMovimentacoes.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/view/movimentacoes.jsp");
			}
		}
	}

}