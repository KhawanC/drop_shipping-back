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
@Table(name = "lista_texto")
public class ListaTexto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista_texto")
	private Integer id;

	@Column(name = "slot_1")
	private String slot_1;

	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private List<Produto> produtos;

	public ListaTexto() {
	}

	public ListaTexto(Integer id, String slot_1, List<Produto> produtos) {
		this.id = id;
		this.slot_1 = slot_1;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
