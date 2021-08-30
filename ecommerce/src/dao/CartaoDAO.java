package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import model.domain.Cartao;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.enums.Bandeira;
import util.Calculadora;

public class CartaoDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entityDomain) {
		Cartao cartao = (Cartao) entityDomain;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO cartao "
					+ "(car_numero, car_nome, car_cvv, car_preferencial, car_ban_id, car_cli_id) " + "VALUES " + "(?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			setaParametrosQuery(st, cartao.getNumero(), cartao.getNomeImpresso(), cartao.getCodigoSeguranca(),
					cartao.getPreferencial(), cartao.getBandeira().getCodigo(), cartao.getCliente().getId());

			Long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println(
					"Cartão cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
							+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
	}

	public String alterar(EntidadeDominio entidade) {
		Cartao cartao = (Cartao) entidade;
		System.out.println(cartao.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("UPDATE cartao " + "SET car_numero = ? ," + "car_nome = ? ," + "car_cvv = ? ,"
					+ "car_preferencial = ?" + "car_ban_id = ? " + "WHERE " + "(car_id = ?)");

			setaParametrosQuery(st, cartao.getNumero(), cartao.getNomeImpresso(), cartao.getCodigoSeguranca(),
					cartao.getPreferencial(), cartao.getBandeira().getCodigo(), cartao.getId());

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar";
		}

	}

	public String excluir(EntidadeDominio entidade) {
		Cartao cartao = (Cartao) entidade;
		System.out.println(cartao.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("DELETE FROM cartao " + "WHERE " + "car_id = ?");
			setaParametrosQuery(st, cartao.getId());

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Cartão excluído com sucesso! Linhas afetadas: " + linhasAfetadas);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao excluir";
		}

	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from cartao  WHERE car_id =?";
		} else {
			return "select * from cartao";
		}
	}

	private PreparedStatement executarPesquisa(Cartao cartao, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (cartao.getPesquisa().equals("id")) {
			setaParametrosQuery(st, cartao.getId());
		}
		return st;
	}

	public List<Cartao> consultar(EntidadeDominio entity) {
		Cartao cartao = (Cartao) entity;
		List<Cartao> cartoes = new ArrayList();
		System.out.println(cartao);
		Connection conn = null;
		PreparedStatement st = null;
		try {
			String sql = pesquisarAuxiliar(cartao);
			st = executarPesquisa(cartao, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				Cartao cartaoAux = new Cartao(rs.getInt("car_id"), rs.getString("car_numero"),
						Bandeira.getByCodigo(rs.getInt("car_ban_id")), rs.getString("car_nome"),
						rs.getString("car_cvv"), rs.getBoolean("car_preferencial"));
				cartoes.add(cartaoAux);
			}

			return cartoes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
