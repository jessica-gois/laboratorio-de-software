package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.domain.Cliente;
import model.domain.Cupom;
import model.domain.EntidadeDominio;
import model.domain.FormaPagamento;
import model.domain.MovimentacaoEstoque;
import model.domain.Pedido;
import model.domain.PedidoItem;
import model.domain.Usuario;
import model.domain.enums.StatusPedido;
import model.domain.enums.TipoCupom;
import model.domain.enums.TipoMovimentacao;
import util.Calculadora;
import util.Conversao;

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
			
			Double total = pedido.getValorTotal() >= 0 ? pedido.getValorTotal() : 0;
			
			setaParametrosQuery(st, total, pedido.getValorFrete(), pedido.getStatus().name(),
				pedido.getCliente().getId(), pedido.getEnderecoEntrega().getId(), pedido.getEnderecoCobranca().getId());
			long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			long terminoExecucao = System.currentTimeMillis();
			
			if (pedido.getValorTotal() < 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					Integer idPedidoCadastrado = rs.getInt(1);
					pedido.setId(idPedidoCadastrado);
				}			
				
			}
			
			gerarCupomDeTroca(pedido);
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

//	private String pesquisarAuxiliar(EntidadeDominio entidade) {
//		if (entidade.getPesquisa() != null && entidade.getPesquisa().equals("id")) {
//			return "select * from pedido where ped_id = ?";
//		} else if (entidade.getPesquisa() != null && entidade.getPesquisa().equals("ultimoCadastrado")) {
//			return "select * from pedido where ped_id = (select MAX(ped_id) from pedido where ped_cli_id = ?)";
//		} else if(entidade.getPesquisa() != null && entidade.getPesquisa().equals("cliente")){
//			return "select * from pedido where ped_cli_id = ?";
//		}else {
//			return "select * from pedido";
//		}
//	}
	
	
	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa() != null && entidade.getPesquisa().equals("id")) {
			return "select * from pedido where ped_id = ?";
		}else if(entidade.getPesquisa() != null && entidade.getPesquisa().equals("cliente")) {
			return "select * from pedido where ped_cli_id = ?";
		}else if (entidade.getPesquisa() != null && entidade.getPesquisa().equals("filtros")){
			Pedido pedido = (Pedido) entidade;
			StringBuilder sql = new StringBuilder();
			sql.append("select * from pedido ");
			boolean filtroEmailPreenchido = pedido.getCliente() != null && pedido.getCliente().getUsuario() != null ? true : false;
			boolean filtroCpfPreenchido = pedido.getCliente() != null && pedido.getCliente().getCpf() != null ? true : false;			
			
			if(pedido.getCliente() != null && pedido.getCliente().getUsuario() != null && pedido.getCliente().getUsuario().getEmail() != null) {
				sql.append("join usuario on usu_id = (select cli_usu_id from cliente where cli_id = ped_cli_id LIMIT 1) and usu_email LIKE ? ");
			}
			
			if(pedido.getCliente() != null && pedido.getCliente().getCpf() != null) {
				sql.append("join cliente on cli_id = ped_cli_id and cli_cpf LIKE ? ");
			}
			
			
			if(pedido.getId() > 0 || pedido.getDtCadastro() != null || filtroEmailPreenchido || filtroCpfPreenchido
				|| pedido.getValorTotal() != null || pedido.getStatus() != null) {
				sql.append("where ped_cli_id is not null ");
			}
			
			if(pedido.getDtCadastro() != null) {
				sql.append("and CAST(ped_dtCadastro as date) = ? ");
			}		
			
			if(pedido.getValorTotal() != null && pedido.getValorTotal() > 0) {
				sql.append("and ped_valortotal = ? ");
				System.out.println("Valor total do pedido" + pedido.getValorTotal());
			}
			
			if(pedido.getStatus() != null) {
				sql.append("and ped_status = ? ");
			}			
			
			if (pedido.getId() > 0) {
				sql.append("and ped_id = ? ");
			}
						
			return sql.toString();
		
		}else {
			return "select * from pedido";
		}
	}
	

//	private PreparedStatement executarPesquisa(Pedido pedido, String sql) throws SQLException {
//		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
//		if (pedido.getPesquisa() != null && pedido.getPesquisa().equals("id")) {
//			setaParametrosQuery(st, pedido.getId());
//		}else if (pedido.getPesquisa() != null && pedido.getPesquisa().equals("ultimoCadastrado") && pedido.getCliente() != null) {
//			setaParametrosQuery(st, pedido.getCliente().getId());
//		}else if(pedido.getPesquisa() != null && pedido.getPesquisa().equals("cliente")){
//			setaParametrosQuery(st, pedido.getCliente().getId());
//		}
//		return st;
//	}
	
	private PreparedStatement executarPesquisa(Pedido pedido, String sql) throws SQLException, ParseException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		
		if (pedido.getPesquisa() != null && pedido.getPesquisa().equals("id")) {
			setaParametrosQuery(st, pedido.getId());
		}else if(pedido.getPesquisa() != null && pedido.getPesquisa().equals("cliente")) {
			setaParametrosQuery(st, pedido.getCliente().getId());
		}else if (pedido.getPesquisa() != null && pedido.getPesquisa().equals("filtros")) {
		
			String filtroEmail = pedido.getCliente() != null && pedido.getCliente().getUsuario() !=null ?
				"%" + pedido.getCliente().getUsuario().getEmail() + "%": null;
			
			String filtroCpf = pedido.getCliente() != null && pedido.getCliente().getCpf() != null ? "%" + pedido.getCliente().getCpf().trim() + "%" : null;
			
			String filtroStatus = pedido.getStatus() != null ? pedido.getStatus().name() : null;
			
			setaParametrosQuery(st, filtroEmail, filtroCpf, pedido.getDtCadastro(),(pedido.getValorTotal() > 0 ? pedido.getValorTotal() : null ), filtroStatus, 
					(pedido.getId() > 0 ? pedido.getId() : null ));
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
				if (pedido.getCliente() == null || pedido.getCliente().getId() == 0) {
					ClienteDAO clienteDAO = new ClienteDAO();
					pedidoAux.setCliente(clienteDAO.getClienteById(rs.getInt("ped_cli_id")));
				}
				pedidos.add(pedidoAux);
			}	

			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Pedido getPedidoById(Integer pedidoId) {
		Pedido pedido = new Pedido();
		pedido.setId(pedidoId);
		pedido.setPesquisa("id");
		if (pedidoId != null && pedidoId > 0) {
			return (Pedido) consultar(pedido).get(0);
		} else {
			return pedido;
		}
	}
	
	public void gerarCupomDeTroca(Pedido pedido) {
		if (pedido != null && pedido.getValorTotal() < 0) {
			CupomDAO cupomDAO = new CupomDAO();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.YEAR, 1);
			Date validade = calendar.getTime(); // Atribuindo validade de um ano ao cupom de troca
			Double valorCupom = pedido.getValorTotal() * -1d;
			
			Cupom cupom = new Cupom(null, "TPED" + pedido.getId(), "Troca do pedido " + pedido.getId(), valorCupom,
				validade, TipoCupom.TROCA, pedido.getCliente().getId(), pedido.getId());
			
			cupomDAO.salvar(cupom);

		}
	}
	
}
