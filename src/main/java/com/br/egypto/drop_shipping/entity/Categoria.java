package com.br.egypto.drop_shipping.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer id;

	@Column(name = "nome", unique = true)
	private String nome;

	@Column(name = "link", unique = true)
	private String link;

	@Column(name = "icone_home")
	private String icone_home;

	@ManyToOne
	@JoinColumn(name = "id_imagem", referencedColumnName = "id_lista_imagens")
	private ListaImagens listaImagens;

	@ManyToOne
	@JoinColumn(name = "id_palavras_chaves", referencedColumnName = "id_palavra_chave")
	private ListaPalavrasChaves listaPalavrasChaves;

	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private List<Produto> produtos;

	public Categoria() {
	}

	public Categoria(Integer id, String nome, String link, String icone_home, ListaImagens listaImagens,
			ListaPalavrasChaves listaPalavrasChaves, List<Produto> produtos) {
		this.id = id;
		this.nome = nome;
		this.link = link;
		this.icone_home = icone_home;
		this.listaImagens = listaImagens;
		this.listaPalavrasChaves = listaPalavrasChaves;
		this.produtos = produtos;
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

	public String getIcone_home() {
		return icone_home;
	}

	public void setIcone_home(String icone_home) {
		this.icone_home = icone_home;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
