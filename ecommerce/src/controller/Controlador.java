package controller;

import java.io.IOException;

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


@WebServlet("/controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ParametroAcao = request.getParameter("acao");
		
		if (ParametroAcao.equals("CadastraCliente")) {
			CadastraCliente acao = new CadastraCliente();
			acao.executa(request,response);
			
			
		} else if (ParametroAcao.equals("ListaClientes")) {
			ListaClientes acao = new ListaClientes();
			acao.executa(request,response);

			
			
		} else if (ParametroAcao.equals("AtualizaCliente")) {
			AtualizaCliente acao = new AtualizaCliente ();
			acao.executa(request,response);
			
			
		} else if (ParametroAcao.equals("MostraCliente")) {
			MostraCliente acao = new MostraCliente();
			acao.executa(request,response);
		
			
		}else if (ParametroAcao.equals("RemoveCliente")) {
			RemoveCliente  acao = new RemoveCliente();
			acao.executa(request,response);
			
		}
		
	}




}
