package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FiltroPesquisaPeriodoGrafico;
import dto.GraficoVendasLivroDTO;
import dto.VendaLivroPeriodoDTO;
import model.domain.EntidadeDominio;
import model.domain.Result;
import util.Conversao;

public class ConsultarGraficoVendasLivroVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		FiltroPesquisaPeriodoGrafico filtroPesquisa = new FiltroPesquisaPeriodoGrafico();
		try {
			Date dataInicial = Conversao.parseStringToDate(request.getParameter("dataInicial"), "yyyy-MM-dd");
			Date dataFinal = Conversao.parseStringToDate(request.getParameter("dataFinal"), "yyyy-MM-dd");
			filtroPesquisa = new FiltroPesquisaPeriodoGrafico(dataInicial, dataFinal);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return filtroPesquisa;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			StringBuilder jsonSimulacao = new StringBuilder();
			jsonSimulacao.append("["); //inicio do array de json que está sendo simulado
			for(EntidadeDominio entidade : resultado.getEntidades()) {
				GraficoVendasLivroDTO dto = (GraficoVendasLivroDTO) entidade;
				jsonSimulacao.append("{\"category\":\"" + dto.getPeriodo() + "\",");
				
				for(VendaLivroPeriodoDTO dadoVendaDto : dto.getDadosVendaLivros()) {
					jsonSimulacao.append("\"" + dadoVendaDto.getTitulo() +"\":" + dadoVendaDto.getQuantidadeTotal());
					
					if(dadoVendaDto != dto.getDadosVendaLivros().get(dto.getDadosVendaLivros().size() - 1)) {
						jsonSimulacao.append(",");
					}else {
						jsonSimulacao.append("}");
					}
				}
				if(entidade != resultado.getEntidades().get(resultado.getEntidades().size() - 1)) {
					jsonSimulacao.append(",");
				}				
			}
			jsonSimulacao.append("]");
			
			System.out.println("Json gerado: " + jsonSimulacao);
			request.getSession().setAttribute("listaDto", resultado.getEntidades());
			request.getSession().setAttribute("dadosGrafico", jsonSimulacao.toString());
			response.sendRedirect(request.getContextPath() + "/view/dashboard.jsp");
		}
	}

}