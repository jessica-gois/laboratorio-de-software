package negocio;

import model.domain.Endereco;
import model.domain.EntidadeDominio;

public class ValidadorEndereco implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco) entidade;
		StringBuilder erros = new StringBuilder();

		if (endereco.getLogradouro() == null || endereco.getLogradouro().isBlank()) {
			erros.append("O logradouro � obrigat�rio");	
		}

		if (endereco.getBairro() == null || endereco.getBairro().isBlank()) {
			erros.append("O bairro � obrigat�rio");	
		}

		if (endereco.getNumero() == null || endereco.getNumero().isBlank()) {
			erros.append("O n�mero � obrigat�rio");	
		}
		
		if (endereco.getCidade() == null) {
			erros.append("A cidade � obrigat�ria");	
		}

		if (endereco.getDescricao() == null || endereco.getDescricao().isBlank()) {
			erros.append("A descricao � obrigat�ria");	
		}

		if (endereco.getCep() == null || endereco.getCep().isBlank()) {
			erros.append("O cep � obrigat�rio");	
		}

		if (endereco.getTipoLogradouro() == null) {
			erros.append("O tipo do logradouro � obrigat�rio");	
		}
		if (endereco.getTipoResidencia() == null) {
			erros.append("O logradouro � obrigat�rio");	
		}
		
		if(erros.toString() != null && erros.toString() != "") {
			return erros.toString();
		}else {
			return null;
		}
		
	}

}
