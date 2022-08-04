package com.br.egypto.drop_shipping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "link")
	private String link;

	@Column(name = "preco")
	private Double preco;

	@Column(name = "prcnt_desconto")
	private Integer prcntDesconto;

	@Column(name = "total_cliques")
	private Integer totalCliques;

	@Column(name = "total_compras")
	private Integer totalCompras;

	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "id_imagem", referencedColumnName = "id_lista_imagens")
	private ListaImagens listaImagens;

	@ManyToOne
	@JoinColumn(name = "id_palavras_chaves", referencedColumnName = "id_palavra_chave")
	private ListaPalavrasChaves listaPalavrasChaves;

	@ManyToOne
	@JoinColumn(name = "id_lista_texto", referencedColumnName = "id_lista_texto")
	private ListaTexto listaTexto;

	public Produto() {
	}

	public Produto(Integer id, String nome, String link, Double preco, Integer prcntDesconto, Integer totalCliques,
			Integer totalCompras, Categoria categoria, ListaImagens listaImagens,
			ListaPalavrasChaves listaPalavrasChaves, ListaTexto listaTexto) {
		super();
		this.id = id;
		this.nome = nome;
		this.link = link;
		this.preco = preco;
		this.prcntDesconto = prcntDesconto;
		this.totalCliques = totalCliques;
		this.totalCompras = totalCompras;
		this.categoria = categoria;
		this.listaImagens = listaImagens;
		this.listaPalavrasChaves = listaPalavrasChaves;
		this.listaTexto = listaTexto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getTotalCompras() {
		return totalCompras;
	}

	public void setTotalCompras(Integer totalCompras) {
		this.totalCompras = totalCompras;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ListaImagens getListaImagens() {
		return listaImagens;
	}

	public void setListaImagens(ListaImagens listaImagens) {
		this.listaImagens = listaImagens;
	}

	public ListaPalavrasChaves getListaPalavrasChaves() {
		return listaPalavrasChaves;
	}

	public void setListaPalavrasChaves(ListaPalavrasChaves listaPalavrasChaves) {
		this.listaPalavrasChaves = listaPalavrasChaves;
	}

	public ListaTexto getListaTexto() {
		return listaTexto;
	}

	public void setListaTexto(ListaTexto listaTexto) {
		this.listaTexto = listaTexto;
	}

	public Integer getTotalCliques() {
		return totalCliques;
	}

	public void setTotalCliques(Integer totalCliques) {
		this.totalCliques = totalCliques;
	}

}
