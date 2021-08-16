package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/controlador")
public class TempoExecucaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filter: TempoExecucaoFilter");		
		Long antesExecucaoCodigo = System.currentTimeMillis();
		String acao = request.getParameter("acao");
		// chain = executa a ação
		chain.doFilter(request, response);
		Long depoisExecucaoCodigo = System.currentTimeMillis();
		System.out.println("Tempo de execução da ação: " + acao + "-> " + (depoisExecucaoCodigo - antesExecucaoCodigo));

	}

}
