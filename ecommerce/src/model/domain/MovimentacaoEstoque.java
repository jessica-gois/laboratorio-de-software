package model.domain;

import java.util.Date;

import model.domain.enums.TipoMovimentacao;

public class MovimentacaoEstoque extends EntidadeDominio {
	private Date data;
	private Double quantidade;
	private Double precoCusto;
	private String fornecedor;
	private TipoMovimentacao tipo;
	private Boolean entrada;
	private EstoqueItem itemEstoque;
	private Livro livro;
	
	public MovimentacaoEstoque() {
		
	}
	

	
	public MovimentacaoEstoque(Integer id, Date dtCadastro, Date data, Double quantidade, Double precoCusto, String fornecedor, 
			TipoMovimentacao tipo, Boolean entrada, EstoqueItem itemEstoque, Livro livro ) {
		super();
		if(id != null) {
			this.setId(id);			
		}
		if(dtCadastro != null) {
			this.setDtCadastro(dtCadastro);
		}
	
		this.data = data;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.fornecedor = fornecedor;
		this.tipo = tipo;
		this.entrada = entrada;
		this.itemEstoque = itemEstoque;	
		this.livro = livro;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public Double getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}



	public Double getPrecoCusto() {
		return precoCusto;
	}



	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}



	public String getFornecedor() {
		return fornecedor;
	}



	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}



	public TipoMovimentacao getTipo() {
		return tipo;
	}



	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}



	public Boolean getEntrada() {
		return entrada;
	}



	public void setEntrada(Boolean entrada) {
		this.entrada = entrada;
	}



	public EstoqueItem getItemEstoque() {
		return itemEstoque;
	}



	public void setItemEstoque(EstoqueItem itemEstoque) {
		this.itemEstoque = itemEstoque;
	}



	public Livro getLivro() {
		return livro;
	}



	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	
		
}
