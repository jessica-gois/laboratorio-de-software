package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			request.setAttribute("livro", resultado.getEntidades().get(0));
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
