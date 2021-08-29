package command;

import controller.Fachada;
import controller.IFachada;

public abstract class AbstractCommand implements Acao{	
	protected IFachada fachada = new Fachada();

}

