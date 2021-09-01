package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Banco;
import dao.UsuarioDAO;
import model.domain.Cartao;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.Usuario;

public class Login extends AbstractCommand {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Classe: command.Login");					
		Usuario usuario = new Usuario(request.getParameter("email"), request.getParameter("senha"));
		usuario.setPesquisa("email,senha");
		
		Result resultado = fachada.consultar(usuario);
		usuario  = resultado != null && resultado.getEntidades() != null ? (Usuario)resultado.getEntidades().get(0) : null;		
		
        if(usuario != null) {
           System.out.println("Usuario existe no sistema");
           Cliente cliente = new Cliente(usuario);
           cliente.setPesquisa("usuario");
           
           resultado = fachada.consultar(cliente);
           cliente  = resultado != null && resultado.getEntidades() != null ? (Cliente)resultado.getEntidades().get(0) : null;
           cliente.setUsuario(usuario);
           
           Cartao cartao = new Cartao();
           cartao.setPesquisa("cliente");
           cartao.setCliente(cliente);
           
           
           
           
           
           HttpSession sessao = request.getSession();           
           sessao.setAttribute("clienteLogado", cliente);
           sessao.setAttribute("cartoes", fachada.consultar(cartao).getEntidades());
           System.out.println("Classe: command.Login -> command.ListaClientes ");
           return "redirect:controlador?acao=ListaClientes";
        }else {
        	System.out.println("Classe: command.Login -> command.LoginFormulario ");
        	return "redirect:controlador?acao=LoginFormulario";
        }
	
	}

}
