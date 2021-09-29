package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.Usuario;

public class LoginVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = new Usuario(request.getParameter("email"), request.getParameter("senha"));
		usuario.setPesquisa("email,senha");
			
		return usuario;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(resultado.getEntidades()==null || resultado.getEntidades().isEmpty()) {
			String mensagem = "Usuário ou senha inválido";
			response.sendRedirect(request.getContextPath() + "/view/login.jsp?mensagemErro=" 
			+ URLEncoder.encode(mensagem, "UTF-8" ));
		}else {	
			response.sendRedirect(request.getContextPath() + "/carregarDadosCliente?id=" + resultado.getEntidades().get(0).getId());	
		}
	}

}
