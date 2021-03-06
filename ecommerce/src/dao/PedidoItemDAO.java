package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.domain.EntidadeDominio;
import model.domain.FormaPagamento;
import model.domain.Pedido;
import model.domain.PedidoItem;
import model.domain.enums.StatusPedidoItem;
import util.Calculadora;

public class PedidoItemDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		PedidoItem pedidoItem = (PedidoItem) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO pedido_item (pei_quantidade, pei_valorunitario, pei_liv_id, pei_ped_id, pei_status) VALUES (?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);

			String status = pedidoItem.getStatus() != null ? pedidoItem.getStatus().name() : null;
			setaParametrosQuery(st, pedidoItem.getQuantidade(), pedidoItem.getValorUnitario(), pedidoItem.getLivro().getId(), pedidoItem.getPedido().getId(), status);
			long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			long terminoExecucao = System.currentTimeMillis();
			System.out.println(
				"Item do pedido cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execu??o: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		PedidoItem pedidoItem = (PedidoItem) entidade;
		System.out.println(pedidoItem.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("UPDATE pedido_item SET pei_quantidade = ?, pei_valorunitario = ?, pei_liv_id = ?, pei_status = ? WHERE pei_id = ?");
			String status = pedidoItem.getStatus() != null ? pedidoItem.getStatus().name() : null;
			setaParametrosQuery(st, pedidoItem.getQuantidade(), pedidoItem.getValorUnitario(), pedidoItem.getLivro().getId(), status, pedidoItem.getId());

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
		PedidoItem pedidoItem = (PedidoItem) entidade;
		System.out.println("Excluindo item:" + pedidoItem.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("DELETE from pedido_item WHERE pei_id = ?");
			setaParametrosQuery(st, false, pedidoItem.getId());

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Item exclu?do com sucesso! Linhas afetadas: " + linhasAfetadas);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao excluir item";
		}
	}

	public List<PedidoItem> consultar(EntidadeDominio entidade) {
		PedidoItem pedidoItem = (PedidoItem) entidade;
		List<PedidoItem> itens = new ArrayList();
		LivroDAO livroDAO = new LivroDAO();
		PedidoDAO pedidoDAO = new PedidoDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(pedidoItem);
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(pedidoItem);
			st = executarPesquisa(pedidoItem, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execu??o da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				StatusPedidoItem status = rs.getString("pei_status") != null ? StatusPedidoItem.valueOf(rs.getString("pei_status")) : null;
				PedidoItem pedidoItemAux = new PedidoItem(rs.getInt("pei_id"), sdf.parse(rs.getString("pei_dtCadastro")), rs.getDouble("pei_quantidade"),
					rs.getDouble("pei_valorunitario"), livroDAO.getLivroById(rs.getInt("pei_liv_id")), null);
				pedidoItemAux.setQuantidadeDisponivelTroca(getQuantidadeDisponivelTroca(rs.getInt("pei_id")));
				pedidoItemAux.setStatus(status);
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("pei_ped_id"));
				pedidoItemAux.setPedido(pedido);
				itens.add(pedidoItemAux);
			}

			return itens;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from pedido_item  WHERE pei_id =?";
		}else if(entidade.getPesquisa().equals("pedido")) {
			return "select * from pedido_item  WHERE pei_ped_id = ?";
		}else {
			return "select * from pedido_item";
		}
	}

	private PreparedStatement executarPesquisa(PedidoItem item, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (item.getPesquisa().equals("id")) {
			setaParametrosQuery(st, item.getId());
		} else if (item.getPesquisa().equals("pedido")) {
			setaParametrosQuery(st, item.getPedido().getId());
		}
		return st;
	}
	
	public List<PedidoItem> getItensByPedido(Integer idPedido) {
		PedidoItem item = new PedidoItem();
		Pedido pedido = new Pedido();
		pedido.setId(idPedido);
		item.setPedido(pedido);
		item.setPesquisa("pedido");
		
		if(idPedido != null) {
			return (List<PedidoItem>)consultar(item);
		}else {
			return new ArrayList<PedidoItem>();
		}
	}
	
	public PedidoItem getById(Integer idPedidoItem) {
		PedidoItem item = new PedidoItem();
		item.setId(idPedidoItem);
		item.setPesquisa("id");
		
		if(idPedidoItem != null) {
			return (PedidoItem) consultar(item).get(0);
		}else {
			return item;
		}
	}
	
	private Double getQuantidadeDisponivelTroca(Integer idPedidoItem) {
		Double quantidadeDisponivel = 0d;		
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("SELECT pei_quantidade - SUM(IFNULL(pit_quantidade, 0)) AS quantidadeDisponivelTroca " + 
				"FROM pedido_item LEFT JOIN pedido_item_troca ON pit_pei_id = pei_id where pei_id = ? LIMIT 1;",
				Statement.RETURN_GENERATED_KEYS);
			setaParametrosQuery(st, idPedidoItem);
					
			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execu??o da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				quantidadeDisponivel = rs.getDouble("quantidadeDisponivelTroca");
			}

			return quantidadeDisponivel;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}