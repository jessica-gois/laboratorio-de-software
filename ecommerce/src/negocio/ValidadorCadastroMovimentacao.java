package negocio;

import model.domain.EntidadeDominio;
import model.domain.MovimentacaoEstoque;

public class ValidadorCadastroMovimentacao implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		if (entidade instanceof MovimentacaoEstoque) {
			
		}

		return null;
	}

}
