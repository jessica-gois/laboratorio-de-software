package command;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.domain.Cliente;
import util.Conversao;

public class RedefinirSenhaClienteFormulario implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.RedefinirSenhaClienteFormulario");
		System.out.println("Classe: command.RedefinirSenhaClienteFormulario -> redefinirSenhaCliente.jsp");	
		return "forward:redefinirSenhaCliente.jsp";
	}

}
