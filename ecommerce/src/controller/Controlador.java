package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AtualizaCliente;
import command.CadastraCliente;
import command.ListaClientes;
import command.MostraCliente;
import command.RemoveCliente;
import command.NovoCadastroCliente;

@WebServlet("/controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ParametroAcao = request.getParameter("acao");

		String nomeJSP = null;

		if (ParametroAcao.equals("CadastraCliente")) {
			CadastraCliente acao = new CadastraCliente();
			nomeJSP = acao.executa(request, response);

		} else if (ParametroAcao.equals("NovoCadastroCliente")) {
			NovoCadastroCliente acao = new NovoCadastroCliente();
			nomeJSP = acao.executa(request, response);

		} else if (ParametroAcao.equals("ListaClientes")) {
			ListaClientes acao = new ListaClientes();
			nomeJSP = acao.executa(request, response);

		} else if (ParametroAcao.equals("AtualizaCliente")) {
			AtualizaCliente acao = new AtualizaCliente();
			nomeJSP = acao.executa(request, response);

		} else if (ParametroAcao.equals("MostraCliente")) {
			MostraCliente acao = new MostraCliente();
			nomeJSP = acao.executa(request, response);

		} else if (ParametroAcao.equals("RemoveCliente")) {
			RemoveCliente acao = new RemoveCliente();
			nomeJSP = acao.executa(request, response);

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
