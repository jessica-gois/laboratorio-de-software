package command;

import model.domain.EntidadeDominio;
import model.domain.Result;

public class ConsultarCommand extends AbstractCommand{
	public Result executar(EntidadeDominio entity) {
		return fachada.consultar(entity);
	}
}
