package negocio;




import model.domain.EntidadeDominio;
import model.domain.Pedido;

public class ValidadorCadastroPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Pedido pedido = (Pedido) entidade;
		StringBuilder erros = new StringBuilder();

		if (!pedido.isUtilizouCartao() && !pedido.isUtilizouCupom()) {
			erros.append("É necessário informar ao menos uma forma de pagamento");
		}
		
		if (pedido.getEnderecoCobranca() == null) {
			erros.append("É necessário informar o endereço de cobrança");
		}
		
		if (pedido.getEnderecoEntrega() == null) {
			erros.append("É necessário o endereço de entrega");
		}
		
		if (pedido.getQuantidadeCartoesUsados() > pedido.getQuantidadeMaxCartoes()) {
			erros.append("O pagamento mínimo permitido para cada cartão aplicado é R$10,00");
		}
		
		if (erros != null && erros.length() > 0) {
			return erros.toString();
		} else {
			return null;
		}
	}

}
