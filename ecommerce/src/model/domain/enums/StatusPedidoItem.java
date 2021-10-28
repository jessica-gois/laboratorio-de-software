package model.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum StatusPedidoItem {
	EM_PROCESSAMENTO("Em processamento"),
	APROVADO("Pedido aprovado"),
	REPROVADO("Pedido reprovado"),
	EM_TRANSITO("Em trânsito"),
	ENTREGUE("Entregue"),
	TROCA_SOLICITADA("Troca solicitada"),
	TROCA_AUTORIZADA("Troca autorizada"),
	TROCA_REPROVADA("Troca reprovada"),
	TROCA_REALIZADA("Troca realizada");
	
	public String descricao;
	
	
	private StatusPedidoItem(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}
	
	public static List<StatusPedidoItem> getTiposStatus (){
		List<StatusPedidoItem> tipos = Arrays.asList(StatusPedidoItem.values());
		return tipos;
	}
}
