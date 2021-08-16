package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Banco;
import model.domain.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Classe: command.Login");	
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Banco banco = new Banco();
		Usuario  usuario = banco.validaCredenciais(email,senha);
	
		
		
        if(usuario != null) {
           System.out.println("Usuario existe no sistema");
           HttpSession sessao = request.getSession();
           sessao.setAttribute("usuarioLogado", usuario);
           System.out.println("Classe: command.Login -> command.ListaClientes ");
           return "redirect:controlador?acao=ListaClientes";
        }else {
        	System.out.println("Classe: command.Login -> command.LoginFormulario ");
        	return "redirect:controlador?acao=LoginFormulario";
        }
	
	}

}
