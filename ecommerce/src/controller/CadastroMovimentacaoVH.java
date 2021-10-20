package controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.EntidadeDominio;
import model.domain.EstoqueItem;
import model.domain.Livro;
import model.domain.MovimentacaoEstoque;
import model.domain.Result;
import model.domain.enums.TipoMovimentacao;
import util.Conversao;

public class CadastroMovimentacaoVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		

		MovimentacaoEstoque movimentacao = null;
			try {
				
				Livro livro = new Livro();
				livro.setId(Conversao.parseStringToInt(request.getParameter("livro")));
				
				
				TipoMovimentacao tipo = TipoMovimentacao.valueOf(request.getParameter("tipo"));
			
				movimentacao = new MovimentacaoEstoque(null, null, 
				Conversao.parseStringToDate(request.getParameter("data"),"yyyy-MM-dd"),
				Conversao.parseStringToDouble(request.getParameter("quantidade")), 
				Conversao.parseStringToDouble(request.getParameter("precoCusto")), 
				request.getParameter("fornecedor"), 
				tipo,
				tipo.isEntrada(),
				null,
				livro);
			} catch (ParseException e) {
				e.printStackTrace();
			}
				
				return movimentacao;
			}		
	
	
	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/view/consultarMovimentacoes");	
	}

}
