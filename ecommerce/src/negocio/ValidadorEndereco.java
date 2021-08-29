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
			erros.append("O logradouro � obrigat�rio");	
		}

		if (StringUtils.isBlank(endereco.getBairro())) {
			erros.append("O bairro � obrigat�rio");	
		}

		if (StringUtils.isBlank(endereco.getNumero())) {
			erros.append("O n�mero � obrigat�rio");	
		}
		
		if (endereco.getCidade() == null) {
			erros.append("A cidade � obrigat�ria");	
		}

		if (StringUtils.isBlank(endereco.getDescricao())) {
			erros.append("A descricao � obrigat�ria");	
		}

		if (StringUtils.isBlank(endereco.getCep())) {
			erros.append("O cep � obrigat�rio");	
		}

		if (endereco.getTipoLogradouro() == null) {
			erros.append("O tipo do logradouro � obrigat�rio");	
		}
		if (endereco.getTipoResidencia() == null) {
			erros.append("O logradouro � obrigat�rio");	
		}
		
		if(StringUtils.isNotBlank(erros.toString())) {
			return erros.toString();
		}else {
			return null;
		}
		
	}

}
