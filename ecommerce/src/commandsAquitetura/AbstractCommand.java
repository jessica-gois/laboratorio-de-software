package commandsAquitetura;

import controller.Fachada;
import controller.IFachada;

public abstract class AbstractCommand implements ICommand{	
	protected IFachada fachada = new Fachada();

}

