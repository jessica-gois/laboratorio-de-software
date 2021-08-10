package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import persistencias.Banco;
import util.Conversao;


@WebServlet("/mostraCliente")
public class MostraCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conversao conv = new Conversao();
		Integer id = Conversao.parseStringToInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		Cliente cliente = banco.buscaClientePeloId(id);
		
		System.out.println(cliente.getNome());
		
		request.setAttribute("cliente", cliente);
		RequestDispatcher rd = request.getRequestDispatcher("/atualizaCliente.jsp");
		rd.forward(request, response);
	}

}
 