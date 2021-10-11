package model.domain;

public class FormaPagamento extends EntidadeDominio{
	private Cupom cupom;
	private Cartao cartao;
	private Pedido pedido;
	
	public FormaPagamento() {
		
	}
	
	public FormaPagamento(Cupom cupom) {
		this.cupom = cupom; 
	}
	
	public FormaPagamento(Cartao cartao) {
		this.cartao = cartao; 
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
