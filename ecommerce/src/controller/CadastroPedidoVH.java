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
		
		enderecoEntrega.setId(Conversao.parseStringToInt(request.getParameter("enderecoEntrega")));
		enderecoCobranca.setId(Conversao.parseStringToInt(request.getParameter("enderecoCobranca")));
		pedido.setEnderecoEntrega(enderecoEntrega);
		pedido.setEnderecoCobranca(enderecoCobranca);
		
		return pedido;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/view/sucesso.jsp");	

	}

}
