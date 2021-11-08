package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.CarrinhoItem;
import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Pedido;
import model.domain.PedidoItem;
import model.domain.Result;
import model.domain.enums.StatusPedidoItem;
import util.Conversao;

public class CadastroPedidoVH implements IViewHelper { 
	
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Pedido pedido = (Pedido) request.getSession().getAttribute("novoPedido");
		Endereco enderecoEntrega = new Endereco();
		Endereco enderecoCobranca = new Endereco();
		
		enderecoEntrega.setId(Conversao.parseStringToInt(request.getParameter("enderecoEntrega")));
		enderecoCobranca.setId(Conversao.parseStringToInt(request.getParameter("enderecoCobranca")));
		pedido.setEnderecoEntrega(enderecoEntrega);
		pedido.setEnderecoCobranca(enderecoCobranca);
		
		if(pedido.getItens() != null && !pedido.getItens().isEmpty()) {
			for(PedidoItem item : pedido.getItens()) {
				item.setStatus(StatusPedidoItem.EM_PROCESSAMENTO);
			}
			
		}
		
		return pedido;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String erroPedido = null;
		if(resultado.getResposta()==null) {
			request.getSession().setAttribute("carrinho", null);
			response.sendRedirect(request.getContextPath() + "/view/sucesso.jsp");	
		}else {
			erroPedido = resultado.getResposta();
			response.sendRedirect(request.getContextPath() + "/view/finalizarPedido?erroPedido="+ (erroPedido != null ? URLEncoder.encode(erroPedido, "UTF-8" ) : ""));
		}
	}

}
