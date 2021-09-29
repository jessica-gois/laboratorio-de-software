package model.domain;

public class PedidoItemTroca {
	private PedidoItem item;
	private Double quantidade;
	private String notificacao;
	/*Quando o administrador autorizar uma troca o sistema deverá
	 *  gerar uma notificação sobre tal ao cliente.*/
		
	public PedidoItemTroca(){		
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


	public String getNotificacao() {
		return notificacao;
	}


	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}
	
	
}
