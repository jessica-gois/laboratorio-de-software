package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.domain.EntidadeDominio;
import model.domain.MovimentacaoEstoque;
import model.domain.enums.TipoMovimentacao;
import util.Calculadora;
import util.Conversao;

public class MovimentacaoEstoqueDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entidade) {
		MovimentacaoEstoque movimentacao = (MovimentacaoEstoque) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO movimentacao_estoque (mov_data, mov_quantidade, mov_precoCusto, "
					+ "mov_fornecedor, mov_entrada, mov_tipo, mov_liv_id)" + 
			"VALUES (?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			setaParametrosQuery(st, movimentacao.getData(), movimentacao.getQuantidade(), movimentacao.getPrecoCusto(),
								movimentacao.getFornecedor(),movimentacao.getEntrada(), movimentacao.getTipo().name(), 
								movimentacao.getLivro().getId()); 
					
			Long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println(
					"Movimentação cadastrada com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
							+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
	}

	public String alterar(EntidadeDominio entidade) {
		MovimentacaoEstoque movimentacao = (MovimentacaoEstoque) entidade;
		System.out.println(movimentacao.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();

			st = conn.prepareStatement("UPDATE movimentacao_estoque SET mov_quantidade = ?"
					+ "WHERE (mov_id = ?)"); 

			setaParametrosQuery(st, movimentacao.getQuantidade(), movimentacao.getId());

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar";
		}

	}


	public String excluir(EntidadeDominio entidade) {
		MovimentacaoEstoque movimentacao = (MovimentacaoEstoque) entidade;
		System.out.println(movimentacao.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("DELETE FROM movimentacao_estoque WHERE mov_id = ?");
			setaParametrosQuery(st, movimentacao.getId());

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Movimentação excluída com sucesso! Linhas afetadas: " + linhasAfetadas);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao excluir";
		}
	}
	
	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa() != null && entidade.getPesquisa().equals("id")) {
			return "select * from movimentacao_estoque where mov_id =?";
		}else if (entidade.getPesquisa() != null && entidade.getPesquisa().equals("filtros")){
			MovimentacaoEstoque mov = (MovimentacaoEstoque) entidade;
			StringBuilder sql = new StringBuilder();
			sql.append("select * from movimentacao_estoque ");
			
			if(mov.getLivro() != null) {
				sql.append("join livro on liv_id = mov_liv_id and liv_titulo like ? ");
			}
			
			if(mov.getData() != null || mov.getTipo() != null || mov.getLivro() != null || mov.getQuantidade() != null
				|| mov.getFornecedor() != null || mov.getPrecoCusto() != null) {
				sql.append("where mov_liv_id is not null ");
			}
			
			if(mov.getData() != null) {
				sql.append("and mov_data = ? ");
			}
			
			if(mov.getTipo() != null) {
				sql.append("and mov_tipo = ? ");
			}
			
			if(mov.getQuantidade() != null) {
				sql.append("and mov_quantidade = ? ");
			}
			
			if(mov.getFornecedor() != null) {
				sql.append("and mov_fornecedor like ? ");
			}
			
			if(mov.getPrecoCusto() != null) {
				sql.append("and mov_precoCusto = ? ");
			}			
			
			return sql.toString();
		
		}else {
			return "select * from movimentacao_estoque";
		}
	}
	
	private PreparedStatement executarPesquisa(MovimentacaoEstoque movimentacao, String sql) throws SQLException, ParseException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		
		if (movimentacao.getPesquisa() != null && movimentacao.getPesquisa().equals("id")) {
			setaParametrosQuery(st, movimentacao.getId());
		}else if (movimentacao.getPesquisa() != null && movimentacao.getPesquisa().equals("filtros")) {
			String filtroLivro = movimentacao.getLivro() != null && movimentacao.getLivro().getTitulo() != null ?
				"%" + movimentacao.getLivro().getTitulo().trim() + "%" : null;
			
			String filtroTipo = movimentacao.getTipo() != null ? movimentacao.getTipo().name() : null;
			
			String filtroFornecedor = movimentacao.getFornecedor() != null && movimentacao.getFornecedor() != null ?
					"%" + movimentacao.getFornecedor().trim() + "%" : null;
						
			setaParametrosQuery(st, filtroLivro, movimentacao.getData(), filtroTipo, movimentacao.getQuantidade(),
				filtroFornecedor, movimentacao.getPrecoCusto());
		}
		return st;
	}
	
	
	public List<MovimentacaoEstoque> consultar(EntidadeDominio entidade) {
		MovimentacaoEstoque movimentacao = (MovimentacaoEstoque) entidade;
		List<MovimentacaoEstoque> movimentacoes = new ArrayList();
		inicializarConexao();
		EstoqueItemDAO itemDAO = new EstoqueItemDAO();
		LivroDAO livroDAO = new LivroDAO();
		try {
			String sql = pesquisarAuxiliar(movimentacao);
			st = executarPesquisa(movimentacao, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
					MovimentacaoEstoque movimentacaoAux = new 
					MovimentacaoEstoque(rs.getInt("mov_id"),  
					Conversao.parseStringToDate(rs.getString("mov_dtCadastro"), "yyyy-MM-dd"),
					Conversao.parseStringToDate(rs.getString("mov_data"), "yyyy-MM-dd"),
					rs.getDouble ("mov_quantidade"),
					rs.getDouble ("mov_precoCusto"),
					rs.getString ("mov_fornecedor"),
					TipoMovimentacao.valueOf(rs.getString("mov_tipo")),
					rs.getBoolean ("mov_entrada"),				
					itemDAO.getEstoqueItemById(rs.getInt("mov_esi_id")),
					livroDAO.getLivroById(rs.getInt("mov_liv_id"))
					);
					movimentacoes.add(movimentacaoAux);
			}
			return movimentacoes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public MovimentacaoEstoque getMovimentacaoById(Integer movimentacaoId) {
		MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
		inicializarConexao();
		EstoqueItemDAO itemDAO = new EstoqueItemDAO();
		LivroDAO livroDAO = new LivroDAO();
		
		System.out.println("Buscando categoria id:" + movimentacaoId);
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("SELECT * FROM movimentacao_estoque WHERE mov_id = ? LIMIT 1");
			setaParametrosQuery(st, movimentacaoId);
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");		
			while (rs.next()) {
				movimentacao = new MovimentacaoEstoque(
				rs.getInt("mov_id"),  
				Conversao.parseStringToDate(rs.getString("mov_dtCadastro"), "yyyy-MM-dd"),
				Conversao.parseStringToDate(rs.getString("mov_data"), "yyyy-MM-dd"),
				rs.getDouble ("mov_quantidade"),
				rs.getDouble ("mov_precoCusto"),
				rs.getString ("mov_fornecedor"),
				TipoMovimentacao.valueOf(rs.getString("mov_tipo")),
				rs.getBoolean ("mov_entrada"),				
				itemDAO.getEstoqueItemById(rs.getInt("mov_esi_id")),
				livroDAO.getLivroById(rs.getInt("mov_liv_id"))
				);			
			}					
			return movimentacao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
