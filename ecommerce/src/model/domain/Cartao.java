package model.domain;

import model.domain.enums.Bandeira;

public class Cartao extends EntidadeDominio{
	private Cliente cliente;
	private String numero;
	private Bandeira bandeira;
	private String nomeImpresso;
	private String codigoSeguranca;
	private Boolean preferencial;
	
	public Cartao() {
	}

	public Cartao(String numero, Bandeira bandeira, String nomeImpresso, String codigoSeguranca,
		Boolean preferencial, Cliente cliente) {
		this.numero = numero;
		this.bandeira = bandeira;
		this.nomeImpresso = nomeImpresso;
		this.codigoSeguranca = codigoSeguranca;
		this.preferencial = preferencial;
		this.cliente = cliente;
	}
	
	public Cartao(Integer id, String numero, Bandeira bandeira, String nomeImpresso, String codigoSeguranca,
			Boolean preferencial, Cliente cliente) {
			this.setId(id);
			this.numero = numero;
			this.bandeira = bandeira;
			this.nomeImpresso = nomeImpresso;
			this.codigoSeguranca = codigoSeguranca;
			this.preferencial = preferencial;
			this.cliente = cliente;
		}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public String getNomeImpresso() {
		return nomeImpresso;
	}

	public void setNomeImpresso(String nomeImpresso) {
		this.nomeImpresso = nomeImpresso;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public Boolean getPreferencial() {
		return preferencial;
	}

	public void setPreferencial(Boolean preferencial) {
		this.preferencial = preferencial;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bandeira == null) ? 0 : bandeira.hashCode());
		result = prime * result + ((codigoSeguranca == null) ? 0 : codigoSeguranca.hashCode());
		result = prime * result + ((nomeImpresso == null) ? 0 : nomeImpresso.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((preferencial == null) ? 0 : preferencial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		if (bandeira != other.bandeira)
			return false;
		if (codigoSeguranca == null) {
			if (other.codigoSeguranca != null)
				return false;
		} else if (!codigoSeguranca.equals(other.codigoSeguranca))
			return false;
		if (nomeImpresso == null) {
			if (other.nomeImpresso != null)
				return false;
		} else if (!nomeImpresso.equals(other.nomeImpresso))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (preferencial == null) {
			if (other.preferencial != null)
				return false;
		} else if (!preferencial.equals(other.preferencial))
			return false;
		return true;
	}
	
	
	

}