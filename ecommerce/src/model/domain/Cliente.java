package model.domain;


import java.util.Date;




public class Cliente extends Usuario{
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String ddd;
	private String numeroTelefone;
	private String tipoTelefone;
	private String genero;
	private Date dataNascimento;
	private String cpf;
	private Integer score;
	private Boolean status;
	

	public Cliente() {
		
	}


	public Cliente(Integer id, String nome, String sobrenome, String ddd, String numeroTelefone, String tipoTelefone,
			String genero, Date dataNascimento, String cpf, Integer score, Boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.ddd = ddd;
		this.numeroTelefone = numeroTelefone;
		this.tipoTelefone = tipoTelefone;
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




	public String getDdd() {
		return ddd;
	}




	public void setDdd(String ddd) {
		this.ddd = ddd;
	}




	public String getNumeroTelefone() {
		return numeroTelefone;
	}




	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}




	public String getTipoTelefone() {
		return tipoTelefone;
	}




	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
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