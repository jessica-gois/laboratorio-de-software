package model.domain;

import java.sql.Date;

import model.domain.enums.TipoCupom;
import model.domain.enums.TipoEndereco;

public class Cupom extends EntidadeDominio{
	private String nome;
	private String codigo;
	private TipoCupom tipo;
	private Double valor;
	private Date validade;
	
	public Cupom() {
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public TipoCupom getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoCupom tipo) {
		this.tipo = tipo;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Date getValidade() {
		return validade;
	}
	
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
}
