package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import model.domain.Cartao;
import model.domain.EntidadeDominio;
import model.domain.Usuario;
import model.domain.enums.Bandeira;
import util.Calculadora;

public class UsuarioDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
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
		} else {
			return "select * from usuario";
		}
	}

	private PreparedStatement executarPesquisa(Usuario usuario, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (usuario.getPesquisa().equals("id")) {
			setaParametrosQuery(st, usuario.getId());
		} else if (usuario.getPesquisa().equals("email,senha")) {
			setaParametrosQuery(st, usuario.getEmail(), usuario.getSenha());
		}
		return st;
	}
}
