package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AlterarCommand;
import command.ConsultarCommand;
import command.ExcluirCommand;
import command.ICommand;
import command.SalvarCommand;
import model.domain.Pedido;
import model.domain.PedidoItemTroca;
import model.domain.Result;
import model.domain.enums.StatusPedido;
import model.domain.enums.StatusPedidoItem;
import util.Conversao;

@WebServlet("/view/marcarNotificacaoTrocaComoLida")
public class GerenciaNotificacaoTrocaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICommand command = new AlterarCommand();
	private List<PedidoItemTroca> itensTrocaNotificacao;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		itensTrocaNotificacao = (List<PedidoItemTroca>) request.getSession().getAttribute("itensTrocaNotificacao");
		
		if (itensTrocaNotificacao != null && !itensTrocaNotificacao.isEmpty()) {
			for (PedidoItemTroca itemTroca : itensTrocaNotificacao) {
				itemTroca.setNotificacao(true);
				command.executar(itemTroca);
			}
			 request.getSession().setAttribute("itensTrocaNotificacao", null);
		}
				
		response.sendRedirect(request.getContextPath() + "/view/listaClientes.jsp");
		
//		if (resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
//			request.setAttribute("grupos", resultado.getEntidades());
//		}
//
//		RequestDispatcher rd = request.getRequestDispatcher("/view/precificacao.jsp");
//		rd.forward(request, response);
	}
}
