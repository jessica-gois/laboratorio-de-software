package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cartao;
import model.domain.EntidadeDominio;
import model.domain.Result;
import util.Conversao;

public class ExcluirCartaoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cartao cartao = new Cartao();
        cartao.setId((Conversao.parseStringToInt((request.getParameter("id")))));
        cartao.setPesquisa(("id"));
        return cartao;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/carregarDadosCliente");		
	}

}
