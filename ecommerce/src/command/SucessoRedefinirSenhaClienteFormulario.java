package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SucessoRedefinirSenhaClienteFormulario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Classe: command.SucessoRedefinirSenhaClienteFormulario");	
		System.out.println("Classe: command.SucessoRedefinirSenhaClienteFormulario.java -> sucessoRedefinirSenha.jsp");
		return "forward:sucessoRedefinirSenha.jsp";
	}

}
