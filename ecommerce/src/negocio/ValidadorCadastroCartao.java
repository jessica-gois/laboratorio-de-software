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
			erros.append("O n�mero do cart�o � obrigat�rio");
		}

		if (cartao.getNomeImpresso() == null || cartao.getNomeImpresso() =="") {
			erros.append("O nome impresso no cart�o � obrigat�rio");
		}

		if (cartao.getCodigoSeguranca() == null || cartao.getCodigoSeguranca() == "") {
			erros.append("O c�digo de seguran�a � obrigat�rio");
		}

		if (cartao.getBandeira() == null) {
			erros.append("A bandeira � obrigat�ria");
		}

		if (erros != null && erros.length() > 0) {
			return erros.toString();
		} else {
			return null;
		}
	}

}
