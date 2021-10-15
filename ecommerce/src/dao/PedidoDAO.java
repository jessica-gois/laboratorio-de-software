package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.domain.Cliente;
import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.FormaPagamento;
import model.domain.Livro;
import model.domain.Pedido;
import model.domain.PedidoItem;
import model.domain.enums.StatusPedido;
import util.Calculadora;

public class PedidoDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		Pedido pedido = (Pedido) entidade;
		PedidoItemDAO pedidoItemDAO = new PedidoItemDAO();
		FormaPagamentoDAO formaPagamentoDAO = new FormaPagamentoDAO();
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("INSERT INTO pedido(ped_valortotal, ped_valorfrete, ped_status, ped_cli_id, "
				+ "ped_endEntrega_id, ped_endCobranca_id) VALUES (?, ?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);

			setaParametrosQuery(st, pedido.getValorTotal(), pedido.getValorFrete(), pedido.getStatus().name(),
				pedido.getCliente().getId(), pedido.getEnderecoEntrega().getId(), pedido.getEnderecoCobranca().getId());
			long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			long terminoExecucao = System.currentTimeMillis();
			System.out.println(
				"Pedido cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
			
			
			ResultSet rs = st.getGeneratedKeys();
			Integer idPedidoCadastrado = null;
			while(rs.next()) {
				idPedidoCadastrado = rs.getInt(1);
			}
			
			if(idPedidoCadastrado != null){
				pedido.setId(idPedidoCadastrado);
				for(FormaPagamento formaPagamento : pedido.getFormasPagamento()){
					formaPagamento.setPedido(pedido);
					formaPagamentoDAO.salvar(formaPagamento);
				}
				for(PedidoItem item : pedido.getItens()){
					item.setPedido(pedido);
					pedidoItemDAO.salvar(item);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		Pedido pedido = (Pedido) entidade;
		System.out.println(pedido.getId());
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			st = conn.prepareStatement("UPDATE pedido SET ped_status = ? WHERE ped_id = ?");
			
			setaParametrosQuery(st, pedido.getStatus().name(), pedido.getId());

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao alterar pedido";
		}
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from pedido where ped_id = ?";
		} else if (entidade.getPesquisa().equals("ultimoCadastrado")) {
			return "select * from pedido where ped_id = (select MAX(ped_id) from pedido where ped_cli_id = ?)";
		} else {
			return "select * from pedido";
		}
	}

	private PreparedStatement executarPesquisa(Pedido pedido, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if (pedido.getPesquisa().equals("id")) {
			setaParametrosQuery(st, pedido.getId());
		}else if (pedido.getPesquisa().equals("ultimoCadastrado") && pedido.getCliente() != null) {
			setaParametrosQuery(st, pedido.getCliente().getId());;
		} 
		return st;
	}
	
	@Override
	public List<Pedido> consultar(EntidadeDominio entidade) {
		Pedido pedido = (Pedido) entidade;
		List<Pedido> pedidos = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		FormaPagamentoDAO formaPagamentoDAO = new FormaPagamentoDAO();
		PedidoItemDAO pedidoItemDAO = new PedidoItemDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
				
		System.out.println(pedido);
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(pedido);
			st = executarPesquisa(pedido, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				Pedido pedidoAux = new Pedido(rs.getInt("ped_id"), sdf.parse(rs.getString("ped_dtCadastro")), pedido.getCliente(),
					StatusPedido.valueOf(rs.getString("ped_status")), enderecoDAO.getEnderecoById(rs.getInt("ped_endEntrega_id")),
					enderecoDAO.getEnderecoById(rs.getInt("ped_endCobranca_id")), rs.getDouble("ped_valortotal"), rs.getDouble("ped_valorfrete"),
					formaPagamentoDAO.getFormasPagamentoByPedido(rs.getInt("ped_id")), pedidoItemDAO.getItensByPedido(rs.getInt("ped_id")));
				pedidos.add(pedidoAux);
			}	

			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
