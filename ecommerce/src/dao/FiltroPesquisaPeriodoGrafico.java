package dao;

import java.util.Date;

import model.domain.EntidadeDominio;

public class FiltroPesquisaPeriodoGrafico extends EntidadeDominio {
	Date dataInicial;
	Date dataFinal;
	
	public FiltroPesquisaPeriodoGrafico() {
		
	}
	
	public FiltroPesquisaPeriodoGrafico(Date dataInicial, Date dataFinal) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
}
