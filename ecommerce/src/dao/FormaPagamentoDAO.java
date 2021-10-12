package dao;

import java.sql.Statement;
import java.util.List;

import model.domain.EntidadeDominio;
import model.domain.FormaPagamento;
import util.Calculadora;

public class FormaPagamentoDAO extends AbstractDAO {

	@Override
	public String salvar(EntidadeDominio entidade) {
		FormaPagamento formaPagamento = (FormaPagamento) entidade;
		inicializarConexao();
		try {
			conn = Database.conectarBD();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO forma_pagamento (for_ped_id,");
			
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
			
			st = conn.prepareStatement(sql.toString(),
				Statement.RETURN_GENERATED_KEYS);
			setaParametrosQuery(st, formaPagamento.getPedido().getId(), formaPagamento.getCupom().getId(),
				formaPagamento.getCartao().getId());
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

	@Override
	public List<FormaPagamento> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
