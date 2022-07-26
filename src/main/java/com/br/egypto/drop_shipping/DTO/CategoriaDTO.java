package com.br.egypto.drop_shipping.DTO;

public class CategoriaDTO {

	private String nome;

	private String link;

	private String icone_home;

	private Integer idListaPalavrasChaves;

	public CategoriaDTO() {
	}

	public CategoriaDTO(String nome, String link, String icone_home, Integer idListaPalavrasChaves) {
		super();
		this.nome = nome;
		this.link = link;
		this.icone_home = icone_home;
		this.idListaPalavrasChaves = idListaPalavrasChaves;
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

	public Integer getIdListaPalavrasChaves() {
		return idListaPalavrasChaves;
	}

	public void setIdListaPalavrasChaves(Integer idListaPalavrasChaves) {
		this.idListaPalavrasChaves = idListaPalavrasChaves;
	}

}
