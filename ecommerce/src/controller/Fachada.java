package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CartaoDAO;
import dao.ClienteDAO;
import dao.IDAO;
import model.domain.Cartao;
import model.domain.EntidadeDominio;
import model.domain.Result;
import negocio.IStrategy;

public class Fachada implements IFachada{
	private Map<String, IDAO> mapaDaos;
	
	public Fachada(){
		mapaDaos = new HashMap<String, IDAO>();
		mapaDaos.put(Cartao.class.getName(), new CartaoDAO());
	}

	@Override
	public String salvar(EntidadeDominio entidade) {
		String nmClass = entidade.getClass().getName();
		//List<IStrategy> rnsAntes = mapaAntesPesistencia.get(nmClass);
		
	//	StringBuilder sb = executarStrategies(rnsAntes, entidade);
		
		StringBuilder sb = new StringBuilder();
		
		if(sb.length()==0) {
			IDAO dao = mapaDaos.get(nmClass);
			dao.salvar(entidade);
		//	List<IStrategy> rnsDepois = mapaDepoisPesistencia.get(nmClass);
		//	sb.append(executarStrategies(rnsDepois, entidade));
		}else {
			return sb.toString();
		}
		
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultar(EntidadeDominio entidade) {
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
