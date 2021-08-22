package model.domain;


import java.util.Date;




public class Cliente extends Usuario{
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String dddResidencial;
	private String numeroTelResidencial;
	private String dddCelular;
	private String numeroTelCelular;
	private String genero;
	private Date dataNascimento;
	private String cpf;
	private Integer score;
	private Boolean status;
	

	public Cliente() {
		
	}



	public Cliente(Integer id, String nome, String sobrenome, String dddResidencial, String numeroTelResidencial,
			String dddCelular, String numeroTelCelular, String genero, Date dataNascimento, String cpf, Integer score,
			Boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dddResidencial = dddResidencial;
		this.numeroTelResidencial = numeroTelResidencial;
		this.dddCelular = dddCelular;
		this.numeroTelCelular = numeroTelCelular;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.score = score;
		this.status = status;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}



	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}



	public String getDddResidencial() {
		return dddResidencial;
	}



	public void setDddResidencial(String dddResidencial) {
		this.dddResidencial = dddResidencial;
	}



	public String getNumeroTelResidencial() {
		return numeroTelResidencial;
	}



	public void setNumeroTelResidencial(String numeroTelResidencial) {
		this.numeroTelResidencial = numeroTelResidencial;
	}



	public String getDddCelular() {
		return dddCelular;
	}



	public void setDddCelular(String dddCelular) {
		this.dddCelular = dddCelular;
	}



	public String getNumeroTelCelular() {
		return numeroTelCelular;
	}



	public void setNumeroTelCelular(String numeroTelCelular) {
		this.numeroTelCelular = numeroTelCelular;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Integer getScore() {
		return score;
	}



	public void setScore(Integer score) {
		this.score = score;
	}



	public Boolean getStatus() {
		return status;
	}



	public void setStatus(Boolean status) {
		this.status = status;
	}



}