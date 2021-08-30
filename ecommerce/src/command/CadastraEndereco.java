package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Cidade;
import model.domain.Cliente;
import model.domain.Endereco;
import model.domain.Estado;
import model.domain.enums.TipoEndereco;
import model.domain.enums.TipoLogradouro;
import model.domain.enums.TipoResidencia;

public class CadastraEndereco extends AbstractCommand {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe: command.CadastraEndereco");	
		
		//HttpSession sessao = request.getSession();
	    //Cliente cliente =  (Cliente)sessao.getAttribute("clienteLogado");
		
		Cliente cliente = new Cliente();
	    
		cliente.setId(1);
		
		Estado estado = new Estado ();
		Cidade cidade = new Cidade();

		Endereco endereco = new Endereco (cliente,request.getParameter("descricao"), 
				TipoLogradouro.valueOf(request.getParameter("tipoLogradouro")),
				request.getParameter("logradouro"), request.getParameter("numero"),
				request.getParameter("complemento"), TipoResidencia.valueOf(request.getParameter("tipoResidencia")), 
				request.getParameter("bairro"), request.getParameter("cep"), estado, cidade,
				request.getParameter("observacao"), TipoEndereco.valueOf(request.getParameter("tipoEndereco")));		
		
		System.out.println("Classe: controller.fachada.salvar(endereco)");			
		
		return fachada.salvar(endereco);
	}

}
