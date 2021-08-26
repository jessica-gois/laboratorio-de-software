package commandsAquitetura;

import model.domain.EntidadeDominio;
import model.domain.Result;

public class SalvarCommand extends AbstractCommand{
	public Result executar(EntidadeDominio entity) {
		return fachada.salvar(entity);
	}
}
