package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.domain.Cliente;

public class ListaClientes {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JSP: listaClientes");
		
		Banco banco = new Banco();
		List<Cliente> lista = banco.getClientes();

		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/listaClientes.jsp");
		rd.forward(request, response);
	}

}
