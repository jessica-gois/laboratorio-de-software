package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Carrinho;
import model.domain.EntidadeDominio;
import model.domain.Livro;
import model.domain.Result;
import util.Conversao;

public class ConsultarLivroVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Livro livro = new Livro();
		livro.setId(Conversao.parseStringToInt(request.getParameter("id")));
		livro.setPesquisa("id");
			
		return livro;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//if(resultado.getResposta()==null) {
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");
			Livro livro = (Livro) resultado.getEntidades().get(0);
			livro.setQtdDisponivelCompra(livro.getQtdDisponivelCompra(carrinho));			
			request.setAttribute("livro", livro);
						
			RequestDispatcher rd = request.getRequestDispatcher("/view/detalheProduto.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}else {
			// String mensagem = "A senha informada está incorreta";
			response.sendRedirect(request.getContextPath() + "/view/index");
		}
		//}
	}

}
