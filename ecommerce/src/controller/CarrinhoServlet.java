package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ConsultarCommand;
import model.domain.PedidoItem;
import model.domain.Result;

@WebServlet("/carrinho")
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	List<PedidoItem> itens = new ArrayList<PedidoItem>();
	private ConsultarCommand command = new ConsultarCommand();
	private Result resultado = new Result();
	private PedidoItem pedidoItem = new PedidoItem();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PedidoItem> carrinho = new ArrayList<PedidoItem>();
		
		if(request.getSession().getAttribute("carrinho") != null) {
			carrinho = (List<PedidoItem>) request.getSession().getAttribute("carrinho");
		}
		
		PedidoItem item = (PedidoItem) request.getAttribute("itemCarrinho");
		String acao = (String) request.getParameter("acaoCarrinho");
		
		if(acao.equals("adicionarItem")) {
			adicionarItemCarrinho(item, carrinho);
		}		
		
		request.getSession().setAttribute("carrinho", carrinho);
		response.sendRedirect(request.getContextPath() + "/view/carrinho.jsp");			
	}
	
	
	private void adicionarItemCarrinho(PedidoItem item, List<PedidoItem> carrinho) {		
		if(item != null && item.getQuantidade() != null && item.getQuantidade() > 0) {
			boolean adicionado = false;
			
			for(PedidoItem itemCarrinho : carrinho) {
				if(itemCarrinho.getLivro().equals(item.getLivro())) {
					itemCarrinho.setQuantidade(itemCarrinho.getQuantidade() + item.getQuantidade());
					adicionado = true;
					break;
				}
			}
			
			if(!adicionado) {
				carrinho.add(item);
			}			
		}			
	}

}
