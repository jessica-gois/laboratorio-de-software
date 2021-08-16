package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Banco;
import model.domain.Usuario;

public class CadastraLogin implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Classe: command.CadastraLogin");	
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Banco banco = new Banco();
		Usuario  usuario = banco.validaCredenciais(email,senha);
		
		request.setAttribute("usuario", usuario.getEmail());
		
		System.out.println("Classe: command.CadastraLogin -> command.CadastraClienteFormulario");
		return "redirect:controlador?acao=CadastraClienteFormulario";
	
	}

}
