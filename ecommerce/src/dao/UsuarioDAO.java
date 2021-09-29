package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.domain.EntidadeDominio;
import model.domain.Usuario;
import util.Calculadora;

public class UsuarioDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO usuario " + "(usu_email, usu_senha, usu_status) VALUES (?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);

			setaParametrosQuery(st, usuario.getEmail(), usuario.getSenha(), true);
			long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			long terminoExecucao = System.currentTimeMillis();
			System.out.println(
				"Usuario cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		System.out.println(usuario.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("UPDATE usuario SET usu_senha = ?, usu_email = ? WHERE usu_id = ?");
			
			setaParametrosQuery(st, usuario.getSenha(), usuario.getEmail(), usuario.getId());

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar";
		}
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		System.out.println("Inativando usuario:" + usuario.getEmail()
			+ " id: " + usuario.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("UPDATE usuario set usu_status = ? WHERE usu_id = ?");
			setaParametrosQuery(st, false, usuario.getId());

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Usuário inativado com excluído com sucesso! Linhas afetadas: " + linhasAfetadas);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao inativar conta";
		}
	}

	public List<Usuario> consultar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		List<Usuario> usuarios = new ArrayList();
		System.out.println(usuario);
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(usuario);
			st = executarPesquisa(usuario, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				Usuario usuAux = new Usuario(rs.getInt("usu_id"), rs.getString("usu_email"),
						rs.getString("usu_senha"));
				usuarios.add(usuAux);
			}

			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from usuario  WHERE usu_id =?";
		}else if(entidade.getPesquisa().equals("email,senha")) {
			return "select * from usuario  WHERE usu_email = ? and usu_senha = ?";
		} else if(entidade.getPesquisa().equals("senha,usuario")){
			return "select * from usuario  WHERE usu_senha = ? and usu_id = ?";
		}else {
			return "select * from usuario";
		}
	}

	private PreparedStatement executarPesquisa(Usuario usuario, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (usuario.getPesquisa().equals("id")) {
			setaParametrosQuery(st, usuario.getId());
		} else if (usuario.getPesquisa().equals("email,senha")) {
			setaParametrosQuery(st, usuario.getEmail(), usuario.getSenha());
		} else if(usuario.getPesquisa().equals("senha,usuario")){
			setaParametrosQuery(st, usuario.getSenha(), usuario.getId());
		}
		return st;
	}
}
