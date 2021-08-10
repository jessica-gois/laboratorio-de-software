package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import persistencias.Banco;

@WebServlet("/listaEmpresas")
public class ListaEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Cliente> lista = banco.getClientes();
		
		request.setAttribute("clientes", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaClientes.jsp");
		rd.forward(request, response);
		
		System.out.println("Cadastrando nova empresa");
	}

}
