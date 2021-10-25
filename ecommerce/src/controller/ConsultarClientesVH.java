package controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Carrinho;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Livro;
import model.domain.MovimentacaoEstoque;
import model.domain.Result;
import model.domain.Usuario;
import model.domain.enums.TipoMovimentacao;
import util.Conversao;

public class ConsultarClientesVH implements IViewHelper {


	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		
		Cliente cliente = new Cliente();
		if(request.getParameter("tipoPesquisa") != null && !request.getParameter("tipoPesquisa").isBlank() ) {
			cliente.setPesquisa(request.getParameter("tipoPesquisa"));
			
			if(request.getParameter("codigo") != null && !request.getParameter("codigo").isBlank()) {
				cliente.setId(Conversao.parseStringToInt(request.getParameter("codigo").trim()));
			}
			if (request.getParameter("email") != null && !request.getParameter("email").isBlank()) {
				Usuario usuario = new Usuario();
				usuario.setEmail(request.getParameter("email").trim());
				cliente.setUsuario(usuario);
			}
			if (request.getParameter("cpf") != null && !request.getParameter("cpf").isBlank()) {
				cliente.setCpf(request.getParameter("cpf").trim());
			}
			if (request.getParameter("status") != null && !request.getParameter("status").isBlank()) {
				if(cliente.getUsuario() == null) {
					Usuario usuario = new Usuario();
					cliente.setUsuario(usuario);
				}
				cliente.getUsuario().setStatus(Conversao.parseStringToBoolean(request.getParameter("status")));
			}
			if (request.getParameter("nome") != null && !request.getParameter("nome").isBlank()) {
				cliente.setNome(request.getParameter("nome").trim());
			}
			if (request.getParameter("sobrenome") != null && !request.getParameter("sobrenome").isBlank()) {
				cliente.setSobrenome(request.getParameter("sobrenome").trim());
			}
			if (request.getParameter("dataNascimento") != null && !request.getParameter("dataNascimento").isBlank()) {
				try {
					System.out.println(request.getParameter("dataNascimento"));
					cliente.setDataNascimento(Conversao.parseStringToDate(request.getParameter("dataNascimento").trim(), "yyyy-MM-dd"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return cliente;
	}


	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("clientes", resultado.getEntidades());
		response.sendRedirect(request.getContextPath() + "/view/consultarClientes.jsp");
	}

}