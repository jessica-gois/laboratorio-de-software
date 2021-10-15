package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CartaoDAO;
import dao.ClienteDAO;
import dao.CupomDAO;
import dao.EnderecoDAO;
import dao.IDAO;
import dao.LivroDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;
import model.domain.Cartao;
import model.domain.Cliente;
import model.domain.Cupom;
import model.domain.Endereco;
import model.domain.EntidadeDominio;
import model.domain.Livro;
import model.domain.Pedido;
import model.domain.Result;
import model.domain.Usuario;
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
	Result result = new Result();

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
		mapaDaos.put(Usuario.class.getName(), new UsuarioDAO());
		mapaDaos.put(Cliente.class.getName(), new ClienteDAO());
		mapaDaos.put(Endereco.class.getName(), new EnderecoDAO());
		mapaDaos.put(Livro.class.getName(), new LivroDAO());
		mapaDaos.put(Cupom.class.getName(), new CupomDAO());
		mapaDaos.put(Pedido.class.getName(), new PedidoDAO());
	}

	@Override
	public Result salvar(EntidadeDominio entidade) {
		String nmClass = entidade.getClass().getName();
		List<IStrategy> rnsAntes = mapaAntesPesistencia.get(nmClass);

		StringBuilder sb = executarStrategies(rnsAntes, entidade);

		if (sb.length() == 0) {
			IDAO dao = mapaDaos.get(nmClass);
			dao.salvar(entidade);
			// List<IStrategy> rnsDepois = mapaDepoisPesistencia.get(nmClass);
			// sb.append(executarStrategies(rnsDepois, entidade));
		} else {
			result.setResposta(sb.toString());
		}

		return result;
	}

	@Override
	public Result alterar(EntidadeDominio entidade) {
		String nmClass = entidade.getClass().getName();
		List<IStrategy> rnsAntes = mapaAntesPesistencia.get(nmClass);

		StringBuilder sb = executarStrategies(rnsAntes, entidade);

		if (sb.length() == 0) {
			IDAO dao = mapaDaos.get(nmClass);
			dao.alterar(entidade);
			// List<IStrategy> rnsDepois = mapaDepoisPesistencia.get(nmClass);
			// sb.append(executarStrategies(rnsDepois, entidade));
		} else {
			result.setResposta(sb.toString());
		}
		return result;
	}

	@Override
	public Result excluir(EntidadeDominio entidade) {
		String name = entidade.getClass().getName();
		String mensagem = mapaDaos.get(name).excluir(entidade);
		if (mensagem == null) {
			return result;
		}
		result.setResposta(mensagem);
		return result;
	}

	@Override
	public Result consultar(EntidadeDominio entidade) {
		String nomeClasse = entidade.getClass().getName();
		 List<EntidadeDominio> lista = mapaDaos.get(nomeClasse).consultar(entidade);
		Result result = new Result();
		for (EntidadeDominio obj : lista) {
			result.addEntidades(obj);
		}
		return result;
	}
	
	private StringBuilder executarStrategies(List<IStrategy> strategies, EntidadeDominio entidade) {
		StringBuilder retorno = new StringBuilder();
		if (strategies != null) {
			for (IStrategy rn : strategies) {
				String msg = rn.processar(entidade);
				if (msg != null) {
					retorno.append(msg);
				}
			}
		}
		return retorno;
	}

	public void carregarMapaAntesPersistencia(List<IStrategy> rnAntesCliente, List<IStrategy> rnAntesCartao,
			List<IStrategy> rnAntesEndereco, List<IStrategy> rnAntesUsuario) {

		// Regras antes da persistencia do cliente
		rnAntesCliente.add(new ValidadorCpf());
		rnAntesCliente.add(new ValidadorDadosCliente());
		rnAntesCliente.add(new ValidadorExistenciaCliente());

		// Regras antes da persistencia do cartão
		rnAntesCartao.add(new ValidadorCadastroCartao());

		// Regras antes da persistencia do endereço
		rnAntesEndereco.add(new ValidadorEndereco());

		// Regras antes da persistencia do usuario
		rnAntesUsuario.add(new ValidadorSenha());

		mapaAntesPesistencia.put(Cliente.class.getName(), rnAntesCliente);
		mapaAntesPesistencia.put(Cartao.class.getName(), rnAntesCartao);
		mapaAntesPesistencia.put(Endereco.class.getName(), rnAntesEndereco);
		mapaAntesPesistencia.put(Usuario.class.getName(), rnAntesUsuario);
	}

}
