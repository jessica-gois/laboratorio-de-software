package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Livro;
import model.domain.Result;
import util.Conversao;

public class PreparaCadastroMovimentacaoVH implements IViewHelper { 
	
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Livro livro = new Livro();	
		livro.setPesquisa("");
		return livro;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<EntidadeDominio> entidades = resultado.getEntidades();
		
		if(entidades != null && !entidades.isEmpty()) {
			request.getSession().setAttribute("livros", entidades);	
		}
		//if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/view/movimentacoes.jsp");	
		//}
	}

}
