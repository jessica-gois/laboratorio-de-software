package command;

import model.domain.EntidadeDominio;
import model.domain.Result;

public interface ICommand {
	
	Result executar(EntidadeDominio entity);
}



