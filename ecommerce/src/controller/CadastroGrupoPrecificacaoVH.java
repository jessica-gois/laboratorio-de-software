package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Cartao;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.GrupoPrecificacao;
import model.domain.Result;
import model.domain.enums.Bandeira;
import util.Conversao;

public class CadastroGrupoPrecificacaoVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( request.getParameter("descricao"));
		System.out.println( request.getParameter("margemLucro"));
		GrupoPrecificacao grupo = new GrupoPrecificacao(null, request.getParameter("descricao"), 
				Conversao.parseStringToDouble(request.getParameter("margemLucro")), null);

		return grupo;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.sendRedirect(request.getContextPath() + "/view/precificacao.jsp");	

	}

}
