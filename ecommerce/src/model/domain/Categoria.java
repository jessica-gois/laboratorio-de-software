package model.domain;

public class Categoria extends EntidadeDominio{
	private String nome;
	
	public Categoria() {
	}
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
