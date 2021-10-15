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
import model.domain.FormaPagamento;
import model.domain.Pedido;
import model.domain.enums.TipoTelefone;
import util.Calculadora;

public class FormaPagamentoDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		FormaPagamento formaPagamento = (FormaPagamento) entidade;
		Integer idCupom = formaPagamento.getCupom() != null ? formaPagamento.getCupom().getId() : null;
		Integer idCartao = formaPagamento.getCartao() != null ? formaPagamento.getCartao().getId() : null;
		
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO forma_pagamento (for_ped_id");
			
			if(formaPagamento.getCupom() != null) {
				sql.append(", for_cup_id");
			}			
			if(formaPagamento.getCartao() != null) {
				sql.append(", for_car_id");
			}
			sql.append(") VALUES(?");
			
			if(formaPagamento.getCupom() != null) {
				sql.append(", ?");
			}			
			if(formaPagamento.getCartao() != null) {
				sql.append(", ?");
			}
			
			sql.append(")");	
			System.out.println(sql.toString());
			
			st = conn.prepareStatement(sql.toString(),
				Statement.RETURN_GENERATED_KEYS);
			setaParametrosQuery(st, formaPagamento.getPedido().getId(), idCupom, idCartao);
			long inicioExecucao = System.currentTimeMillis();
			int linhasAfetadas = st.executeUpdate();
			long terminoExecucao = System.currentTimeMillis();
			
			System.out.println(
				"Item do pedido cadastrado com sucesso! \n Linhas afetadas: " + linhasAfetadas + "\nTempo de execução: "
				+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");
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

	private String pesquisarAuxiliar(EntidadeDominio entidade) {
		if (entidade.getPesquisa().equals("id")) {
			return "select * from forma_pagamento where for_id = ?";
		} else if (entidade.getPesquisa().equals("pedido")) {
			return "select * from forma_pagamento where for_ped_id = ?";
		} else {
			return "select * from forma_pagamento";
		}
	}

	private PreparedStatement executarPesquisa(FormaPagamento formaPagamento, String sql) throws SQLException {
		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
		if ((formaPagamento.getPesquisa().equals("id"))) {
			setaParametrosQuery(st, formaPagamento.getId());
		}else if (formaPagamento.getPesquisa().equals("pedido") && formaPagamento.getPedido() != null) {
			setaParametrosQuery(st, formaPagamento.getPedido().getId());;
		} 
		return st;
	}
	
	@Override
	public List<FormaPagamento> consultar(EntidadeDominio entidade) {
		FormaPagamento formaPagamento = (FormaPagamento) entidade;
		List<FormaPagamento> formasPagamento = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		CupomDAO cupomDAO = new CupomDAO();
		CartaoDAO cartaoDAO = new CartaoDAO();
		inicializarConexao();
		try {
			String sql = pesquisarAuxiliar(formaPagamento);
			st = executarPesquisa(formaPagamento, sql);

			Long inicioExecucao = System.currentTimeMillis();
			ResultSet rs = st.executeQuery();
			Long terminoExecucao = System.currentTimeMillis();

			System.out.println("Tempo de execução da consulta: "
					+ Calculadora.calculaIntervaloTempo(inicioExecucao, terminoExecucao) + " segundos");

			while (rs.next()) {
				FormaPagamento formaAux = new FormaPagamento(rs.getInt("for_id"), sdf.parse(rs.getString("for_dtCadastro")),
					cupomDAO.getCupomById(rs.getInt("for_cup_id")),
					cartaoDAO.getCartaoById(rs.getInt("for_car_id")), new Pedido());
				formasPagamento.add(formaAux);
			}

			return formasPagamento;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<FormaPagamento> getFormasPagamentoByPedido(Integer idPedido) {
		FormaPagamento formaPagamento = new FormaPagamento();
		Pedido pedido = new Pedido();
		pedido.setId(idPedido);
		formaPagamento.setPedido(pedido);
		formaPagamento.setPesquisa("pedido");
		
		if(idPedido != null  && idPedido > 0) {
			return (List<FormaPagamento>)consultar(formaPagamento);
		}else {
			return new ArrayList<FormaPagamento>();
		}
	}

}
