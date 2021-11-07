package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.EntidadeDominio;
import model.domain.Pedido;
import model.domain.Result;
import model.domain.enums.StatusPedido;
import util.Conversao;

public class SolicitarTrocaVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.TROCA_SOLICITADA);
		pedido.setId(Conversao.parseStringToInt(request.getParameter("id")));				
		return pedido;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// if(resultado.getResposta()==null) {
		response.sendRedirect(request.getContextPath() + "/view/listaClientes.jsp");
		// }

	}
	
	
//	@Override
//	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		//if(resultado.getResposta()==null) {
//		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
//			Pedido pedido = (Pedido) resultado.getEntidades().get(0);
//			String caminhoRedirecionar = request.getParameter("caminhoRedirecionar") != null ?
//				request.getParameter("caminhoRedirecionar") : "/view/detalhePedido.jsp";
//			request.getSession().setAttribute("pedido", pedido);
//			
//			response.sendRedirect(request.getContextPath() + caminhoRedirecionar);		
//		}else {
//			response.sendRedirect(request.getContextPath() + "/view/index");
//		}
//		//}
//	}

}
