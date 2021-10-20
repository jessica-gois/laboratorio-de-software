package model.domain;

import java.util.Date;

public class EstoqueItem extends EntidadeDominio{
	private Livro livro;
	private Double quantidade;

	
	
	public EstoqueItem() {
	}
	
	
	public EstoqueItem(Integer id, Date dtCadastro, Double quantidade, Livro livro) {
		super();
		if(id != null) {
			this.setId(id);			
		}
		if(dtCadastro != null) {
			this.setDtCadastro(dtCadastro);
		}
	
		this.quantidade = quantidade;
		this.livro = livro;
	}
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
			
}
