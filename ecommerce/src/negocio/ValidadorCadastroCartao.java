package negocio;

import org.junit.platform.commons.util.StringUtils;

import model.domain.Cartao;
import model.domain.EntidadeDominio;
import model.domain.enums.Bandeira;

public class ValidadorCadastroCartao implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cartao cartao = (Cartao) entidade;
		StringBuilder erros = new StringBuilder();

		if (StringUtils.isBlank(cartao.getNumero())) {
			erros.append("O número do cartão é obrigatório");
		}

		if (StringUtils.isBlank(cartao.getNomeImpresso())) {
			erros.append("O nome impresso no cartão é obrigatório");
		}

		if (StringUtils.isBlank(cartao.getCodigoSeguranca())) {
			erros.append("O código de segurança é obrigatório");
		}

		if (cartao.getBandeira() == null) {
			erros.append("A bandeira é obrigatória");
		}

		if (StringUtils.isNotBlank(erros.toString())) {
			return erros.toString();
		} else {
			return null;
		}
	}

}
