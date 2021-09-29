package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.Usuario;

public class ConsultarSenhaVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = new Usuario();
		usuario.setId(((Cliente)request.getSession().getAttribute("clienteLogado")).getUsuario().getId());
		usuario.setSenha(request.getParameter("senha"));
		usuario.setPesquisa("senha,usuario");
			
		return usuario;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//if(resultado.getResposta()==null) {
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/view/redefinirSenhaCliente.jsp");	
		}else {
			String mensagem = "A senha informada está incorreta";
			response.sendRedirect(request.getContextPath() + "/view/confirmaSenhaAtual.jsp?mensagemErro=" + URLEncoder.encode(mensagem, "UTF-8" ));
		}
		//}
	}

}
