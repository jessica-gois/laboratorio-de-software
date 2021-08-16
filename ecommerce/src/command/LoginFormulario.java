package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormulario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Classe: command.LoginFormulario");	
		System.out.println("Classe: command.LoginFormulario -> login.jsp");
		return "forward:login.jsp";
	}

}
