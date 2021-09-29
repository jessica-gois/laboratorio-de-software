package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.ConsultarCommand;
import command.SalvarCommand;
import model.domain.Cartao;
import model.domain.Cliente;
import model.domain.Endereco;
import model.domain.Result;
import model.domain.Telefone;
import model.domain.Usuario;
import util.Conversao;

@WebServlet(urlPatterns = "/carregarDadosCliente")
public class CarregaDadosClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ConsultarCommand command = new ConsultarCommand();
	private Result resultado = new Result();
	private Usuario usuario = new Usuario();
	private Cliente cliente = new Cliente();
	private Cartao cartao = new Cartao();
	private Endereco endereco = new Endereco();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		prepararConsultaEntidades();
		
		if(sessao.getAttribute("clienteLogado") == null) {
			usuario.setId(Conversao.parseStringToInt(request.getParameter("id")));	
		}else {
			usuario = ((Cliente) sessao.getAttribute("clienteLogado")).getUsuario();
		}
		
		resultado = command.executar(usuario);	
		
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			usuario = (Usuario) resultado.getEntidades().get(0);
			cliente.setUsuario(usuario);
		}
		
		resultado = command.executar(cliente);		
		if(resultado.getEntidades() != null && !resultado.getEntidades().isEmpty()) {
			cliente = (Cliente) resultado.getEntidades().get(0);
		}
		
		cartao.setCliente(cliente);
		endereco.setCliente(cliente);
		sessao.setAttribute("clienteLogado", cliente);
		sessao.setAttribute("cartoes", command.executar(cartao).getEntidades());
		sessao.setAttribute("enderecos", command.executar(endereco).getEntidades());
		
		response.sendRedirect(request.getContextPath() + "/view/listaClientes.jsp");
	}

	
	private void prepararConsultaEntidades() {
		usuario.setPesquisa("id");
		cliente.setPesquisa("usuario");
		cartao.setPesquisa("cliente");
		endereco.setPesquisa("cliente");
	}
}
