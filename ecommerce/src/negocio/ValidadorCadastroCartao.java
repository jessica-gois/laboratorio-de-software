package negocio;




import model.domain.Cartao;
import model.domain.EntidadeDominio;
import model.domain.enums.Bandeira;

public class ValidadorCadastroCartao implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cartao cartao = (Cartao) entidade;
		StringBuilder erros = new StringBuilder();

		if (cartao.getNumero() == null || cartao.getNumero() == "") {
			erros.append("O número do cartão é obrigatório");
		}

		if (cartao.getNomeImpresso() == null || cartao.getNomeImpresso() =="") {
			erros.append("O nome impresso no cartão é obrigatório");
		}

		if (cartao.getCodigoSeguranca() == null || cartao.getCodigoSeguranca() == "") {
			erros.append("O código de segurança é obrigatório");
		}

		if (cartao.getBandeira() == null) {
			erros.append("A bandeira é obrigatória");
		}

		if (erros != null && erros.length() > 0) {
			return erros.toString();
		} else {
			return null;
		}
	}

}
