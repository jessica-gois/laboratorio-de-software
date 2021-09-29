package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.Usuario;
import util.Conversao;

public class InativarUsuarioVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = ((Cliente) request.getSession().getAttribute("clienteLogado")).getUsuario();
        return usuario;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();;
		response.sendRedirect(request.getContextPath() + "/view/index.jsp");		
	}

}
