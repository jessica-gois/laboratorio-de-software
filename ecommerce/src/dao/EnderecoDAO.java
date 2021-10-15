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
import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Telefone;
import model.domain.enums.Bandeira;
import model.domain.enums.TipoEndereco;
import model.domain.enums.TipoLogradouro;
import model.domain.enums.TipoResidencia;
import model.domain.enums.TipoTelefone;
import util.Calculadora;

public class EnderecoDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			StringBuilder sql = new StringBuilder("INSERT INTO endereco (end_descricao,"
					+ " end_tipologradouro, end_logradouro, end_numero");
				if(endereco.getComplemento() != null && endereco.getComplemento() != "") {
					sql.append(", end_complemento");
				}
				sql.append(", end_tiporesidencia, end_cep, end_bairro, end_tipo,"); 
				if(endereco.getObservacao() != null && endereco.getObservacao() != "") {
					sql.append(" end_observacao,");
				}
				sql.append(" end_cli_id, end_cid_id) VALUES(");
				
				if(endereco.getComplemento() != null && endereco.getComplemento() != "") {
					sql.append("?,");
				}
				if(endereco.getObservacao() != null && endereco.getObservacao() != "") {
					sql.append("?,");
				}
				sql.append(" ?, ?, ?, ?, ?, ?, ?, ?, ?, " + 
				"(SELECT cid_id FROM cidade WHERE cid_nome like ? AND cid_est_id = ? LIMIT 1 ))");
				
				st = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

				setaParametrosQuery(st, endereco.getDescricao(), endereco.getTipoLogradouro().name(), endereco.getLogradouro(),
					endereco.getNumero(), endereco.getComplemento(), endereco.getTipoResidencia().name(), endereco.getCep(),
					endereco.getBairro(), endereco.getTipoEndereco().name(), endereco.getObservacao(), endereco.getCliente().getId(),
					endereco.getCidade().getNome(),
					endereco.getCidade().getEstado().getCodigo());

			Long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println(
					"Endereço cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
							+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
	}

	public String alterar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco) entidade;
		System.out.println(endereco.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			StringBuilder sql = new StringBuilder("UPDATE endereco SET end_descricao = ?, "
					+ "end_tipologradouro = ?, end_logradouro = ?, end_numero = ?,");
			
			if(endereco.getComplemento() != null && endereco.getComplemento() != "") {
				sql.append(" end_complemento = ?,");
			}
			sql.append(" end_tiporesidencia = ?, end_cep = ?, end_bairro = ?, end_tipo = ?,");
			
			if(endereco.getObservacao() != null && endereco.getObservacao() != "") {
				sql.append(" end_observacao = ?");
			}
			
			sql.append(", end_cid_id = (SELECT cid_id FROM cidade WHERE cid_nome like ? AND cid_est_id = ? LIMIT 1 ) WHERE end_id = ?");
	
			st = conn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			
			setaParametrosQuery(st, endereco.getDescricao(), endereco.getTipoLogradouro().name(), endereco.getLogradouro(),
				endereco.getNumero(), endereco.getComplemento(), endereco.getTipoResidencia().name(), endereco.getCep(),
				endereco.getBairro(), endereco.getTipoEndereco().name(), endereco.getObservacao(), endereco.getCidade().getNome(),
				endereco.getCidade().getEstado().getCodigo(), endereco.getId());

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar";
		}

	}

	public String excluir(EntidadeDominio entidade) {
		Endereco endereco = (Endereco) entidade;
		System.out.println(endereco.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("DELETE FROM endereco WHERE end_id = ?");
			setaParametrosQuery(st, endereco.getId());

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Endereço excluído com sucesso! Linhas afetadas: " + linhasAfetadas);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao excluir";
		}

	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from endereco where end_id =?";
		}else if(entidade.getPesquisa().equals("cliente")){
			return "select * from endereco where end_cli_id = ?";
		}else {
			return "select * from endereco";
		}
	}

	private PreparedStatement executarPesquisa(Endereco endereco, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (endereco.getPesquisa().equals("id")) {
			setaParametrosQuery(st, endereco.getId());
		}else if(endereco.getPesquisa().equals("cliente")) {
			setaParametrosQuery(st, endereco.getCliente().getId());
		}
		return st;
	}

	public List<Endereco> consultar(EntidadeDominio entity) {
		Endereco endereco = (Endereco) entity;
		List<Endereco> enderecos = new ArrayList();
		System.out.println(endereco);
		inicializarConexao();
		CidadeDAO cidadeDAO = new CidadeDAO();
		try {
			String sql = pesquisarAuxiliar(endereco);
			st = executarPesquisa(endereco, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				Endereco enderecoAux = new Endereco(rs.getInt("end_id"), rs.getString("end_descricao"),
					TipoLogradouro.valueOf(rs.getString("end_tipologradouro")),rs.getString("end_logradouro"),
					rs.getString("end_numero"), rs.getString("end_complemento"), TipoResidencia.valueOf(rs.getString("end_tiporesidencia")),
					rs.getNString("end_bairro"), rs.getString("end_cep"), cidadeDAO.getCidadeById(rs.getInt("end_cid_id")),
					rs.getString("end_observacao"), TipoEndereco.valueOf(rs.getString("end_tipo")));
				enderecos.add(enderecoAux);
			}

			return enderecos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Endereco getEnderecoResidencialByCliente(Integer clienteId) {
		Endereco endereco = new Endereco();
		CidadeDAO cidadeDAO = new CidadeDAO();
		inicializarConexao();		
		
		System.out.println("Buscando endereco residencial do cliente:" + clienteId);
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("SELECT * FROM endereco WHERE end_cli_id = ? and end_tipo like 'Residencial' LIMIT 1");
			setaParametrosQuery(st, clienteId);
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				endereco = new Endereco(rs.getInt("end_id"), rs.getString("end_descricao"),
					TipoLogradouro.valueOf(rs.getString("end_tipologradouro")), rs.getString("end_logradouro"),
					rs.getString("end_numero"), rs.getString("end_complemento"),
					TipoResidencia.valueOf(rs.getString("end_tipoResidencia")), rs.getString("end_bairro"),
					rs.getString("end_cep"), cidadeDAO.getCidadeById(rs.getInt("end_cid_id")),
					rs.getString("end_observacao"), TipoEndereco.valueOf(rs.getString("end_tipo")));
			}
			
			return endereco;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Endereco getEnderecoById(Integer idEndereco) {
		Endereco endereco = new Endereco();
		endereco.setId(idEndereco);
		endereco.setPesquisa("id");
		
		return (Endereco) consultar(endereco).get(0);
	}
}
