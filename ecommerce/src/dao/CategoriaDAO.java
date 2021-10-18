package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.domain.Categoria;
import model.domain.EntidadeDominio;
import util.Calculadora;

public class CategoriaDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entidade) {
		Categoria categoria = (Categoria) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO categoria (cat_nome) " + 
			"VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);

			setaParametrosQuery(st, categoria.getNome());

			Long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println(
				"Categoria cadastrada com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
	}

	public String alterar(EntidadeDominio entidade) {
		Categoria categoria = (Categoria) entidade;
		System.out.println(categoria.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("UPDATE cupom SET cat_nome = ? "
					+ "WHERE  (cat_id = ?)");

			setaParametrosQuery(st, categoria.getNome(), categoria.getId());

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar";
		}

	}

	public String excluir(EntidadeDominio entidade) {
		Categoria categoria = (Categoria) entidade;
		System.out.println(categoria.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("DELETE FROM categoria " + "WHERE " + "cat_id = ?");
			setaParametrosQuery(st, categoria.getId());

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Categoria excluída com sucesso! Linhas afetadas: " + linhasAfetadas);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao excluir";
		}

	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from categoria where cat_id =?";
		}else {
			return "select * from categoria";
		}
	}

	private PreparedStatement executarPesquisa(Categoria categoria, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (categoria.getPesquisa().equals("id")) {
			setaParametrosQuery(st, categoria.getId());
		}
		return st;
	}

	public List<Categoria> consultar(EntidadeDominio entidade) {
		Categoria categoria = (Categoria) entidade;
		List<Categoria> categorias = new ArrayList();
		System.out.println(categoria);
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(categoria);
			st = executarPesquisa(categoria, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				Categoria catAux = new Categoria(rs.getString("cat_nome"));
				categorias.add(catAux);
			}

			return categorias;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
