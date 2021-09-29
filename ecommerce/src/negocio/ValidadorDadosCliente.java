package negocio;

import model.domain.Cliente;
import model.domain.EntidadeDominio;

public class ValidadorDadosCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		StringBuilder erros = new StringBuilder();
		
		if(cliente.getNome() == null || cliente.getNome().isBlank()) {
			erros.append("O nome é obrigatório.\n");
		}
		
		if(cliente.getSobrenome() == null || cliente.getSobrenome().isBlank()) {
			erros.append("O sobrenome é obrigatório.\n");
		}
		
		if(cliente.getGenero() == null || cliente.getGenero().isBlank()) {
			erros.append("O gênero é obrigatório.\n");
		}
		
		if(cliente.getDataNascimento()== null) {
			erros.append("A data de nascimento é obrigatória.\n");
		}
		
		if(cliente.getGenero() == null || cliente.getGenero().isBlank()) {
			erros.append("O gênero é obrigatório.\n");
		}

		if(erros != null && erros.length() > 0) {
			return erros.toString();
		}else {
			return null;
		}
	}

}
