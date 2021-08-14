package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import util.Conversao;

public class RemoveCliente implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JSP: removeCliente");
		
		Conversao conv = new Conversao();
		
		Integer id = Conversao.parseStringToInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		banco.removeCliente(id);
		
		
		System.out.println(id);
		return "redirect:controlador?acao=ListaClientes";
	}

}
