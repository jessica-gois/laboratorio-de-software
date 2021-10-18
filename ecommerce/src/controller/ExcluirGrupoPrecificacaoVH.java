package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.EntidadeDominio;
import model.domain.GrupoPrecificacao;
import model.domain.Result;
import util.Conversao;

public class ExcluirGrupoPrecificacaoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		GrupoPrecificacao grupo = new GrupoPrecificacao();
        grupo.setId((Conversao.parseStringToInt((request.getParameter("id")))));
        return grupo;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/view/precificacao");			
	}

}
