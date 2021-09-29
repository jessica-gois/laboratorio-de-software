package model.domain;

public class PedidoItem {
	private Pedido pedido;
	private Livro livro;
	private Double quantidade;
	private Double valorUnitario;	
	
	public PedidoItem() {
		
	}
	
	public PedidoItem(Livro livro, Double quantidade){
		this.livro = livro;
		this.quantidade = quantidade;
		this.valorUnitario = livro.getPrecoVenda() != null ? livro.getPrecoVenda() : 0d;
	}		
	
	public Double getQuantidade() {
		if(quantidade == null) {
			quantidade = 0d;
		}
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorUnitario() {
		if(valorUnitario == null) {
			valorUnitario = 0d;
		}
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}	
	
	public Double getValorTotal() {
		return getQuantidade() * getValorUnitario();
	}
	
}
