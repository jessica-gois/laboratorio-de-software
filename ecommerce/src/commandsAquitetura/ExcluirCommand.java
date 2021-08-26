package commandsAquitetura;

import model.domain.EntidadeDominio;
import model.domain.Result;

public class ExcluirCommand extends AbstractCommand{
	public Result executar(EntidadeDominio entity) {
		return fachada.excluir(entity);
	}
}
