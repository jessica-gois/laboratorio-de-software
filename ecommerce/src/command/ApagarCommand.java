package command;

import model.domain.EntidadeDominio;
import model.domain.Result;


public class ApagarCommand extends AbstractCommand{
	public Result executar(EntidadeDominio entity) {
		return fachada.excluir(entity);
	}
}
