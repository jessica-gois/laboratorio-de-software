package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.domain.EntidadeDominio;
import model.domain.FormaPagamento;
import model.domain.Pedido;
import model.domain.PedidoItem;
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
				+ "ped_endEntrega_id, ped_endEndCobranca_id) VALUES (?, ?, ?, ?, ?, ?)",
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
