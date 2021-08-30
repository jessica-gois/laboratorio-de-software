package model.domain;

import model.domain.enums.TipoEndereco;
import model.domain.enums.TipoLogradouro;
import model.domain.enums.TipoResidencia;

public class Endereco extends EntidadeDominio {
	private Cliente cliente;
	private String descricao;
	private TipoLogradouro tipoLogradouro;
	private String logradouro;
	private String numero;
	private String complemento;
	private TipoResidencia tipoResidencia;
	private String bairro;
	private String cep;	
	private Estado estado;
	private Cidade cidade;
	private String observacao;
	private TipoEndereco tipoEndereco;




	
	public Endereco() {
	}

	
	public Endereco(String descricao, TipoLogradouro tipoLogradouro, String logradouro, String numero,
			String complemento, TipoResidencia tipoResidencia, String bairro, String cep, Estado estado, Cidade cidade,
			String observacao, TipoEndereco tipoEndereco) {
		super();
		this.descricao = descricao;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.tipoResidencia = tipoResidencia;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.observacao = observacao;
		this.tipoEndereco = tipoEndereco;
	}
	
	


	public Endereco(Cliente cliente, String descricao, TipoLogradouro tipoLogradouro, String logradouro, String numero,
			String complemento, TipoResidencia tipoResidencia, String bairro, String cep, Estado estado, Cidade cidade,
			String observacao, TipoEndereco tipoEndereco) {
		super();
		this.cliente = cliente;
		this.descricao = descricao;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.tipoResidencia = tipoResidencia;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.observacao = observacao;
		this.tipoEndereco = tipoEndereco;
	}









	public Cliente getCliente() {
		return cliente;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}




	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}




	public String getLogradouro() {
		return logradouro;
	}




	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public String getComplemento() {
		return complemento;
	}




	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}




	public TipoResidencia getTipoResidencia() {
		return tipoResidencia;
	}




	public void setTipoResidencia(TipoResidencia tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}




	public String getCep() {
		return cep;
	}




	public void setCep(String cep) {
		this.cep = cep;
	}




	public String getBairro() {
		return bairro;
	}




	public void setBairro(String bairro) {
		this.bairro = bairro;
	}




	public Estado getEstado() {
		return estado;
	}




	public void setEstado(Estado estado) {
		this.estado = estado;
	}




	public Cidade getCidade() {
		return cidade;
	}




	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}




	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}




	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}




	public String getObservacao() {
		return observacao;
	}




	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


}
