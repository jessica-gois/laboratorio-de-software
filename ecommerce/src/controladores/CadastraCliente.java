package controladores;


import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import persistencias.Banco;
import util.Conversao;


@WebServlet("/cadastraCliente")
public class CadastraCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Conversao conv = new Conversao();
		
		String nome = request.getParameter("nome");
		String dataNascimento = request.getParameter("dataNascimento");
		String cpf = request.getParameter("cpf");
		String score = request.getParameter("score");
		String ativo = request.getParameter("status");

		
//		Date PdataNascimento = null;
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			PdataNascimento = sdf.parse(dataNascimento);
//		} catch (ParseException e) {
//			throw new ServletException(e);
//		}
		//cliente.setDataNascimento(PdataNascimento);
		
		Cliente cliente= new Cliente();
		cliente.setNome(nome);
		try {
			cliente.setDataNascimento(Conversao.parseStringToDate(request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cliente.setCpf(cpf);	
		cliente.setScore(Conversao.parseStringToInt(request.getParameter("score")));
		cliente.setStatus(Conversao.parseStringToBoolean(request.getParameter("status")));

		
		Banco banco = new Banco();
		banco.adiciona(cliente);
		
//		request.setAttribute("cliente", cliente.getNome());
//		response.sendRedirect("sucesso");
	
		request.setAttribute("cliente", cliente.getNome());
		RequestDispatcher rd = request.getRequestDispatcher("/sucesso.jsp");
		rd.forward(request, response);

		System.out.println("Cadastrando nova empresa");
		
	}

}

//gerenciador/novaEmpresa