package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.domain.EntidadeDominio;
import model.domain.Pedido;
import model.domain.PedidoItem;
import model.domain.PedidoItemTroca;
import model.domain.enums.StatusPedidoItem;
import util.Calculadora;

public class PedidoItemTrocaDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		PedidoItemTroca itemTroca = (PedidoItemTroca) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement(
					"INSERT INTO pedido_item_troca (pit_quantidade, pit_notificacao, pit_pei_id) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			setaParametrosQuery(st, itemTroca.getQuantidade(), false, itemTroca.getItem().getId());
			long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			long terminoExecucao = System.currentTimeMillis();
			System.out.println("Item de troca cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas
					+ "\nTempo de execução: " + Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao)
					+ " segundos");
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		PedidoItemTroca itemTroca = (PedidoItemTroca) entidade;
		System.out.println(itemTroca.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement(
				"UPDATE pedido_item_troca SET pit_quantidade = ?, pit_notificacao = ? WHERE pet_id = ?");
			setaParametrosQuery(st, itemTroca.getQuantidade(), itemTroca.getNotificacao(), itemTroca.getId());

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar item";
		}
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		return null;
	}

	public List<PedidoItemTroca> consultar(EntidadeDominio entidade) {
		PedidoItemTroca itemTroca = (PedidoItemTroca) entidade;
		List<PedidoItemTroca> itens = new ArrayList();
		PedidoItemDAO pedidoItemDao = new PedidoItemDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(itemTroca);
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(itemTroca);
			st = executarPesquisa(itemTroca, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();  
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				PedidoItemTroca itemTrocaAux = new PedidoItemTroca(rs.getInt("pei_id"), sdf.parse(rs.getString("pit_dtCadastro")),
					pedidoItemDao.getById(rs.getInt("pit_pei_id")), rs.getDouble("pit_quantidade"), rs.getBoolean("pit_notificacao"));
				itens.add(itemTrocaAux);
			}

			return itens;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from pedido_item_troca  WHERE pit_id = ?";
		} else if (entidade.getPesquisa().equals("item")) {
			return "select * from ped_item_troca  WHERE pit_pei_id = ?";
		} else {
			return "select * from pedido_item_troca";
		}
	}

	private PreparedStatement executarPesquisa(PedidoItemTroca item, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (item.getPesquisa().equals("id")) {
			setaParametrosQuery(st, item.getId());
		} else if (item.getPesquisa().equals("item")) {
			setaParametrosQuery(st, item.getItem().getId());
		}
		return st;
	}
}