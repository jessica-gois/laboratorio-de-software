package negocio;

import model.domain.Endereco;
import model.domain.EntidadeDominio;

public class ValidadorEndereco implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco) entidade;
		StringBuilder erros = new StringBuilder();

		if (endereco.getLogradouro() == null || endereco.getLogradouro().isBlank()) {
			erros.append("O logradouro é obrigatório");	
		}

		if (endereco.getBairro() == null || endereco.getBairro().isBlank()) {
			erros.append("O bairro é obrigatório");	
		}

		if (endereco.getNumero() == null || endereco.getNumero().isBlank()) {
			erros.append("O número é obrigatório");	
		}
		
		if (endereco.getCidade() == null) {
			erros.append("A cidade é obrigatória");	
		}

		if (endereco.getDescricao() == null || endereco.getDescricao().isBlank()) {
			erros.append("A descricao é obrigatória");	
		}

		if (endereco.getCep() == null || endereco.getCep().isBlank()) {
			erros.append("O cep é obrigatório");	
		}

		if (endereco.getTipoLogradouro() == null) {
			erros.append("O tipo do logradouro é obrigatório");	
		}
		if (endereco.getTipoResidencia() == null) {
			erros.append("O logradouro é obrigatório");	
		}
		
		if(erros.toString() != null && erros.toString() != "") {
			return erros.toString();
		}else {
			return null;
		}
		
	}

}
