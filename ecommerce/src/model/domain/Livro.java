package model.domain;

import java.util.List;

public class Livro extends EntidadeDominio {
	private String titulo;
	private String autor;
	private String editora;
	private String ano; //revisar tipo do atributo
	private Integer qtdPaginas; //mudar nome?
	private String edicao;
	private String sinopse;
	private Double altura;
	private Double largura;
	private Double peso;
	private Double profundidade;
	private String codigoBarras;
	private String isbn;
	private GrupoPrecificacao grupoPrecificacao;
	private List<Categoria> categorias;
	private Double precoVenda;
	private Boolean status;
	
	private Double qtdEstoque;
	private Double qtdDisponivelCompra;
	private String caminhoImagem;
	
	public Livro(){
		
	}
	
	public Livro(Integer id, String titulo, String autor, String editora, String ano, Integer qtdPaginas, String edicao,
		String sinopse, Double altura, Double largura, Double peso, Double profundidade, String codigoBarras,
		GrupoPrecificacao grupoPrecificacao, Double precoVenda, Boolean status, String caminhoImagem, String isbn, Double qtdEstoque) {
		super();
		if(id != null) {
			this.setId(id);
		}
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.ano = ano;
		this.qtdPaginas = qtdPaginas;
		this.edicao = edicao;
		this.sinopse = sinopse;
		this.altura = altura;
		this.largura = largura;
		this.peso = peso;
		this.profundidade = profundidade;
		this.codigoBarras = codigoBarras;
		this.grupoPrecificacao = grupoPrecificacao;
		this.precoVenda = precoVenda;
		this.status = status;	
		this.caminhoImagem = caminhoImagem;
		this.isbn = isbn;
		this.qtdEstoque = qtdEstoque;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public Integer getQtdPaginas() {
		return qtdPaginas;
	}
	
	public void setQtdPaginas(Integer qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
	
	public String getEdicao() {
		return edicao;
	}
	
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	public Double getAltura() {
		return altura;
	}
	
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	public Double getLargura() {
		return largura;
	}
	
	public void setLargura(Double largura) {
		this.largura = largura;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getProfundidade() {
		return profundidade;
	}
	
	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public GrupoPrecificacao getGrupoPrecificacao() {
		return grupoPrecificacao;
	}
	
	public void setGrupoPrecificacao(GrupoPrecificacao grupoPrecificacao) {
		this.grupoPrecificacao = grupoPrecificacao;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Double getPrecoVenda() {
		if(precoVenda == null) {
			precoVenda = 0d;
		}
		return precoVenda;
	}
	
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getQtdEstoque() {
		if(qtdEstoque == null) {
			qtdEstoque = 0d;
		}
		return qtdEstoque;
	}

	public void setQtdEstoque(Double qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Double getQtdDisponivelCompra(Carrinho carrinho) {
		qtdDisponivelCompra = getQtdEstoque() != null ? getQtdEstoque() : 0;
		if(carrinho != null && carrinho.getItens() != null) {
			for(CarrinhoItem itemCarrinho : carrinho.getItens()) {
				if(itemCarrinho.getLivro().getId() == this.getId()
					&& getQtdEstoque() > itemCarrinho.getQuantidade()) {
					qtdDisponivelCompra = this.getQtdEstoque() - itemCarrinho.getQuantidade();
				}
			}
		}
		
		return qtdDisponivelCompra;
	}

	public Double getQtdDisponivelCompra() {
		if(qtdDisponivelCompra == null) {
			qtdDisponivelCompra = 0d;
		}
		return qtdDisponivelCompra;
	}

	public void setQtdDisponivelCompra(Double qtdDisponivelCompra) {
		this.qtdDisponivelCompra = qtdDisponivelCompra;
	}
	
}
