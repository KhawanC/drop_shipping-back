package com.br.egypto.drop_shipping.DTO;

public class ProdutoDTO {

	private String nome;

	private String link;

	private Double preco;

	private Integer prcntDesconto;

	private Integer idCategoria;

	private Integer idListaImagens;

	private Integer idListaPalavrasChaves;

	private Integer idListaTexto;

	public ProdutoDTO() {
	}

	public ProdutoDTO(String nome, String link, Double preco, Integer prcntDesconto, Integer idCategoria,
			Integer idListaImagens, Integer idListaPalavrasChaves, Integer idListaTexto) {
		this.nome = nome;
		this.link = link;
		this.preco = preco;
		this.prcntDesconto = prcntDesconto;
		this.idCategoria = idCategoria;
		this.idListaImagens = idListaImagens;
		this.idListaPalavrasChaves = idListaPalavrasChaves;
		this.idListaTexto = idListaTexto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getPrcntDesconto() {
		return prcntDesconto;
	}

	public void setPrcntDesconto(Integer prcntDesconto) {
		this.prcntDesconto = prcntDesconto;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getIdListaImagens() {
		return idListaImagens;
	}

	public void setIdListaImagens(Integer idListaImagens) {
		this.idListaImagens = idListaImagens;
	}

	public Integer getIdListaPalavrasChaves() {
		return idListaPalavrasChaves;
	}

	public void setIdListaPalavrasChaves(Integer idListaPalavrasChaves) {
		this.idListaPalavrasChaves = idListaPalavrasChaves;
	}

	public Integer getIdListaTexto() {
		return idListaTexto;
	}

	public void setIdListaTexto(Integer idListaTexto) {
		this.idListaTexto = idListaTexto;
	}

}
