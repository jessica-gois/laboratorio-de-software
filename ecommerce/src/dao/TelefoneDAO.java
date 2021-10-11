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
import model.domain.Telefone;
import model.domain.enums.Bandeira;
import model.domain.enums.Estado;
import model.domain.enums.TipoTelefone;
import util.Calculadora;
import util.Conversao;

public class TelefoneDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entidade) {
		Telefone telefone = (Telefone) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO telefone "
					+ "(tel_ddd, tel_numero, tel_cli_id, tel_tip_id) VALUES (?, ?,(SELECT MAX(cli_id) FROM cliente), ?)",
					Statement.RETURN_GENERATED_KEYS);

			setaParametrosQuery(st, telefone.getDdd(), telefone.getNumero(), telefone.getTipoTelefone().getCodigo());

			Long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println(
					"Telefone cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
							+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
	}

	public String alterar(EntidadeDominio entidade) {
		Telefone telefone = (Telefone) entidade;
		System.out.println(telefone.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			
			st = conn.prepareStatement("UPDATE telefone SET tel_ddd = ?, "
					+ "tel_numero = ? WHERE tel_id = ?");
			
			setaParametrosQuery(st, telefone.getDdd(), telefone.getNumero(), telefone.getId());

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar";
		}
		
	}

	public String excluir(EntidadeDominio entidade) {
		return null;
	}
	
	public List<Cidade> consultar(EntidadeDominio entidade) {
		return null;
	}
	
	public Telefone getTelefoneByCliente(Integer clienteId, TipoTelefone tipo) {
		Telefone telefone = new Telefone();
		inicializarConexao();
		System.out.println("Buscando telefone residencial do cliente:" + clienteId);
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("SELECT * FROM telefone WHERE tel_cli_id = ? and tel_tip_id = ? LIMIT 1");
			setaParametrosQuery(st, clienteId, tipo.getCodigo());
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				telefone = new Telefone( rs.getInt("tel_id"), rs.getString("tel_ddd"), rs.getString("tel_numero"),
				TipoTelefone.getByCodigo(rs.getInt("tel_tip_id")));
			}
			
			return telefone;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
