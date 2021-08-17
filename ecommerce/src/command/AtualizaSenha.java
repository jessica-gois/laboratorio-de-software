package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

import dao.Banco;
import model.domain.Cliente;
import util.Conversao;

public class AtualizaSenha implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.AtualizaSenha");		
		
		Conversao conv = new Conversao();

		Integer id = Conversao.parseStringToInt(request.getParameter("id"));
		String senha = request.getParameter("senha");
		String confirmacaoSenha = request.getParameter("confirmacaoSenha");

		
		Banco banco = new Banco();
		Cliente cliente = banco.buscaClientePeloId(id);
		
		cliente.setSenha(senha);
		cliente.setConfirmacaoSenha(confirmacaoSenha);


		System.out.println("Classe: command.AtualizaSenha -> command.ListaClientes");	
		return "redirect:controlador?acao=ListaClientes";
		
		
	}

}
