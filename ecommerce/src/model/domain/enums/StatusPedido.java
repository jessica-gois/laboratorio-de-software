package model.domain.enums;

public enum StatusPedido {
	EM_PROCESSAMENTO("Em processamento"),
	EM_TRANSITO("Em trânsito"),
	ENTREGUE("Entregue"),
	EM_TROCA("Em troca"),
	TROCA_AUTORIZADA("Troca autorizada");
	
	public String descricao;
	
	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}
}
