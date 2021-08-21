package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.domain.Cliente;
import util.Conversao;

public class InativarContaFormulario implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.InativarContaFormulario");	
		
		System.out.println("Classe: command.InativarContaFormulario -> inativarConta.jsp");
		return "forward:inativarConta.jsp";
	}

}
