package model.domain.enums;

public enum StatusPedido {
	EM_PROCESSAMENTO("Em processamento"),
	EM_TRANSITO("Em trânsito"),
	ENTREGUE("Entregue"),
	TROCA_SOLICITADA("Troca solicitada"),
	TROCA_AUTORIZADA("Troca autorizada"),
	TROCA_REPROVADA("Troca reprovada");
	
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
