package negocio;

import model.domain.Cliente;
import model.domain.EntidadeDominio;

public class ValidadorDadosCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		StringBuilder erros = new StringBuilder();
		
		if(cliente.getNome() == null || cliente.getNome().isBlank()) {
			erros.append("O nome � obrigat�rio.\n");
		}
		
		if(cliente.getSobrenome() == null || cliente.getSobrenome().isBlank()) {
			erros.append("O sobrenome � obrigat�rio.\n");
		}
		
		if(cliente.getGenero() == null || cliente.getGenero().isBlank()) {
			erros.append("O g�nero � obrigat�rio.\n");
		}
		
		if(cliente.getDataNascimento()== null) {
			erros.append("A data de nascimento � obrigat�ria.\n");
		}
		
		if(cliente.getGenero() == null || cliente.getGenero().isBlank()) {
			erros.append("O g�nero � obrigat�rio.\n");
		}

		if(erros != null && erros.length() > 0) {
			return erros.toString();
		}else {
			return null;
		}
	}

}
