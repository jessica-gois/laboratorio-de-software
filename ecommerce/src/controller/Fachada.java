package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CartaoDAO;
import dao.ClienteDAO;
import dao.IDAO;
import model.domain.Cartao;
import model.domain.Cliente;
import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.Usuario;
import negocio.ComplementarDataCadastro;
import negocio.GerarLog;
import negocio.IStrategy;
import negocio.ValidadorCadastroCartao;
import negocio.ValidadorCpf;
import negocio.ValidadorDadosCliente;
import negocio.ValidadorEndereco;
import negocio.ValidadorExistenciaCliente;
import negocio.ValidadorSenha;

public class Fachada implements IFachada {
	private Map<String, IDAO> mapaDaos;
	private Map<String, List<IStrategy>> mapaAntesPesistencia;
	private Map<String, List<IStrategy>> mapaDepoisPesistencia;

	public Fachada() {

		// GerarLog gLog = new GerarLog();

		List<IStrategy> rnAntesCliente = new ArrayList<IStrategy>();
		List<IStrategy> rnAntesCartao = new ArrayList<IStrategy>();
		List<IStrategy> rnAntesEndereco = new ArrayList<IStrategy>();
		List<IStrategy> rnAntesUsuario = new ArrayList<IStrategy>();

		List<IStrategy> rnDepois = new ArrayList<IStrategy>();

		mapaAntesPesistencia = new HashMap<String, List<IStrategy>>();
		mapaDepoisPesistencia = new HashMap<String, List<IStrategy>>();

		carregarMapaAntesPersistencia(rnAntesCliente, rnAntesCartao, rnAntesEndereco, rnAntesUsuario);

		mapaDaos = new HashMap<String, IDAO>();
		mapaDaos.put(Cartao.class.getName(), new CartaoDAO());
	}

	@Override
	public String salvar(EntidadeDominio entidade) {
		String nmClass = entidade.getClass().getName();
		List<IStrategy> rnsAntes = mapaAntesPesistencia.get(nmClass);

		StringBuilder sb = executarStrategies(rnsAntes, entidade);

		if (sb.length() == 0) {
			IDAO dao = mapaDaos.get(nmClass);
			dao.salvar(entidade);
			// List<IStrategy> rnsDepois = mapaDepoisPesistencia.get(nmClass);
			// sb.append(executarStrategies(rnsDepois, entidade));
		} else {
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
		for (IStrategy rn : strategies) {
			String msg = rn.processar(entidade);
			if (msg != null) {
				retorno.append(msg);
			}
		}
		return retorno;
	}

	public void carregarMapaAntesPersistencia(List<IStrategy> rnAntesCliente, List<IStrategy> rnAntesCartao,
			List<IStrategy> rnAntesEndereco, List<IStrategy> rnAntesUsuario) {

		ComplementarDataCadastro cDtCadastro = new ComplementarDataCadastro();

		// Regras antes da persistencia do cliente
		rnAntesCliente.add(new ValidadorCadastroCartao());
		rnAntesCliente.add(new ValidadorCpf());
		rnAntesCliente.add(new ValidadorDadosCliente());
		rnAntesCliente.add(new ValidadorExistenciaCliente());
		rnAntesCliente.add(cDtCadastro);

		// Regras antes da persistencia do cartão
		rnAntesCartao.add(new ValidadorCadastroCartao());
		rnAntesCartao.add(cDtCadastro);

		// Regras antes da persistencia do endereço
		rnAntesEndereco.add(new ValidadorEndereco());
		rnAntesEndereco.add(cDtCadastro);

		// Regras antes da persistencia do usuario
		rnAntesUsuario.add(new ValidadorSenha());
		rnAntesUsuario.add(cDtCadastro);

		mapaAntesPesistencia.put(Cliente.class.getName(), rnAntesCliente);
		mapaAntesPesistencia.put(Cartao.class.getName(), rnAntesCartao);
		mapaAntesPesistencia.put(Endereco.class.getName(), rnAntesEndereco);
		mapaAntesPesistencia.put(Usuario.class.getName(), rnAntesUsuario);
	}

}
