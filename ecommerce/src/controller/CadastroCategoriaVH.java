package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Categoria;
import model.domain.EntidadeDominio;
import model.domain.GrupoPrecificacao;
import model.domain.Result;
import util.Conversao;

public class CadastroCategoriaVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

    Categoria categoria = new Categoria (null, request.getParameter("nome"), null);
    	
	return categoria;
}
		

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		 response.sendRedirect(request.getContextPath() + "/view/categoria");
		//response.sendRedirect(request.getContextPath() + "/carregaCategorias");
	}

}
