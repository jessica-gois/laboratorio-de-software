package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.CarrinhoItem;
import model.domain.EntidadeDominio;
import model.domain.Livro;
import model.domain.Result;
import util.Conversao;

public class AdicionarCarrinhoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Livro livro = new Livro();		
		livro.setId(Conversao.parseStringToInt(request.getParameter("id")));
		livro.setPesquisa("id");	
		return livro;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			Double quantidade = Conversao.parseStringToDouble(request.getParameter("quantidade"));
			Livro livro = (Livro) resultado.getEntidades().get(0);
			CarrinhoItem item = new CarrinhoItem(livro, quantidade);			
			
			request.setAttribute("itemCarrinho", item);
			request.setAttribute("acao", "adicionarItem");			
			
			RequestDispatcher rd = request.getRequestDispatcher("/carrinho");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
