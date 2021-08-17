package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.domain.Cliente;
import util.Conversao;

public class MostraSenha implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.MostraSenha");	
		
		Conversao conv = new Conversao();
		Integer id = Conversao.parseStringToInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		Cliente cliente = banco.buscaClientePeloId(id);
		
		System.out.println(cliente.getNome());
		
		request.setAttribute("cliente", cliente);
		System.out.println("Classe: command.MostraCliente -> atualizaCliente.jsp");
		return "forward:atualizaSenha.jsp";
	}

}
