package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Banco;
import model.domain.Cliente;
import model.domain.Usuario;
import util.Conversao;

public class ConfirmaSenhaAtual implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Classe: command.ConfirmaSenhaAtual");
		
		String senhaInformada = request.getParameter("senha");
		String confirmacaoSenha = request.getParameter("confirmacaoSenha");
				
		Banco banco = new Banco();
		 HttpSession sessao = request.getSession();
         Usuario usuario = (Usuario)sessao.getAttribute("usuarioLogado");
		
		if(usuario != null) {
			System.out.println(usuario.getEmail());
		}
		
        if(usuario != null && usuario.autenticaSenha(senhaInformada, confirmacaoSenha)) {
        	request.setAttribute("Usuario: ", usuario.getEmail());
        	System.out.println("Senha atual validada com sucesso! Alteração de senha autorizada..");
    		System.out.println("Classe: command.ConfirmaSenhaAtual -> atualizaSenha.jsp");
    		return "forward:atualizaSenha.jsp";
        }else {
        	System.out.println("Não foi possível validar a senha atual, tente novamente.");	
    		System.out.println("Classe: command.ConfirmaSenhaAtual.java -> confirmaSenhaAtual.jsp");
    		return "forward:confirmaSenhaAtual.jsp";
        }
	
	}

}
