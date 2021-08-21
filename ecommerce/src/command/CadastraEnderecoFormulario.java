package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.domain.Cliente;
import util.Conversao;

public class CadastraEnderecoFormulario implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.CadastraEndereco");	
		
//		Integer id = Conversao.parseStringToInt(request.getParameter("id"));
//		
//		Banco banco = new Banco();
//		Cliente cliente = banco.buscaClientePeloId(id);
//		
//		System.out.println(cliente.getNome());
//		
//		request.setAttribute("cliente", cliente);
		System.out.println("Classe: command.CadastraEndereco -> cadastraEndereco.jsp");
		return "forward:cadastraEndereco.jsp";
	}

}
