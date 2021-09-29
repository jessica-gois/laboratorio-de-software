package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Result;
import util.Conversao;

public class ExcluirEnderecoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Endereco endereco = new Endereco();
		endereco.setId((Conversao.parseStringToInt((request.getParameter("id")))));
		endereco.setPesquisa(("id"));
        return endereco;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/carregarDadosCliente");		
	}

}
