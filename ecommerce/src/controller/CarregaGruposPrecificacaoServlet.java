package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ConsultarCommand;
import model.domain.GrupoPrecificacao;
import model.domain.Result;

@WebServlet("/view/precificacao")
public class CarregaGruposPrecificacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ConsultarCommand command = new ConsultarCommand();
	private Result resultado = new Result();
	private GrupoPrecificacao grupo = new GrupoPrecificacao();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		grupo.setPesquisa("");
		resultado = command.executar(grupo);	
		
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			request.setAttribute("grupos", resultado.getEntidades());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/precificacao.jsp");
		rd.forward(request, response);
	}
}
