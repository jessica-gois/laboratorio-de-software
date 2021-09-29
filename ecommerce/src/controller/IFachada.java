package controller;

import java.util.List;

import model.domain.EntidadeDominio;
import model.domain.Result;

public interface IFachada {

	public Result salvar(EntidadeDominio entidade);
	public Result alterar(EntidadeDominio entidade);
	public Result excluir(EntidadeDominio entidade);
	public Result consultar(EntidadeDominio entidade);
	
	
}
