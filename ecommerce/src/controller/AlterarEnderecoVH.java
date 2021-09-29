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
import model.domain.enums.Estado;
import model.domain.enums.TipoEndereco;
import model.domain.enums.TipoLogradouro;
import model.domain.enums.TipoResidencia;
import util.Conversao;

public class AlterarEnderecoVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

		Cidade cidade = new Cidade(request.getParameter("cidade"), Estado.getBySigla(request.getParameter("estado")));
		
		TipoEndereco tipoEndereco = request.getParameter("tipoEndereco") != null ? 
			TipoEndereco.valueOf(request.getParameter("tipoEndereco")) : TipoEndereco.Residencial;
		
		Endereco endereco = new Endereco(Conversao.parseStringToInt(request.getParameter("id")),
				request.getParameter("descricaoEndereco"),
				TipoLogradouro.valueOf(request.getParameter("tipoLogradouro")), request.getParameter("logradouro"),
				request.getParameter("numeroEndereco"), request.getParameter("complemento"),
				TipoResidencia.valueOf(request.getParameter("tipoResidencia")), request.getParameter("bairro"),
				request.getParameter("cep"), cidade, request.getParameter("observacaoEndereco"),
				tipoEndereco);

		return endereco;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/carregarDadosCliente");
		// }

	}

}
