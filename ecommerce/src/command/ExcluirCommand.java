package command;

import model.domain.EntidadeDominio;
import model.domain.Result;

public class ExcluirCommand extends AbstractCommand{
	public Result executar(EntidadeDominio entidade) {
		return fachada.excluir(entidade);
	}
}
