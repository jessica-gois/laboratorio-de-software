package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.domain.Cartao;
import model.domain.Cidade;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.GrupoPrecificacao;
import model.domain.enums.Bandeira;
import model.domain.enums.Estado;
import util.Calculadora;
import util.Conversao;

public class GrupoPrecificacaoDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entidade) {
		GrupoPrecificacao grupo = (GrupoPrecificacao) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO grupo_precificacao (gru_descricao, gru_margemLucro) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			setaParametrosQuery(st, grupo.getDescricao(), grupo.getMargemLucro());

			Long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println(
					"Grupo de precificação cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
							+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
	}

	public String alterar(EntidadeDominio entidade) {
		GrupoPrecificacao grupo = (GrupoPrecificacao) entidade;
		System.out.println(grupo.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("UPDATE grupo_precificacao SET gru_descricao = ?, gru_margemLucro = ? "
				+ "WHERE (gru_id = ?)");

			setaParametrosQuery(st, grupo.getDescricao(), grupo.getMargemLucro(), grupo.getId());
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar";
		}
	}

	public String excluir(EntidadeDominio entidade) {
		GrupoPrecificacao grupo = (GrupoPrecificacao) entidade;
		System.out.println(grupo.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("DELETE FROM grupo_precificacao WHERE gru_id = ?");
			setaParametrosQuery(st, grupo.getId());

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Grupo de precificação excluído com sucesso! Linhas afetadas: " + linhasAfetadas);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao excluir";
		}
	}
	
	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from grupo_precificacao where gru_id =?";
		}else{
			return "select * from grupo_precificacao";
		}
	}
	
	private PreparedStatement executarPesquisa(GrupoPrecificacao grupo, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (grupo.getPesquisa().equals("id")) {
			setaParametrosQuery(st, grupo.getId());
		}
		return st;
	}
	
	
	public List<GrupoPrecificacao> consultar(EntidadeDominio entidade) {
		GrupoPrecificacao grupo = (GrupoPrecificacao) entidade;
		List<GrupoPrecificacao> grupos = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("");
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(grupo);
			st = executarPesquisa(grupo, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				GrupoPrecificacao grupoAux = new 
					GrupoPrecificacao(rs.getInt("gru_id"), rs.getString("gru_descricao"), rs.getDouble("gru_margemLucro"), 
					Conversao.parseStringToDate(rs.getString("gru_dtCadastro"), "yyyy-MM-dd"));
				grupos.add(grupoAux);
			}

			return grupos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public GrupoPrecificacao getGrupoPrecificacaoById(Integer grupoId) {
		GrupoPrecificacao grupo = new GrupoPrecificacao();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		inicializarConexao();
		
		System.out.println("Buscando grupo de precificação id:" + grupoId);
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("SELECT * FROM grupo_precificacao WHERE gru_id = ? LIMIT 1");
			setaParametrosQuery(st, grupoId);
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				grupo = new GrupoPrecificacao(rs.getInt("gru_id"), rs.getString("gru_descricao"), rs.getDouble("gru_margemLucro"),
				sdf.parse(rs.getString("gru_dtCadastro")));
			}
			
			return grupo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
