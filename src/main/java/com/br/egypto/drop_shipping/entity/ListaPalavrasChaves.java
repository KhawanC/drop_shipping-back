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
	private String slot_1;

	@Column(name = "slot_2")
	private String slot_2;

	@Column(name = "slot_3")
	private String slot_3;

	@Column(name = "slot_4")
	private String slot_4;

	@Column(name = "slot_5")
	private String slot_5;

	@Column(name = "slot_6")
	private String slot_6;

	@Column(name = "slot_7")
	private String slot_7;

	@Column(name = "slot_8")
	private String slot_8;

	@Column(name = "slot_9")
	private String slot_9;

	@Column(name = "slot_10")
	private String slot_10;

	public ListaPalavrasChaves() {
	}

	public ListaPalavrasChaves(Integer id, String slot_1, String slot_2, String slot_3, String slot_4, String slot_5,
			String slot_6, String slot_7, String slot_8, String slot_9, String slot_10) {
		super();
		this.id = id;
		this.slot_1 = slot_1;
		this.slot_2 = slot_2;
		this.slot_3 = slot_3;
		this.slot_4 = slot_4;
		this.slot_5 = slot_5;
		this.slot_6 = slot_6;
		this.slot_7 = slot_7;
		this.slot_8 = slot_8;
		this.slot_9 = slot_9;
		this.slot_10 = slot_10;
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

	public String getSlot_2() {
		return slot_2;
	}

	public void setSlot_2(String slot_2) {
		this.slot_2 = slot_2;
	}

	public String getSlot_3() {
		return slot_3;
	}

	public void setSlot_3(String slot_3) {
		this.slot_3 = slot_3;
	}

	public String getSlot_4() {
		return slot_4;
	}

	public void setSlot_4(String slot_4) {
		this.slot_4 = slot_4;
	}

	public String getSlot_5() {
		return slot_5;
	}

	public void setSlot_5(String slot_5) {
		this.slot_5 = slot_5;
	}

	public String getSlot_6() {
		return slot_6;
	}

	public void setSlot_6(String slot_6) {
		this.slot_6 = slot_6;
	}

	public String getSlot_7() {
		return slot_7;
	}

	public void setSlot_7(String slot_7) {
		this.slot_7 = slot_7;
	}

	public String getSlot_8() {
		return slot_8;
	}

	public void setSlot_8(String slot_8) {
		this.slot_8 = slot_8;
	}

	public String getSlot_9() {
		return slot_9;
	}

	public void setSlot_9(String slot_9) {
		this.slot_9 = slot_9;
	}

	public String getSlot_10() {
		return slot_10;
	}

	public void setSlot_10(String slot_10) {
		this.slot_10 = slot_10;
	}
}
