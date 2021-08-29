package negocio;

import org.junit.platform.commons.util.StringUtils;

import model.domain.Endereco;
import model.domain.EntidadeDominio;

public class ValidadorEndereco implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco) entidade;
		StringBuilder erros = new StringBuilder();

		if (StringUtils.isBlank(endereco.getLogradouro())) {
			erros.append("O logradouro é obrigatório");	
		}

		if (StringUtils.isBlank(endereco.getBairro())) {
			erros.append("O bairro é obrigatório");	
		}

		if (StringUtils.isBlank(endereco.getNumero())) {
			erros.append("O número é obrigatório");	
		}
		
		if (endereco.getCidade() == null) {
			erros.append("A cidade é obrigatória");	
		}

		if (StringUtils.isBlank(endereco.getDescricao())) {
			erros.append("A descricao é obrigatória");	
		}

		if (StringUtils.isBlank(endereco.getCep())) {
			erros.append("O cep é obrigatório");	
		}

		if (endereco.getTipoLogradouro() == null) {
			erros.append("O tipo do logradouro é obrigatório");	
		}
		if (endereco.getTipoResidencia() == null) {
			erros.append("O logradouro é obrigatório");	
		}
		
		if(StringUtils.isNotBlank(erros.toString())) {
			return erros.toString();
		}else {
			return null;
		}
		
	}

}
