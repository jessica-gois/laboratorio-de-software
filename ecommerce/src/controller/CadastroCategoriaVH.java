package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Categoria;
import model.domain.EntidadeDominio;
import model.domain.Result;

public class CadastroCategoriaVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

    Categoria categoria = new Categoria (request.getParameter("nome"));
		
	return categoria;
}
		

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/view/categoria.jsp");	
	}

}
