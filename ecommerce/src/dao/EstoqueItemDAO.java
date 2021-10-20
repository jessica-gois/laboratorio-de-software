package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.domain.Cidade;
import model.domain.EntidadeDominio;
import model.domain.EstoqueItem;
import model.domain.GrupoPrecificacao;
import model.domain.enums.Estado;
import util.Calculadora;
import util.Conversao;

public class EstoqueItemDAO extends AbstractDAO {


	public String salvar(EntidadeDominio entidade) {
		EstoqueItem item = (EstoqueItem) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO estoque_item (esi_quantidade, esi_liv_id) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			setaParametrosQuery(st, item.getQuantidade(), item.getLivro().getId());

			Long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println(
					"Estoque item cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
							+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
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
	
	public EstoqueItem getEstoqueItemById(Integer estoqueId) {
		EstoqueItem item = new EstoqueItem();
		System.out.println("Buscando item id:" + estoqueId);
		inicializarConexao();
		LivroDAO livroDAO = new LivroDAO();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("SELECT * FROM estoque_item WHERE esi_id = ? LIMIT 1");
			setaParametrosQuery(st, estoqueId);
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				item = new EstoqueItem(rs.getInt("esi_id"), 
				Conversao.parseStringToDate(rs.getString("esi_dtCadastro"), "yyyy-MM-dd"),	
				rs.getDouble ("esi_quantidade"),
				livroDAO.getLivroById(rs.getInt("esi_liv_id")));
			}
							
			return item;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
