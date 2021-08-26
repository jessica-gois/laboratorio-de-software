package controller;

import java.util.List;

import model.domain.EntidadeDominio;
import model.domain.Result;
import negocio.IStrategy;

public class Fachada implements IFachada{

	@Override
	public Result salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private StringBuilder executarStrategies(List<IStrategy> strategies, EntidadeDominio entidade) {
		StringBuilder retorno = new StringBuilder();
		for(IStrategy rn:strategies) {
			String msg = rn.processar(entidade);
			if(msg!= null) {
				retorno.append(msg);
			}
		}
		return retorno;
	}

}
