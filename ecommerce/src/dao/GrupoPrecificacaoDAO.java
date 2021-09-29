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
import model.domain.GrupoPrecificacao;
import model.domain.enums.Bandeira;
import model.domain.enums.Estado;
import util.Calculadora;

public class GrupoPrecificacaoDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entidade) {
		return null;
	}

	public String alterar(EntidadeDominio entidade) {
		return null;
	}

	public String excluir(EntidadeDominio entidade) {
		return null;
	}
	
	public List<GrupoPrecificacao> consultar(EntidadeDominio entidade) {
		return null;
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
