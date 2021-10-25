package controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Livro;
import model.domain.MovimentacaoEstoque;
import model.domain.Pedido;
import model.domain.Result;
import model.domain.Usuario;
import model.domain.enums.StatusPedido;
import model.domain.enums.TipoMovimentacao;
import util.Conversao;

public class ConsultarPedidosAdminVH implements IViewHelper {
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {		
		

		Pedido pedido = new Pedido();

		
		if(request.getParameter("tipoPesquisa") != null && !request.getParameter("tipoPesquisa").isBlank() ) {
			pedido.setPesquisa(request.getParameter("tipoPesquisa"));
			
			
			if (request.getParameter("id") != null && !request.getParameter("id").isBlank()) {
				pedido.setId(Conversao.parseStringToInt(request.getParameter("id").trim()));
			}
			
			if (request.getParameter("dtCadastro") != null && !request.getParameter("dtCadastro").isBlank()) {
				try {
					pedido.setDtCadastro((Conversao.parseStringToDate(request.getParameter("dtCadastro"), "yyyy-MM-dd")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			if(request.getParameter("email") != null && !request.getParameter("email").isBlank()) {
				Usuario usuario = new Usuario();
				Cliente cliente = new Cliente();
				usuario.setEmail(request.getParameter("email").trim());
				cliente.setUsuario(usuario);
				pedido.setCliente(cliente);	
			}
			
			if(request.getParameter("cpf") != null && !request.getParameter("cpf").isBlank()) {
				if (pedido.getCliente() == null) {
					Cliente cliente = new Cliente();
					pedido.setCliente(cliente);
				}
				pedido.getCliente().setCpf(request.getParameter("cpf").trim());
			}
			
			if(request.getParameter("valorTotal") != null && !request.getParameter("valorTotal").isBlank()) {
				pedido.setValorTotal(Conversao.parseStringToDouble(request.getParameter("valorTotal").trim()));
			} else {
				pedido.setValorTotal(0d);
			}
				
			if(request.getParameter("status") != null && !request.getParameter("status").isBlank()) {
				pedido.setStatus(StatusPedido.valueOf(request.getParameter("status")));
			}
		}			
		return pedido;
	}
	
	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
			request.getSession().setAttribute("pedidos", resultado.getEntidades());
			response.sendRedirect(request.getContextPath() + "/view/consultarPedidos.jsp");
	}
}
