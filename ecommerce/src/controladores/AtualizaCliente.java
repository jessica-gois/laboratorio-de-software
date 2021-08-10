package controladores;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import persistencias.Banco;
import util.Conversao;

@WebServlet("/atualizaCliente")
public class AtualizaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Conversao conv = new Conversao();

		Integer id = Conversao.parseStringToInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String dataNascimento = request.getParameter("dataNascimento");
		String cpf = request.getParameter("cpf");
		String score = request.getParameter("score");
		String ativo = request.getParameter("status");

		
		
		Banco banco = new Banco();
		Cliente cliente = banco.buscaClientePeloId(id);
		
		cliente.setNome(nome);
		try {
			cliente.setDataNascimento(Conversao.parseStringToDate(request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		cliente.setCpf(cpf);
		cliente.setScore(Conversao.parseStringToInt(request.getParameter("score")));
		cliente.setStatus(Conversao.parseStringToBoolean(request.getParameter("status")));

		response.sendRedirect("listaClientes");
		
		System.out.println("Atualizando empresa");
		System.out.println(id);

	}

}
