package com.br.egypto.drop_shipping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "palavra_chave")
public class ListaPalavrasChaves {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_palavra_chave")
	private Integer id;

	@Column(name = "slot_1")
	private String[] slot_1;

	public ListaPalavrasChaves() {
	}

	public ListaPalavrasChaves(Integer id, String[] slot_1) {
		this.id = id;
		this.slot_1 = slot_1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String[] getSlot_1() {
		return slot_1;
	}

	public void setSlot_1(String[] slot_1) {
		this.slot_1 = slot_1;
	}

}
