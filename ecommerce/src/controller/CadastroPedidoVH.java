package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Pedido;
import model.domain.Result;
import util.Conversao;

public class CadastroPedidoVH implements IViewHelper { 
	
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		Endereco enderecoEntrega = new Endereco();
		Endereco enderecoCobranca = new Endereco();
		
		Integer idEntrega = Conversao.parseStringToInt(request.getParameter("enderecoEntrega"));
		Integer idCobranca = Conversao.parseStringToInt(request.getParameter("enderecoCobranca"));
		enderecoEntrega.setId(idEntrega);
		enderecoCobranca.setId(idCobranca);
		pedido.setEnderecoEntrega(enderecoEntrega);
		pedido.setEnderecoCobranca(enderecoCobranca);
		
		return pedido;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/view/login.jsp");	

	}

}
