package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cupom;
import model.domain.EntidadeDominio;
import model.domain.Result;
import util.Conversao;

public class ExcluirCupomVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cupom cupom = new Cupom();
        cupom.setId((Conversao.parseStringToInt((request.getParameter("id")))));
        return cupom;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/view/consultarCupom");			
	}

}
