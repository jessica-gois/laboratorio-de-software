package model.domain;

import java.util.Date;

public class PedidoItem extends EntidadeDominio {
	private Pedido pedido;
	private Livro livro;
	private Double quantidade;
	private Double valorUnitario;
	private boolean trocado;

	public PedidoItem() {
	}

	public PedidoItem(CarrinhoItem item) {
		this.livro = item.getLivro();
		this.quantidade = item.getQuantidade();
		this.valorUnitario = item.getValorUnitario();
	}
	
	public PedidoItem(Integer id, Date dtCadastro, Double quantidade, Double valorUnitario, Livro livro, boolean isTrocado) {
		super();
		if(id != null) {
			this.setId(id);
		}
		if(dtCadastro != null) {
			this.setDtCadastro(dtCadastro);
		}
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.livro = livro;
		this.trocado = isTrocado;
	}

	public Double getQuantidade() {
		if (quantidade == null) {
			quantidade = 0d;
		}
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		if (valorUnitario == null) {
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

	public boolean isTrocado() {
		return trocado;
	}

	public void setTrocado(boolean trocado) {
		this.trocado = trocado;
	}

}
