package controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cupom;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.enums.TipoCupom;
import util.Conversao;

public class CadastroCupomVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

	Cupom cupom = null;
		try {
		cupom = new Cupom (request.getParameter("codigo"),request.getParameter("nome"),
				Conversao.parseStringToDouble(request.getParameter("valor")), Conversao.parseStringToDate(request.getParameter("validade"),"yyyy-MM-dd"), TipoCupom.valueOf(request.getParameter("tipo"))
				);
	} catch (ParseException e) {
		e.printStackTrace();
	}
		
		return cupom;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/view/consultarCupom.jsp");	
	}

}
