package model.domain.enums;

public enum TipoMovimentacao {
	SAIDA_POR_VENDA("Saída por venda"),
	ENTRADA_POR_TROCA("Entrada por troca"),
	ENTRADA_POR_COMPRA("Entrada por compra");
	
	private String descricao;
	
	private TipoMovimentacao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
