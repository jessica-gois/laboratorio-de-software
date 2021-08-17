package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

import dao.Banco;
import model.domain.Cliente;
import util.Conversao;

public class AtualizaCliente implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.AtualizaCliente");		
		
		Conversao conv = new Conversao();

		Integer id = Conversao.parseStringToInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String dataNascimento = request.getParameter("dataNascimento");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
//		String score = request.getParameter("score");
//		String ativo = request.getParameter("status");

		
		Banco banco = new Banco();
		Cliente cliente = banco.buscaClientePeloId(id);
		
		cliente.setNome(nome);
		cliente.setSobrenome(sobrenome);
		try {
			cliente.setDataNascimento(Conversao.parseStringToDate(request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		
//		cliente.setScore(Conversao.parseStringToInt(request.getParameter("score")));
//		cliente.setStatus(Conversao.parseStringToBoolean(request.getParameter("status")));
		
		System.out.println("Classe: command.AtualizaCliente -> command.ListaClientes");	
		return "redirect:controlador?acao=ListaClientes";
		
		
	}

}
