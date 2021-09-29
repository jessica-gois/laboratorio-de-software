package model.domain;

import java.util.List;

import model.domain.enums.StatusPedido;

public class Pedido extends EntidadeDominio {
	private Cliente cliente;
	private StatusPedido status;
	private Endereco enderecoEntrega;
	private Endereco enderecoCobranca;
	private Double valorTotal;
	private Double valorFrete;
	private List<FormaPagamento> formasPagamento;
	private List<PedidoItem> itens;
	
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
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Double getValorFrete() {
		return valorFrete;
	}
	
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}
		
}
