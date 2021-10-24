package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.domain.Cliente;
import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Telefone;
import model.domain.enums.TipoTelefone;
import util.Calculadora;
import util.Conversao;

public class ClienteDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			Long inicioExecucao = System.currentTimeMillis();
			Long terminoExecucao = null;
			int linhasAfetadas = 0;			
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			if (cliente != null && cliente.getUsuario() != null) {
				usuarioDAO.salvar(cliente.getUsuario());
				linhasAfetadas = 1;
			}
			
			if(linhasAfetadas > 0) {
				linhasAfetadas = 0;
			st = conn.prepareStatement("INSERT INTO cliente " +
			"(cli_nome, cli_sobrenome, cli_genero, cli_datanascimento, cli_cpf, cli_score, cli_usu_id) "
					+ "VALUES " + "(?, ?, ?,?, ?, ?, (SELECT MAX(usu_id) from usuario))",
						Statement.RETURN_GENERATED_KEYS);
			
			setaParametrosQuery(st, cliente.getNome(), cliente.getSobrenome(), cliente.getGenero(), 
				cliente.getDataNascimento(), cliente.getCpf(), cliente.getScore());			
				linhasAfetadas = st.executeUpdate();	
			}
			
			if(cliente.getTelefoneResidencial() != null && linhasAfetadas > 0) {				
				telefoneDAO.salvar(cliente.getTelefoneResidencial());
			}
			
			if(cliente.getTelefoneCelular() != null && linhasAfetadas > 0) {
				telefoneDAO.salvar(cliente.getTelefoneCelular());
			}

			if (cliente.getEnderecoResidencial() != null && linhasAfetadas > 0) {
				Endereco end = cliente.getEnderecoResidencial();
				StringBuilder sql = new StringBuilder("INSERT INTO endereco (end_descricao,"
					+ " end_tipologradouro, end_logradouro, end_numero");
				if(end.getComplemento() != null && end.getComplemento() != "") {
					sql.append(", end_complemento");
				}
				sql.append(", end_tiporesidencia, end_cep, end_bairro, end_tipo, end_observacao, end_cli_id,"
					+ " end_cid_id) VALUES(");
				if(end.getComplemento() != null && end.getComplemento() != "") {
					sql.append("?,");
				}
				sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID(), " + 
				"(SELECT cid_id FROM cidade WHERE cid_nome like ? AND cid_est_id = ? LIMIT 1 ))");
				
				st = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

				setaParametrosQuery(st, end.getDescricao(), end.getTipoLogradouro().name(), end.getLogradouro(),
					end.getNumero(), end.getComplemento(), end.getTipoResidencia().name(), end.getCep(),
					end.getBairro(), end.getTipoEndereco().name(), end.getObservacao(), end.getCidade().getNome(),
					end.getCidade().getEstado().getCodigo());
				linhasAfetadas += st.executeUpdate();
				terminoExecucao = System.currentTimeMillis();
			}
			
			System.out.println("Cliente cadastrado com sucesso! \n Linhas afetadas: "
			+ linhasAfetadas + "\nTempo de execu��o: "+
			Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}		
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println(cliente.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			
			st = conn.prepareStatement("UPDATE cliente SET cli_nome = ?, "
					+ "cli_sobrenome = ?, cli_genero = ?, cli_dataNascimento = ?, cli_cpf = ?");
			
			setaParametrosQuery(st, cliente.getNome(), cliente.getSobrenome(), cliente.getGenero(),
					cliente.getDataNascimento(), cliente.getCpf());

			int rowsAffected = st.executeUpdate();
			
			telefoneDAO.alterar(cliente.getTelefoneResidencial());
			telefoneDAO.alterar(cliente.getTelefoneCelular());
			usuarioDAO.alterar(cliente.getUsuario());
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar";
		}
		
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		return null;
	}

	@Override
	public List<Cliente> consultar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		List<Cliente> clientes = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		TelefoneDAO telDAO = new TelefoneDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(cliente);
			st = executarPesquisa(cliente, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execu��o da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			
			while (rs.next()) {
				Integer clienteId = rs.getInt("cli_id");
				Cliente clienteAux = new Cliente(clienteId, rs.getString("cli_nome"),
						rs.getString("cli_sobrenome"), rs.getString("cli_genero"),
						sdf.parse(rs.getString("cli_datanascimento")), rs.getString("cli_cpf"), rs.getInt("cli_score"),
						telDAO.getTelefoneByCliente(clienteId, TipoTelefone.RESIDENCIAL),
						telDAO.getTelefoneByCliente(clienteId, TipoTelefone.CELULAR),
						enderecoDAO.getEnderecoResidencialByCliente(clienteId), cliente.getUsuario());
				if(cliente.getUsuario() != null) {
					clienteAux.getUsuario().setId(rs.getInt("cli_usu_id"));
				}else {
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					clienteAux.setUsuario(usuarioDAO.getUsuarioById(rs.getInt("cli_usu_id")));
				}
				clientes.add(clienteAux);
			}

			return clientes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa() != null && entidade.getPesquisa().equals("id")) {
			return "select * from cliente  WHERE cli_id = ?";
		} else if(entidade.getPesquisa() != null && entidade.getPesquisa().equals("usuario")){
			return "select * from cliente  WHERE cli_usu_id = ?";
		} {
			return "select * from cliente";
		}
	}

	private PreparedStatement executarPesquisa(Cliente cliente, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (cliente.getPesquisa() != null && cliente.getPesquisa().equals("id")) {
			setaParametrosQuery(st, cliente.getId());
		} else if (cliente.getPesquisa() != null && cliente.getPesquisa().equals("usuario")) {
			setaParametrosQuery(st, cliente.getUsuario().getId());
		}
		return st;
	}
	
	public Cliente getClienteById(Integer idCliente) {
		Cliente cliente = new Cliente();
		cliente.setId(idCliente);
		cliente.setPesquisa("id");
		
		if(idCliente != null && idCliente > 0) {
			return (Cliente)consultar(cliente).get(0);
		}else {
			return cliente;
		}
	}
}
