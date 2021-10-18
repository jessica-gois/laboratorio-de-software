package model.domain;

import java.util.Date;

public class GrupoPrecificacao extends EntidadeDominio {
	private String descricao;
	private Double margemLucro;

	public GrupoPrecificacao() {
		
	}
	
	public GrupoPrecificacao(Integer id, String descricao, Double margemLucro, Date dtCadastro) {
		super();
		if(id != null) {
			this.setId(id);			
		}
		if(dtCadastro != null) {
			this.setDtCadastro(dtCadastro);
		}
		this.descricao = descricao;
		this.margemLucro = margemLucro;		
	}
	
	public Double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(Double margemLucro) {
		this.margemLucro = margemLucro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
