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

import model.domain.Cupom;
import model.domain.EntidadeDominio;
import model.domain.enums.TipoCupom;
import util.Calculadora;

public class CupomDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entidade) {
		Cupom cupom = (Cupom) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO cupom (cup_nome, cup_codigo, cup_valor, cup_validade, cup_tipo) " + 
			"VALUES (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			setaParametrosQuery(st, cupom.getNome(), cupom.getCodigo(),cupom.getValor(),
					cupom.getValidade(), cupom.getTipo().name());

			Long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println(
				"Cupom cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
	}

	public String alterar(EntidadeDominio entidade) {
		Cupom cupom = (Cupom) entidade;
		System.out.println(cupom.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("UPDATE cupom SET cup_nome = ? , cup_codigo = ? , cup_valor = ? ,"
					+ "cup_validade = ?, cup_tipo = ?  WHERE  (cup_id = ?)");

			setaParametrosQuery(st, cupom.getNome(), cupom.getCodigo(), cupom.getValor(),
					cupom.getValidade(), cupom.getTipo().name(), cupom.getId());

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar";
		}

	}

	public String excluir(EntidadeDominio entidade) {
		Cupom cupom = (Cupom) entidade;
		System.out.println(cupom.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("DELETE FROM cupom " + "WHERE " + "cup_id = ?");
			setaParametrosQuery(st, cupom.getId());

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Cupom excluído com sucesso! Linhas afetadas: " + linhasAfetadas);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao excluir";
		}

	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from cupom where cup_id =?";
		}else if(entidade.getPesquisa().equals("validadeAtiva")){
			return "select * from cupom where cup_validade >= ?";
		}else {
			return "select * from cupom";
		}
	}

	private PreparedStatement executarPesquisa(Cupom cupom, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (cupom.getPesquisa().equals("id")) {
			setaParametrosQuery(st, cupom.getId());
		}else if(cupom.getPesquisa().equals("validadeAtiva")) {
			setaParametrosQuery(st, new Date());
		}
		return st;
	}

	public List<Cupom> consultar(EntidadeDominio entity) {
		Cupom cupom = (Cupom) entity;
		List<Cupom> cupons = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(cupom);
		inicializarConexao();
		try {//
			String sql = pesquisarAuxiliar(cupom);
			st = executarPesquisa(cupom, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			//Integer id, Date dtCadastro, String nome, String codigo, TipoCupom tipo, Double valor, Date validade
			//(cup_nome, cup_codigo, cup_valor, cup_validade, cup_tipo) sdf.parse
			while (rs.next()) {
				Cupom cupomAux = new Cupom(rs.getInt("cup_id"), rs.getString("cup_nome"), rs.getString("cup_codigo"),
					TipoCupom.valueOf(rs.getString("cup_tipo")), rs.getDouble("cup_valor"), sdf.parse(rs.getString("cup_validade")));
				cupons.add(cupomAux);
			}

			return cupons;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
