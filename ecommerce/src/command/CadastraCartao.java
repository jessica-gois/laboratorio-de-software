package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Cartao;
import model.domain.Cliente;
import model.domain.EntidadeDominio;
import model.domain.Result;
import model.domain.enums.Bandeira;
import util.Conversao;

public class CadastraCartao extends AbstractCommand {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();           
        Cliente cliente = (Cliente)sessao.getAttribute("clienteLogado");
				
		Cartao cartao = new Cartao(request.getParameter("numeroCartao"), Bandeira.valueOf(request.getParameter("bandeira")) ,
				request.getParameter("nomeImpresso"), request.getParameter("codigoSeguranca"), 
				Conversao.parseStringToBoolean(request.getParameter("preferencial")), cliente);		
		
		// TODO Auto-generated method stub
		return fachada.salvar(cartao);
	}
}
