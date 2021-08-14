package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Acao;
import command.AtualizaCliente;
import command.CadastraCliente;
import command.ListaClientes;
import command.MostraCliente;
import command.CadastraClienteFormulario;
import command.RemoveCliente;

@WebServlet("/controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeJSP = null;
		String ParametroAcao = request.getParameter("acao");
		
		try {
			String nomeClasse = "command."+ ParametroAcao;
			Class classe = Class.forName(nomeClasse); // carrega a classe com o nome desta string
			Acao acao = (Acao)classe.newInstance();
			nomeJSP = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEndereco = nomeJSP.split(":");
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}		
	}
}
