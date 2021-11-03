package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Cidade;
import model.domain.Cliente;
import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.Telefone;
import model.domain.enums.Estado;
import model.domain.enums.TipoEndereco;
import model.domain.enums.TipoLogradouro;
import model.domain.enums.TipoResidencia;
import model.domain.enums.TipoTelefone;
import util.Conversao;

public class AlterarClienteVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cliente cliente = (Cliente)request.getSession().getAttribute("clienteLogado");
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setSobrenome(request.getParameter("sobrenome"));
		cliente.setGenero(request.getParameter("genero"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.getUsuario().setEmail(request.getParameter("email"));
		try {
			cliente.setDataNascimento(Conversao.parseStringToDate(request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cliente.setCpf(request.getParameter("cpf"));
		
		Telefone telResidencial = new Telefone(cliente.getTelefoneResidencial().getId(),request.getParameter("dddResidencial"), 
			request.getParameter("numeroTelResidencial"), TipoTelefone.RESIDENCIAL);
		
		Telefone celular = new Telefone(cliente.getTelefoneCelular().getId(), request.getParameter("dddCelular"), 
				request.getParameter("numeroTelCelular"), TipoTelefone.CELULAR);
		
		cliente.setTelefoneResidencial(telResidencial);
		cliente.setTelefoneCelular(celular);
		
		return cliente;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/carregarDadosCliente");
		// }

	}

}
