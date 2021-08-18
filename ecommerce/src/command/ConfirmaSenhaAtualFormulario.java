package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmaSenhaAtualFormulario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Classe: command.ConfirmaSenhaAtualFormulario");	
		System.out.println("Classe: command.ConfirmaSenhaAtualFormulario.java -> confirmaSenhaAtual.jsp");
		return "forward:confirmaSenhaAtual.jsp";
	}

}
