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
		System.out.println("JSP: cadastraCliente");
		
		Conversao conv = new Conversao();
		Cliente cliente= new Cliente();
		
		String nome = request.getParameter("nome");
		String dataNascimento = request.getParameter("dataNascimento");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String confirmacaoSenha = request.getParameter("confirmacaoSenha");
		String score = request.getParameter("score");
		String status = request.getParameter("status");



		cliente.setNome(nome);
		try {
			cliente.setDataNascimento(Conversao.parseStringToDate(request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		cliente.setCpf(cpf);	
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setConfirmacaoSenha(confirmacaoSenha);
		cliente.setScore(Conversao.parseStringToInt(score));
		cliente.setStatus(Conversao.parseStringToBoolean(status));
		
		System.out.println(cliente.getEmail());
		System.out.println(cliente.getSenha());
		System.out.println(cliente.getConfirmacaoSenha());
		System.out.println(cliente.getScore());
		System.out.println(cliente.getStatus());

		
		Banco banco = new Banco();
		banco.adiciona(cliente);
		
		request.setAttribute("cliente", cliente.getNome());
		
		
		return "redirect:controlador?acao=ListaClientes";
	}

}
