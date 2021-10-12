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
import model.domain.Livro;
import model.domain.enums.Bandeira;
import model.domain.enums.Estado;
import util.Calculadora;

public class LivroDAO extends AbstractDAO {

	public String salvar(EntidadeDominio entidade) {
		return null;
	}

	public String alterar(EntidadeDominio entidade) {
		return null;
	}

	public String excluir(EntidadeDominio entidade) {
		Livro livro = (Livro) entidade;
		System.out.println(livro.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("UPDATE livro SET liv_status = 0 WHERE liv_id = ?");
			setaParametrosQuery(st, livro.getId());

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Livro inativado com sucesso! Linhas afetadas: " + linhasAfetadas);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao inativar livro";
		}

	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from livro where liv_id =?";
		}else if(entidade.getPesquisa().equals("status")){
			return "select * from livro where liv_status = ?";
		}else{
			return "select * from livro";
		}
	}

	private PreparedStatement executarPesquisa(Livro livro, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (livro.getPesquisa().equals("id")) {
			setaParametrosQuery(st, livro.getId());
		}else if(livro.getPesquisa().equals("status")) {
			setaParametrosQuery(st, livro.getStatus());
		}
		return st;
	}

	public List<Livro> consultar(EntidadeDominio entidade) {
		Livro livro = (Livro) entidade;
		List<Livro> livros = new ArrayList();
		GrupoPrecificacaoDAO grupoDAO = new GrupoPrecificacaoDAO();
		EstoqueItemDAO estoqueItemDAO = new EstoqueItemDAO();
		
		System.out.println(livro);
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(livro);
			st = executarPesquisa(livro, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				Livro livroAux = new Livro(rs.getInt("liv_id"), rs.getString("liv_titulo"), rs.getString("liv_autor"),
					rs.getString("liv_editora"), rs.getString("liv_ano"), rs.getInt("liv_qtdPaginas"), rs.getString("liv_edicao"),
					rs.getString("liv_sinopse"), rs.getDouble("liv_altura"), rs.getDouble("liv_altura"), rs.getDouble("liv_peso"),
					rs.getDouble("liv_profundidade"), rs.getString("liv_codigoBarras"), grupoDAO.getGrupoPrecificacaoById(rs.getInt("liv_gru_id")),
					rs.getDouble("liv_precoVenda"), rs.getBoolean("liv_status"), rs.getString("liv_imagemUrl"), rs.getString("liv_isbn"),
					estoqueItemDAO.getQuantidadeEstoqueLivro(rs.getInt("liv_id")));
				livros.add(livroAux);
			}	

			return livros;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Livro getLivroById(Integer livroId) {
		Livro livro = new Livro();
		GrupoPrecificacaoDAO grupoDAO = new GrupoPrecificacaoDAO();
		EstoqueItemDAO estoqueItemDAO = new EstoqueItemDAO();
		
		System.out.println("Buscando livro id:" + livroId);
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("SELECT * FROM livro WHERE liv_id = ? LIMIT 1");
			setaParametrosQuery(st, livroId);
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				livro = new Livro(rs.getInt("liv_id"), rs.getString("liv_titulo"), rs.getString("liv_autor"),
					rs.getString("liv_editora"), rs.getString("liv_ano"), rs.getInt("liv_qtdPaginas"), rs.getString("liv_edicao"),
					rs.getString("liv_sinopse"), rs.getDouble("liv_altura"), rs.getDouble("liv_altura"), rs.getDouble("liv_peso"),
					rs.getDouble("liv_profundidade"), rs.getString("liv_codigoBarras"), grupoDAO.getGrupoPrecificacaoById(rs.getInt("liv_gru_id")),
					rs.getDouble("liv_precoVenda"), rs.getBoolean("liv_status"), rs.getString("liv_imagemUrl"), rs.getString("liv_isbn"),
					estoqueItemDAO.getQuantidadeEstoqueLivro(rs.getInt("liv_id")));
			}
			
			return livro;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
