package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Banco;
import model.domain.Cliente;
import model.domain.Usuario;
import util.Conversao;

public class ConfirmaSenhaAtualFormulario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Conversao conv = new Conversao();
		Integer id = Conversao.parseStringToInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		Cliente cliente = banco.buscaClientePeloId(id);
		 HttpSession sessao = request.getSession();
         sessao.setAttribute("cliente", cliente);
		
		System.out.println(cliente.getNome());
		System.out.println("Classe: command.ConfirmaSenhaAtualFormulario");	
		System.out.println("Classe: command.ConfirmaSenhaAtualFormulario.java -> confirmaSenhaAtual.jsp");
		return "forward:confirmaSenhaAtual.jsp";
	}

}
