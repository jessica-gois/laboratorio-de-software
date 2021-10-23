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

public class ConsultarMovimentacoesVH implements IViewHelper {


	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
		if(request.getParameter("tipoPesquisa") != null && !request.getParameter("tipoPesquisa").isBlank() ) {
			movimentacao.setPesquisa(request.getParameter("tipoPesquisa"));
			if (request.getParameter("livro") != null && !request.getParameter("livro").isBlank()) {
				Livro livro = new Livro();
				livro.setTitulo(request.getParameter("livro"));
				movimentacao.setLivro(livro);
			}
			
			if(request.getParameter("tipo") != null && !request.getParameter("tipo").isBlank()) {
				movimentacao.setTipo(TipoMovimentacao.valueOf(request.getParameter("tipo")));
			}
			
			if(request.getParameter("quantidade") != null && !request.getParameter("quantidade").isBlank()) {
				movimentacao.setQuantidade(Conversao.parseStringToDouble(request.getParameter("quantidade")));
			}
			
			if(request.getParameter("fornecedor") != null && !request.getParameter("fornecedor").isBlank()) {
				movimentacao.setFornecedor(request.getParameter("fornecedor"));
			}
			
			if(request.getParameter("precoCusto") != null && !request.getParameter("precoCusto").isBlank()) {
				movimentacao.setPrecoCusto(Conversao.parseStringToDouble(request.getParameter("precoCusto")));
			}			
			
			if (request.getParameter("data") != null && !request.getParameter("data").isBlank()) {
				try {
					System.out.println(request.getParameter("data"));
					movimentacao.setData(Conversao.parseStringToDate(request.getParameter("data"), "yyyy-MM-dd"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
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