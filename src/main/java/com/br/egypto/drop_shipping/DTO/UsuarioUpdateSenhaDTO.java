package com.br.egypto.drop_shipping.DTO;

public class UsuarioUpdateSenhaDTO {

	private Integer id;

	private String senha;

	public UsuarioUpdateSenhaDTO() {
	}

	public UsuarioUpdateSenhaDTO(Integer id, String senha) {
		this.id = id;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
