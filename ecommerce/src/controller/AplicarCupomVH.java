package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cupom;
import model.domain.EntidadeDominio;
import model.domain.FormaPagamento;
import model.domain.Pedido;
import model.domain.Result;
import model.domain.enums.TipoCupom;
import util.Conversao;

public class AplicarCupomVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		Cupom cupom = new Cupom();		
		cupom.setId(Conversao.parseStringToInt(request.getParameter("id")));
		cupom.setPesquisa("id");
			
		return cupom;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			Cupom cupom = (Cupom) resultado.getEntidades().get(0);
			Pedido pedido = (Pedido) request.getSession().getAttribute("novoPedido");
			StringBuilder erroCupom = new StringBuilder();
			
			if(cupom.getTipo() != TipoCupom.PROMOCIONAL || !pedido.isUtilizouCupomPromocional()) {
				if(pedido.getValorTotal() > 0) {
				FormaPagamento formaPagamento = new FormaPagamento(cupom);				
				pedido.getFormasPagamento().add(formaPagamento);
				
				//Caso o valor do pedido tenha sido pago completamente pelos cupons, remover os cart�es do pedido
				if (pedido.getValorTotal() <= 0) {
					List<FormaPagamento> formasRemover = new ArrayList<FormaPagamento>();
					for (FormaPagamento forma : pedido.getFormasPagamento()) {
						if (forma.getCartao() != null && forma.getCartao().getId() > 0) {
							formasRemover.add(forma);
						}
					}

					pedido.getFormasPagamento().removeAll(formasRemover);
				}
				
				request.getSession().setAttribute("novoPedido", pedido);
				}else {
					erroCupom.append("N�o � poss�vel aplicar mais cupons ao pedido, valor de descontos excedido.\n ");
				}
			}else {
				erroCupom.append("N�o � poss�vel utilizar mais de um cupom promocional no pedido.");
			}
			
			response.sendRedirect(request.getContextPath() + "/view/finalizarPedido?erroCupom="+ (erroCupom.length() > 0 
				? URLEncoder.encode(erroCupom.toString(), "UTF-8" ) : ""));
		}
	}

}
