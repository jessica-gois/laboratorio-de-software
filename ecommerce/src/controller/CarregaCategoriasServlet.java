package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ConsultarCommand;
import model.domain.Categoria;
import model.domain.Result;

@WebServlet("/view/categoria")
public class CarregaCategoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ConsultarCommand command = new ConsultarCommand();
	private Result resultado = new Result();
	private Categoria categoria = new Categoria();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		categoria.setPesquisa("");
		resultado = command.executar(categoria);	
		
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			request.setAttribute("categorias", resultado.getEntidades());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/categoria.jsp");
		rd.forward(request, response);
	}
}
