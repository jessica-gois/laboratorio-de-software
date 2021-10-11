package model.domain;

public class CarrinhoItem {
	private Livro livro;
	private Double quantidade;
	private Double valorUnitario;

	public CarrinhoItem() {
	}
	
	public CarrinhoItem(Livro livro, Double quantidade){
		this.livro = livro;
		this.quantidade = quantidade;
		this.valorUnitario = livro.getPrecoVenda();
	}	
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
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
	
	public Double getValorTotal() {
		return getQuantidade() * getValorUnitario();
	}
	
}
