package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import model.domain.Cupom;
import model.domain.Pedido;
import model.domain.PedidoItem;
import model.domain.PedidoItemTroca;
import model.domain.Result;
import model.domain.enums.StatusPedido;
import model.domain.enums.StatusPedidoItem;
import model.domain.enums.TipoCupom;
import util.Conversao;

@WebServlet("/view/gerenciamentoStatusPedido")
public class GerenciaStatusPedidoAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICommand command;
	Pedido pedido;
	StatusPedido status = null;
	Result resultado;
	PedidoItemTroca itemTroca;
	Double valorTotalCupomTroca;
	private Map<String,ICommand> commandMap = new HashMap<String,ICommand>();	
	
	public GerenciaStatusPedidoAdminServlet() {
		commandMap.put("salvar", new SalvarCommand());
		commandMap.put("alterar", new AlterarCommand());
		commandMap.put("excluir", new ExcluirCommand());
		commandMap.put("consultar", new ConsultarCommand());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		itemTroca = new PedidoItemTroca();
		pedido = (Pedido) request.getSession().getAttribute("pedidoAdmin");
		valorTotalCupomTroca = 0d;
		
		if (request.getParameter("status") != null && !request.getParameter("status").isBlank()) {
			System.out.println(request.getParameter("status"));
			status = StatusPedido.valueOf(request.getParameter("status"));
		}
		
		if(pedido == null && request.getParameter("id") != null) {
			command = commandMap.get("consultar");
			pedido = new Pedido();
			pedido.setId(Conversao.parseStringToInt(request.getParameter("id")));
			pedido.setPesquisa("id");
			pedido = (Pedido) command.executar(pedido).getEntidades().get(0);
		}
		
		if(status != null) {	
			if ((status != StatusPedido.TROCA_AUTORIZADA && status != StatusPedido.TROCA_REALIZADA) || 
				(!pedido.isPossuiTrocaParcialSolicitada() && !pedido.isPossuiTrocaParcialAutorizada())) {
				
				pedido.setStatus(status);
				command = commandMap.get("alterar");
				command.executar(pedido);
				
				valorTotalCupomTroca = pedido.getValorTotalItens();
				
			} else { // Caso seja a autorização ou finalização de troca parcial

				command = commandMap.get("alterar");
				
				if(status == StatusPedido.TROCA_AUTORIZADA) {
					gerenciarTrocaParcialAutorizada();
				}
				
				if(status == StatusPedido.TROCA_REALIZADA) {
					gerenciarTrocaParcialRealizada();
				}
			}		
		}
		
		if(status == StatusPedido.TROCA_REALIZADA) {
			gerarCupomDeTroca(valorTotalCupomTroca, pedido);
		}
				
		response.sendRedirect("/ecommerce/controlador?acao=consultar&viewHelper=ConsultarPedidoAdminVH&id=" + pedido.getId());

	}
	
	public void gerenciarTrocaParcialAutorizada() {
		for (PedidoItem item : pedido.getItens()) {
			if (item.getStatus() != null && item.getStatus().equals(StatusPedidoItem.TROCA_SOLICITADA)) {
				Double quantidadeTroca = item.getQuantidade() - item.getQuantidadeDisponivelTroca();				
				
				if(quantidadeTroca != null && quantidadeTroca > 0) {
					item.setStatus(StatusPedidoItem.TROCA_AUTORIZADA);
					command.executar(item);
				}
			}
		}
	}
	
	public void gerenciarTrocaParcialRealizada() {
		
		for (PedidoItem item : pedido.getItens()) {
			if (item.getStatus() != null && item.getStatus().equals(StatusPedidoItem.TROCA_AUTORIZADA)) {
				Double quantidadeTroca = item.getQuantidade() - item.getQuantidadeDisponivelTroca();
				valorTotalCupomTroca += quantidadeTroca * item.getValorUnitario();
				
				if(quantidadeTroca != null && quantidadeTroca > 0) {
					item.setStatus(StatusPedidoItem.TROCA_REALIZADA);
					command.executar(item);
				}
			}
		}
		
	}
	
	public void gerarCupomDeTroca(Double valorCupom, Pedido pedido) {
		if (valorCupom != null && valorCupom > 0 && pedido != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.YEAR, 1);
			Date validade = calendar.getTime(); // Atribuindo validade de um ano ao cupom de troca

			Cupom cupom = new Cupom(null, "TPED" + pedido.getId(), "Troca do pedido " + pedido.getId(), valorCupom,
				validade, TipoCupom.TROCA, pedido.getCliente().getId(), pedido.getId());

			command = commandMap.get("salvar");
			command.executar(cupom);
		}
	}
}
