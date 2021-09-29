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
import model.domain.Result;
import util.Conversao;

public class PreparaAlteracaoEnderecoVH implements IViewHelper { 
	
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Endereco endereco = new Endereco();
		endereco.setId(Conversao.parseStringToInt(request.getParameter("id")));
		endereco.setPesquisa("id");
		return endereco;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<EntidadeDominio> entidades = resultado.getEntidades();
		
		if(entidades != null && !entidades.isEmpty()) {
			Endereco endereco = (Endereco) entidades.get(0);
			request.getSession().setAttribute("endereco", endereco);	
		}
			
		//if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/view/atualizaEndereco.jsp");	
		//}
	}

}
