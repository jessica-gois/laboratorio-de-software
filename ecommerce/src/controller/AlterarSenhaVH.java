package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.Usuario;

public class AlterarSenhaVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = ((Cliente)request.getSession().getAttribute("clienteLogado")).getUsuario();
		usuario.setSenha(request.getParameter("senha"));
		usuario.setPesquisa("senha,usuario");
			
		return usuario;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(resultado.getResposta()==null) {
			response.sendRedirect(request.getContextPath() + "/view/listaClientes.jsp");	
		}else {
			String mensagem = "Erro ao redefinir senha.";
			response.sendRedirect(request.getContextPath() + "/view/redefinirSenha.jsp?mensagemErro=" + URLEncoder.encode(mensagem, "UTF-8"));
		}
	}

}
