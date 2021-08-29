package controller;

import java.util.List;

import model.domain.EntidadeDominio;
import model.domain.Result;

public interface IFachada {

	public String salvar(EntidadeDominio entidade);
	public String alterar(EntidadeDominio entidade);
	public String excluir(EntidadeDominio entidade);
	public String consultar(EntidadeDominio entidade);
	
	
}
