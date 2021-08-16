package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.domain.Cliente;
import model.domain.Usuario;

public class ListaClientes implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.ListaClientes");	
		


		Banco banco = new Banco();
		List<Cliente> lista = banco.getClientes();
		request.setAttribute("clientes", lista);
		
		System.out.println("Classe: command.ListaClientes -> listaClientes.jsp ");
		return "forward:listaClientes.jsp";

	}

}
