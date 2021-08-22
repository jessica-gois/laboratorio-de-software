package command;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.domain.Cliente;
import util.Conversao;

public class CadastraCliente implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.CadastraCliente");	
		
		Conversao conv = new Conversao();
		Cliente cliente= new Cliente();

		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String genero = request.getParameter("genero");	
		String dddResidencial = request.getParameter("dddResidencial");
		String numeroTelResidencial = request.getParameter("numeroTelResidencial");	
		String dddCelular = request.getParameter("dddCelular");
		String numeroTelCelular = request.getParameter("numeroTelCelular");
		String dataNascimento = request.getParameter("dataNascimento");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String score = request.getParameter("score");
		String status = request.getParameter("status");



		cliente.setNome(nome);
		cliente.setSobrenome(sobrenome);
		cliente.setGenero(genero);
		cliente.setDddResidencial(dddResidencial);
		cliente.setNumeroTelResidencial(numeroTelResidencial);
		cliente.setDddCelular(dddCelular);
		cliente.setNumeroTelCelular(numeroTelCelular);
		try {
			cliente.setDataNascimento(Conversao.parseStringToDate(request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		cliente.setCpf(cpf);	
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setScore(Conversao.parseStringToInt(score));
		cliente.setStatus(Conversao.parseStringToBoolean(status));
		

		
		Banco banco = new Banco();
		banco.adiciona(cliente);
		
		request.setAttribute("cliente", cliente.getNome());
		
		System.out.println("Classe: command.CadastraCliente -> command.ListaClientes");	
		return "redirect:controlador?acao=ListaClientes";
	}

}
