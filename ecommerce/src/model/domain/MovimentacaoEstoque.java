package model.domain;

import java.sql.Date;

import model.domain.enums.TipoMovimentacao;

public class MovimentacaoEstoque extends EntidadeDominio {
	private Date data;
	private Double quantidade;
	private Double precoCusto;
	private String fornecedor;
	private TipoMovimentacao tipo;
	private Boolean entrada;
	private EstoqueItem itemEstoque;
	
	public MovimentacaoEstoque() {
		
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
	
		
}
