package negocio;

import java.util.Date;

import model.domain.EntidadeDominio;

public class ComplementarDataCadastro implements IStrategy {
	@Override
	public String processar(EntidadeDominio entidade) {
		entidade.setDtCadastro(new Date());
		return null;
	}
}
