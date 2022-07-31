package com.br.egypto.drop_shipping.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "palavra_chave")
public class ListaPalavrasChaves {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_palavra_chave")
	private Integer id;

	@Column(name = "slot_1")
	private String slot_1;

	@OneToMany(mappedBy = "listaImagens")
	@JsonIgnore
	private List<Categoria> categoria;

	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private List<Produto> produtos;

	public ListaPalavrasChaves() {
	}

	public ListaPalavrasChaves(Integer id, String slot_1, List<Categoria> categoria, List<Produto> produtos) {
		this.id = id;
		this.slot_1 = slot_1;
		this.categoria = categoria;
		this.produtos = produtos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSlot_1() {
		return slot_1;
	}

	public void setSlot_1(String slot_1) {
		this.slot_1 = slot_1;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
