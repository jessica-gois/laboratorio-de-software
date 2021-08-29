package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Banco;
import dao.UsuarioDAO;
import model.domain.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Classe: command.Login");					
		Usuario usuario = new Usuario(request.getParameter("email"), request.getParameter("senha"));
		usuario.setPesquisa("email,senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Banco banco = new Banco();
		List<Usuario> resultado =  dao.consultar(usuario);
		usuario = resultado != null ? resultado.get(0) : null;		
		
        if(usuario != null) {
           System.out.println("Usuario existe no sistema");
           HttpSession sessao = request.getSession();
           sessao.setAttribute("usuarioLogado", usuario);
           System.out.println("Classe: command.Login -> command.ListaClientes ");
           return "redirect:controlador?acao=ListaClientes";
        }else {
        	System.out.println("Classe: command.Login -> command.LoginFormulario ");
        	return "redirect:controlador?acao=LoginFormulario";
        }
	
	}

}
