package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Cartao;
import model.domain.Cidade;
import model.domain.Cliente;
import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.Telefone;
import model.domain.Usuario;
import model.domain.enums.Bandeira;
import model.domain.enums.Estado;
import model.domain.enums.TipoEndereco;
import model.domain.enums.TipoLogradouro;
import model.domain.enums.TipoResidencia;
import model.domain.enums.TipoTelefone;
import util.Conversao;

public class CadastroClienteVH implements IViewHelper { 
	
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

		Cidade cidade = new Cidade(request.getParameter("cidade"), Estado.getBySigla(request.getParameter("estado")));
		
		Endereco enderecoResidencial = new Endereco(request.getParameter("descricaoEndereco"), TipoLogradouro.valueOf(request.getParameter("tipoLogradouro")),
				request.getParameter("logradouro"), request.getParameter("numeroEndereco"), request.getParameter("complemento"), 
				TipoResidencia.valueOf(request.getParameter("tipoResidencia")), request.getParameter("bairro"), request.getParameter("cep"),
				cidade, request.getParameter("observacaoEndereco"), TipoEndereco.Residencial);

		Telefone telefoneResidencial = new Telefone(request.getParameter("dddResidencial"), request.getParameter("numeroTelResidencial"),
				TipoTelefone.RESIDENCIAL);
		
		Telefone telefoneCelular = new Telefone(request.getParameter("dddCelular"), request.getParameter("numeroTelCelular"), TipoTelefone.CELULAR);
		
		Usuario usuario = new Usuario(request.getParameter("email"), request.getParameter("senha"), true);
		
		Cliente cliente = null;
		try {
			cliente = new Cliente(request.getParameter("nome"), request.getParameter("sobrenome"), request.getParameter("genero"),
					Conversao.parseStringToDate(request.getParameter("dataNascimento")), request.getParameter("cpf"), 
					Conversao.parseStringToInt(request.getParameter("score")), telefoneResidencial, telefoneCelular, enderecoResidencial, usuario);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		//if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/view/login.jsp");	
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
