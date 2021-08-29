package dao;

import java.util.List;

import model.domain.EntidadeDominio;

public interface IDAO {

	public String salvar(EntidadeDominio entidade);
	public String alterar(EntidadeDominio entidade);
	public String excluir(EntidadeDominio entidade);
	public <T extends EntidadeDominio> List<T> consultar(EntidadeDominio entidade);
	
}
