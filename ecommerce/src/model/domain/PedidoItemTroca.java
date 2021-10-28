package model.domain;

public class PedidoItemTroca {
	private PedidoItem item;
	private Double quantidade;
	private Boolean notificacao;
	/*Quando o administrador autorizar uma troca o sistema deverá
	 *  gerar uma notificação sobre tal ao cliente.*/
		
	public PedidoItemTroca(){		
	}
	
	public PedidoItemTroca(PedidoItem pedidoItem){	
		if(pedidoItem != null) {
			this.item = pedidoItem;
			this.quantidade = pedidoItem.getQuantidade();			
		}
	}

	public PedidoItem getItem() {
		return item;
	}

	public void setItem(PedidoItem item) {
		this.item = item;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Boolean getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Boolean notificacao) {
		this.notificacao = notificacao;
	}
	
	public Pedido getPedido() {
		if(item != null && item.getPedido() != null ) {
			return item.getPedido();
		}
		return null;
	}
	
	public Cliente getCliente() {
		if(getPedido() != null && getPedido().getCliente() != null ) {
			return getPedido().getCliente();
		}
		return null;
	}
	
	
}
