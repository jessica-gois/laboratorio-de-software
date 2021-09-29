package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Result;
import util.Conversao;

public class PreparaAlteracaoClienteVH implements IViewHelper { 
	
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
		cliente.setId(Conversao.parseStringToInt(request.getParameter("id")));
		cliente.setPesquisa("id");
		return cliente;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<EntidadeDominio> entidades = resultado.getEntidades();
		
		if(entidades != null && !entidades.isEmpty()) {
			Cliente cliente = (Cliente) entidades.get(0);
			request.getSession().setAttribute("cliente", cliente);	
		}
			
		//if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/view/atualizaCliente.jsp");	
		//}
	}

}
