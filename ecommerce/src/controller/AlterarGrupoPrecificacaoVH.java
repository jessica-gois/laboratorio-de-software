package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.GrupoPrecificacao;
import model.domain.Result;
import model.domain.Usuario;
import util.Conversao;

public class AlterarGrupoPrecificacaoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		GrupoPrecificacao grupo = new GrupoPrecificacao(Conversao.parseStringToInt(request.getParameter("id")),
			request.getParameter("descricaoAtualizar"), Conversao.parseStringToDouble(request.getParameter("margemLucroAtualizar")), null);			
		
		return grupo;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/view/precificacao");	
	}
}
