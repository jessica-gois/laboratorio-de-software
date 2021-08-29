package model.domain.enums;

public enum Bandeira {
	VISA("Visa"), 
	MASTERCARD("Mastercard"), 
	ELO("Elo");
	
	private String descricao;
	
	Bandeira(String descricao) {
		this.descricao = descricao;
	}	
	
	public String getDescricao() {
		return this.descricao;
	}
}
