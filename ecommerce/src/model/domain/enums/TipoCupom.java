package model.domain.enums;

public enum TipoCupom {
	TROCA("Troca"),
	PROMOCIONAL("Promocional");
	
	private String descricao;
	
	private TipoCupom(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}
}
