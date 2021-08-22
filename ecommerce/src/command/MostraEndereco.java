package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.domain.Cliente;
import util.Conversao;

public class MostraEndereco implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.MostraEndereco");	
		
		System.out.println("Classe: command.MostraEndereco -> atualizaEndereco.jsp");
		return "forward:atualizaEndereco.jsp";
	}

}
