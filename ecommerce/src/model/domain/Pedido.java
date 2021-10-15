	package model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.domain.enums.StatusPedido;

public class Pedido extends EntidadeDominio {
	private Cliente cliente;
	private StatusPedido status;
	private Endereco enderecoEntrega;
	private Endereco enderecoCobranca;
	private Double valorTotal;
	private Double valorFrete;
	private List<FormaPagamento> formasPagamento = new ArrayList<FormaPagamento>();
	private List<PedidoItem> itens;
	
	public Pedido() {
		
	}
	
	public Pedido(Cliente cliente, StatusPedido status, Endereco enderecoEntrega, Endereco enderecoCobranca, List<PedidoItem> itens) {
		if (cliente != null) {
			this.cliente = cliente;
		}
		if (status != null) {
			this.status = status;
		}
		if (enderecoEntrega != null) {
			this.enderecoEntrega = enderecoEntrega;
		}
		if (enderecoCobranca != null) {
			this.enderecoCobranca = enderecoCobranca;
		}
		if (itens != null) {
			this.itens = itens;
		}
	}
	
	public Pedido(Integer id, Date dtCadastro, Cliente cliente, StatusPedido status, Endereco enderecoEntrega, Endereco enderecoCobranca,
			Double valorTotal, Double valorFrete, List<FormaPagamento> formasPagamento, List<PedidoItem> itens) {
		super();
		if(id != null) {
			this.setId(id);
		}
		if(dtCadastro != null) {
			this.setDtCadastro(dtCadastro);
		}
		this.cliente = cliente;
		this.status = status;
		this.enderecoEntrega = enderecoEntrega;
		this.enderecoCobranca = enderecoCobranca;
		this.valorTotal = valorTotal;
		this.valorFrete = valorFrete;
		this.formasPagamento = formasPagamento;
		this.itens = itens;
	}

	public StatusPedido getStatus() {
		return status;
	}
	
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}
	
	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	public Endereco getEnderecoCobranca() {
		return enderecoCobranca;
	}
	public void setEnderecoCobranca(Endereco enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}
	
	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}
	
	public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<PedidoItem> getItens() {
		return itens;
	}
	
	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}
	
	public Double getValorTotal() {
		if(valorTotal == null) {
			Double total = getValorTotalItens() + getValorFrete();
			total -= getValorTotalDescontos();
			return total;
		}
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Double getValorFrete() {
		if (valorFrete == null) {
			Double frete = 10d;
			if (itens != null && !itens.isEmpty()) {
				for (PedidoItem item : itens) {
					frete += 1d;
				}
			}
			return frete;
		}
		return valorFrete;
	}
	
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}
		
	public Double getValorTotalItens() {
		Double totalItens = 0d;
		if(itens != null && !itens.isEmpty()) {
			for(PedidoItem item : itens) {
				totalItens += item.getValorTotal();
			}
		}
		return totalItens;
	}
	
	public Double getValorTotalDescontos() {
		Double totalDescontos = 0d;
		
		if(formasPagamento != null) {
			for(FormaPagamento formaPagamento: formasPagamento) {
				if(formaPagamento.getCupom() != null) {
					totalDescontos += formaPagamento.getCupom().getValor();
				}
			}
		}	
		return totalDescontos;
	}
	
	public Double getQuantidadeCartoesUsados() {
		Double totalCartoes = 0d;
		if(formasPagamento != null) {
			for(FormaPagamento formaPagamento: formasPagamento) {
				if(formaPagamento.getCartao() != null) {
					totalCartoes++;
				}
			}
		}	
		return totalCartoes;		
	}
	
	public Double getQuantidadeMaxCartoes() {
		Double quantidadeCartoes = 0d;
		if (getValorTotal() > 0) { 
			quantidadeCartoes = Math.floor(getValorTotal() / 10);
		}
		return quantidadeCartoes;
	}
	
}
