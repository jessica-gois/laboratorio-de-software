package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Categoria;
import model.domain.EntidadeDominio;
import model.domain.GrupoPrecificacao;
import model.domain.Livro;
import model.domain.Result;
import util.Conversao;

public class CadastroLivroVH implements IViewHelper { 
	
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		
		Livro livro = (Livro) request.getSession().getAttribute("livro");
		GrupoPrecificacao grupoPrecificacao = new GrupoPrecificacao();
		Categoria categoria = new Categoria();
		
		
		livro.setGrupoPrecificacao(grupoPrecificacao);
		livro.setCategorias(null);

		

		
		return livro;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/view/sucesso.jsp");	

	}

}
