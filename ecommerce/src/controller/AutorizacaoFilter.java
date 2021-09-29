package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/controlador")
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("Filter: AutorizacaoFilter");	
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String parametroAcao = request.getParameter("acao");	
				
				
		HttpSession sessao = request.getSession();
		boolean usuarioNaoLogado = (sessao.getAttribute("clienteLogado") == null);
		boolean acaoProtegida = !(parametroAcao.equals("login") || parametroAcao.equals("LoginFormulario") || parametroAcao.equals("IndexFormulario")  
				|| parametroAcao.equals("CadastraClienteFormulario")	
				);
		
		
		if (acaoProtegida && usuarioNaoLogado) {
			response.sendRedirect("controlador?acao=LoginFormulario");	
			return;	
		}		
			
		
		
		
		chain.doFilter(request, response);
	}



}
