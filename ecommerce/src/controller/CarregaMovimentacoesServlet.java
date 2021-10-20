package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ConsultarCommand;
import model.domain.MovimentacaoEstoque;
import model.domain.Result;

@WebServlet("/view/consultarMovimentacoes")
public class CarregaMovimentacoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ConsultarCommand command = new ConsultarCommand();
	private Result resultado = new Result();
	private MovimentacaoEstoque movimentacaoEstoque  = new MovimentacaoEstoque();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		movimentacaoEstoque.setPesquisa("");
		resultado = command.executar(movimentacaoEstoque);	
		
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			request.setAttribute("movimentacoes", resultado.getEntidades());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/consultarMovimentacoes.jsp");
		rd.forward(request, response);
	}
}
