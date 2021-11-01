package dto;

import util.Conversao;

public class VendaLivroPeriodoDTO {
	
	private String titulo;
	private String periodo;  // categoria do gráfico
	private Integer quantidadeTotal;
	private Double valorTotal;
	
	public VendaLivroPeriodoDTO() {
		
	}

	public VendaLivroPeriodoDTO(String titulo, String periodo, Double quantidadeTotal, Double valorTotal) {
		super();
		this.titulo = titulo;
		this.periodo = periodo;
		this.quantidadeTotal = Conversao.parseDoubleToInteger(quantidadeTotal);
		this.valorTotal = valorTotal;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Integer getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Integer quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
