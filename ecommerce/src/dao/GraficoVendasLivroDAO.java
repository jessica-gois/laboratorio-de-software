package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.GraficoVendasLivroDTO;
import dto.VendaLivroPeriodoDTO;
import model.domain.Cidade;
import model.domain.EntidadeDominio;
import model.domain.enums.Estado;
import util.Calculadora;

public class GraficoVendasLivroDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		return null;
	}

	@Override
	public List<GraficoVendasLivroDTO> consultar(EntidadeDominio entidade) {
		List<VendaLivroPeriodoDTO> listaDto = new ArrayList<VendaLivroPeriodoDTO>();
		List<GraficoVendasLivroDTO> listaGraficoDto = new ArrayList<GraficoVendasLivroDTO>();
		GraficoVendasLivroDTO graficoDto;
		FiltroPesquisaPeriodoGrafico filtroPesquisa =(FiltroPesquisaPeriodoGrafico) entidade;
		boolean adicionado;
		inicializarConexao();
		
		try {
			conn = Database.conectarBD();
			StringBuilder sql = new StringBuilder("select liv_titulo as titulo, DATE_FORMAT(CAST(ped_dtCadastro AS DATE), '%m/%Y') "+
				"as periodo, sum(pei_quantidade) as quantidadeTotal, sum(pei_quantidade * pei_valorunitario) as valorTotal " + 
				"from pedido_item join livro on liv_id = pei_liv_id " + 
				"join pedido on ped_id = pei_ped_id ");			
			sql.append("and ped_status like 'ENTREGUE' ");
			
			if (filtroPesquisa.getDataInicial() != null) {
				sql.append("and CAST(ped_dtCadastro AS DATE) >= ? ");
			}
			
			if (filtroPesquisa.getDataFinal() != null) {
				sql.append("and CAST(ped_dtCadastro AS DATE) <= ? ");
			}
			sql.append("group by liv_titulo, periodo order by YEAR (CAST(ped_dtCadastro AS DATE)), MONTH (CAST(ped_dtCadastro AS DATE))," +
				"CAST(ped_dtCadastro AS DATE) asc");
			
			st = conn.prepareStatement(sql.toString()) ;
			setaParametrosQuery(st, filtroPesquisa.getDataInicial(), filtroPesquisa.getDataFinal());
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				VendaLivroPeriodoDTO dto = new VendaLivroPeriodoDTO(rs.getString("titulo"), rs.getString("periodo") ,
					rs.getDouble("quantidadeTotal"), rs.getDouble("valorTotal"));
				listaDto.add(dto);
			}
			
			for(VendaLivroPeriodoDTO vendaLivroDto : listaDto){
				adicionado = false;
				graficoDto = new GraficoVendasLivroDTO();
				if(listaGraficoDto.size() == 0){
					graficoDto = new GraficoVendasLivroDTO(vendaLivroDto);
					listaGraficoDto.add(graficoDto);
				}else{
					for(GraficoVendasLivroDTO itemGrafico : listaGraficoDto){
						if(itemGrafico.getPeriodo().equals(vendaLivroDto.getPeriodo())){
							itemGrafico.getDadosVendaLivros().add(vendaLivroDto);
							adicionado = true;
							break;
						}
					}
					if(!adicionado){
						graficoDto.getDadosVendaLivros().add(vendaLivroDto);
						graficoDto.setPeriodo(vendaLivroDto.getPeriodo());
						listaGraficoDto.add(graficoDto);
					}
				}
			}
			
			
			return listaGraficoDto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
