package dao;

import java.sql.ResultSet;
import java.util.List;

import model.domain.Cidade;
import model.domain.EntidadeDominio;
import model.domain.enums.Estado;
import util.Calculadora;

public class EstoqueItemDAO extends AbstractDAO {

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
	public <T extends EntidadeDominio> List<T> consultar(EntidadeDominio entidade) {
		return null;
	}
	
	public Double getQuantidadeEstoqueLivro(Integer livroId) {
		Double quantidadeEstoque = 0d;
		System.out.println("Buscando quantidade em estoque do livro id:" + livroId);
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("SELECT esi_quantidade FROM estoque_item WHERE esi_liv_id = ? LIMIT 1");
			setaParametrosQuery(st, livroId);
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				quantidadeEstoque = rs.getDouble("esi_quantidade");
			}
			
			return quantidadeEstoque;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
