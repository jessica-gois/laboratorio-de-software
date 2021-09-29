package command;


import model.domain.EntidadeDominio;
import model.domain.Result;

public class SalvarCommand extends AbstractCommand{
	public Result executar(EntidadeDominio entidade) {
		return fachada.salvar(entidade);
	}
}
