package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.domain.Cartao;
import model.domain.Cidade;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.enums.Bandeira;
import model.domain.enums.Estado;
import util.Calculadora;

public class CidadeDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entidade) {
		return null;
	}

	public String alterar(EntidadeDominio entidade) {
		return null;
	}

	public String excluir(EntidadeDominio entidade) {
		return null;
	}
	
	public List<Cidade> consultar(EntidadeDominio entidade) {
		return null;
	}
	
	public Cidade getCidadeById(Integer cidadeId) {
		Cidade cidade = new Cidade();
		System.out.println("Buscando cidade id:" + cidadeId);
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("SELECT * FROM cidade WHERE cid_id = ? LIMIT 1");
			setaParametrosQuery(st, cidadeId);
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				cidade = new Cidade(rs.getInt("cid_id"), rs.getString("cid_nome"),
				Estado.getByCodigo(rs.getInt("cid_est_id")));
			}
			
			return cidade;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
