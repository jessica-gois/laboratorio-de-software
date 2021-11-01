package dto;

import java.util.ArrayList;
import java.util.List;

import model.domain.EntidadeDominio;

public class GraficoVendasLivroDTO extends EntidadeDominio {
	private static final long serialVersionUID = 1L;
	private String periodo; // categoria do gráfico
	private List<VendaLivroPeriodoDTO> dadosVendaLivros = new ArrayList<VendaLivroPeriodoDTO>();

	 public GraficoVendasLivroDTO() {
	 }
	 
	 public GraficoVendasLivroDTO(VendaLivroPeriodoDTO vendaLivroDto) {
		 if(vendaLivroDto != null) {
		 this.periodo = vendaLivroDto.getPeriodo();
		 this.getDadosVendaLivros().add(vendaLivroDto);
		 }
	 }
	
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public List<VendaLivroPeriodoDTO> getDadosVendaLivros() {
		return dadosVendaLivros;
	}
	public void setDadosFaturamentoLivros(List<VendaLivroPeriodoDTO> dadosVendaLivros) {
		this.dadosVendaLivros = dadosVendaLivros;
	}	
	
	public Double getValorTotalVendasPeriodo() {
		Double valorTotal = 0d;
		if(dadosVendaLivros != null) {
			for(VendaLivroPeriodoDTO dto : dadosVendaLivros) {
				valorTotal += dto.getValorTotal();
			}
		}
		return valorTotal;
	}
	
	public Double getQuantidadeTotalVendasPeriodo() {
		Double qtdTotal = 0d;
		if(dadosVendaLivros != null) {
			for(VendaLivroPeriodoDTO dto : dadosVendaLivros) {
				qtdTotal += dto.getQuantidadeTotal();
			}
		}
		return qtdTotal;
	}
	
}
