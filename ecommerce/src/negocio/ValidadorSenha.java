package negocio;

import org.junit.platform.commons.util.StringUtils;

import model.domain.EntidadeDominio;
import model.domain.Usuario;

public class ValidadorSenha implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		
		if(StringUtils.isBlank(usuario.getSenha())) {
			return "A senha é obrigatória";
		}
		return null;	
	}
	

}
