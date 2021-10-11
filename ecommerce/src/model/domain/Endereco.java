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
	private Cidade cidade;
	private String observacao;
	private TipoEndereco tipoEndereco;
	
	public Endereco() {
	}

	
	public Endereco(String descricao, TipoLogradouro tipoLogradouro, String logradouro, String numero,
			String complemento, TipoResidencia tipoResidencia, String bairro, String cep, Cidade cidade,
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
		this.cidade = cidade;
		this.observacao = observacao;
		this.tipoEndereco = tipoEndereco;
	}
	
	public Endereco(Integer id,String descricao, TipoLogradouro tipoLogradouro, String logradouro, String numero,
			String complemento, TipoResidencia tipoResidencia, String bairro, String cep, Cidade cidade,
			String observacao, TipoEndereco tipoEndereco) {
		super();
		if (id != null) {
			this.setId(id);
		}
		this.descricao = descricao;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.tipoResidencia = tipoResidencia;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.observacao = observacao;
		this.tipoEndereco = tipoEndereco;
	}
	


	public Endereco(Cliente cliente, String descricao, TipoLogradouro tipoLogradouro, String logradouro, String numero,
			String complemento, TipoResidencia tipoResidencia, String bairro, String cep, Cidade cidade,
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

	public String getLabel() {
		StringBuilder label = new StringBuilder();
		if(descricao != null && !descricao.isBlank()) {
			label.append(descricao);
		}
		label.append(" - ");
		if(tipoLogradouro != null && !tipoLogradouro.name().isBlank()) {
			label.append(tipoLogradouro + " ");
		}
		if(logradouro != null && !logradouro.isBlank()) {
			label.append(logradouro);
		}
		label.append(", ");
		if(numero != null && !numero.isBlank()) {
			label.append(numero + ", ");
		}
		if(cidade != null && !cidade.getNome().isBlank()) {
			label.append(cidade.getEstado().getNome()).append(" - ");			
			
			if(cidade.getEstado() != null && !cidade.getEstado().getNome().isBlank()) {
				label.append(cidade.getEstado().getSigla());
			}
		}
		
		if(cep != null && !cep.isBlank()) {
			label.append(", " + cep);
		}
		
		return label.toString();
	}
	
}
