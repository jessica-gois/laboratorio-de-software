package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.Database;
import model.domain.Cartao;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Usuario;
import util.Calculadora;

public class ClienteDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> consultar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		List<Cliente> clientes = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(cliente);
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(cliente);
			st = executarPesquisa(cliente, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			
			while (rs.next()) {
				Cliente clienteAux = new Cliente(rs.getInt("cli_id"), rs.getString("cli_nome"),
						rs.getString("cli_sobrenome"), rs.getString("cli_genero"),
						sdf.parse(rs.getString("cli_datanascimento")), rs.getString("cli_cpf"), rs.getInt("cli_score"),
						new Usuario());
				cliente.getUsuario().setId(rs.getInt("cli_usu_id"));
				clientes.add(clienteAux);
			}

			return clientes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from cliente  WHERE cli_id = ?";
		} else if(entidade.getPesquisa().equals("usuario")){
			return "select * from cliente  WHERE cli_usu_id = ?";
		} {
			return "select * from cliente";
		}
	}

	private PreparedStatement executarPesquisa(Cliente cliente, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (cliente.getPesquisa().equals("id")) {
			setaParametrosQuery(st, cliente.getId());
		} else if (cliente.getPesquisa().equals("usuario")) {
			setaParametrosQuery(st, cliente.getUsuario().getId());
		}
		return st;
	}
}
