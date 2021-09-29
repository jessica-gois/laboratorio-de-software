package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Cartao;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.enums.Bandeira;
import util.Conversao;

public class CadastroCartaoVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

		Cartao cartao = new Cartao(request.getParameter("numeroCartao"),
			Bandeira.valueOf(request.getParameter("bandeira")),
			request.getParameter("nomeImpresso"), request.getParameter("codigoSeguranca"),
			Conversao.parseStringToBoolean(request.getParameter("preferencial")),
			(Cliente) request.getSession().getAttribute("clienteLogado"));

		return cartao;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/carregarDadosCliente");	
		//}

//		try {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/listaClientes.jsp");
//			rd.forward(request, response);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
