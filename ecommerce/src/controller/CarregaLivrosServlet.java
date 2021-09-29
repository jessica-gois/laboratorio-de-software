package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ConsultarCommand;
import model.domain.Livro;
import model.domain.Result;

@WebServlet("/view/index")
public class CarregaLivrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ConsultarCommand command = new ConsultarCommand();
	private Result resultado = new Result();
	private Livro livro = new Livro();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		prepararConsultaEntidades();
		resultado = command.executar(livro);	
		
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			request.setAttribute("livros", resultado.getEntidades());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/index.jsp");
		rd.forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/view/index.jsp");
	}

	
	private void prepararConsultaEntidades() {
		livro.setPesquisa("status");
		livro.setStatus(true);
	}
}
