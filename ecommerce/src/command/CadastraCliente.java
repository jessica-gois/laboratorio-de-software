package command;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.domain.Cliente;
import util.Conversao;

public class CadastraCliente {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JSP: cadastraCliente");
		
		Conversao conv = new Conversao();
		
		String nome = request.getParameter("nome");
		String dataNascimento = request.getParameter("dataNascimento");
		String cpf = request.getParameter("cpf");
		String score = request.getParameter("score");
		String ativo = request.getParameter("status");

		Cliente cliente= new Cliente();
		cliente.setNome(nome);
		try {
			cliente.setDataNascimento(Conversao.parseStringToDate(request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		cliente.setCpf(cpf);	
		cliente.setScore(Conversao.parseStringToInt(request.getParameter("score")));
		cliente.setStatus(Conversao.parseStringToBoolean(request.getParameter("status")));

		
		Banco banco = new Banco();
		banco.adiciona(cliente);
		
		request.setAttribute("cliente", cliente.getNome());
		
		response.sendRedirect("controlador?acao=ListaClientes");
	}

}
