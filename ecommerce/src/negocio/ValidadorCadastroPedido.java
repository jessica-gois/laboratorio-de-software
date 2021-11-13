package negocio;




import java.text.DecimalFormat;

import model.domain.EntidadeDominio;
import model.domain.Pedido;

public class ValidadorCadastroPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Pedido pedido = (Pedido) entidade;
		StringBuilder erros = new StringBuilder();

		if (!pedido.isUtilizouCartao() && !pedido.isUtilizouCupom()) {
			erros.append("� necess�rio informar ao menos uma forma de pagamento");
		}
		
		if (pedido.getValorTotal() > 0 && !pedido.isUtilizouCartao()) {
			DecimalFormat fmt = new DecimalFormat("0.00");
			erros.append("� necess�rio adicionar um cart�o ao pedido. Valor pendente de R$" 
				+ fmt.format(pedido.getValorTotal()));
		}		
		
		if (pedido.getEnderecoCobranca() == null) {
			erros.append("� necess�rio informar o endere�o de cobran�a");
		}
		
		if (pedido.getEnderecoEntrega() == null) {
			erros.append("� necess�rio o endere�o de entrega");
		}
		
		if (pedido.getQuantidadeCartoesUsados() > pedido.getQuantidadeMaxCartoes()) {
			erros.append("O pagamento m�nimo permitido para cada cart�o aplicado � R$10,00");
		}
		
		if (erros != null && erros.length() > 0) {
			return erros.toString();
		} else {
			return null;
		}
	}

}
