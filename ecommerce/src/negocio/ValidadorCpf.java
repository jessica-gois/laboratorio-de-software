package negocio;

import org.junit.platform.commons.util.StringUtils;

import model.domain.Cliente;
import model.domain.EntidadeDominio;

public class ValidadorCpf implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		if (entidade instanceof Cliente) {
			Cliente cliente = (Cliente) entidade;
			String cpf = cliente.getCpf().replace("-", "").replace(".", "");
			String msgPadrao = "CPF inválido\n";

			if (cpf == null || cpf.isBlank()) {
				return "É necessário informar o cfp\n";
			}

			if (cpf.length() != 11) {
				return msgPadrao;
			}

			if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
					|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
					|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
					|| cpf.equals("99999999999")) {
				return msgPadrao;
			}

		}

		return null;
	}

}
