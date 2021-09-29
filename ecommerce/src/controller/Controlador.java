package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AlterarCommand;
import command.ConsultarCommand;
import command.ExcluirCommand;
import command.ICommand;
import command.SalvarCommand;
import model.domain.EntidadeDominio;
import model.domain.Result;

@WebServlet(urlPatterns = "/controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,ICommand> commandMap = new HashMap<String,ICommand>();
	
	public Controlador() {
		commandMap.put("salvar", new SalvarCommand());
		commandMap.put("alterar", new AlterarCommand());
		commandMap.put("excluir", new ExcluirCommand());
		commandMap.put("consultar", new ConsultarCommand());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroAcao = request.getParameter("acao");	
		String nomeViewHelper = request.getParameter("viewHelper");
		
		try {
			String viewHelper = "controller." + nomeViewHelper;
			Class classe = Class.forName(viewHelper);
			IViewHelper iViewHelper = (IViewHelper)classe.newInstance();
			
			ICommand command = commandMap.get(parametroAcao);
			EntidadeDominio entidade = iViewHelper.getEntidade(request,response);
			
			Result resultado = command.executar(entidade);
			iViewHelper.setView(resultado, request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
//		String[] tipoEndereco = nomeJSP.split(":");
//		if (tipoEndereco[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
//			rd.forward(request, response);
//		} else {
//			response.sendRedirect(tipoEndereco[1]);
//		}		
	}
}
