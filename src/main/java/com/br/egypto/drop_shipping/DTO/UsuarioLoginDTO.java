package com.br.egypto.drop_shipping.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class UsuarioLoginDTO {

	@Column(unique = true)
	@NotNull(message = "Nome não pode ser nulo")
	private String nomeCompleto;

	@NotNull(message = "Idade não pode ser nulo")
	private Integer idade;

	@Column(unique = true)
	@NotNull(message = "Email não pode ser nulo")
	@Email(message = "Email deve ser válido")
	private String email;

	@Column(unique = true)
	@NotNull(message = "Senha não pode ser nula")
	private String senha;

	@Column(unique = true)
	@NotNull(message = "Telefone não pode ser nulo")
	private String telefone;

	@Column(unique = true)
	@CPF(message = "CPF deve conter pontuação e hífen")
	@NotNull(message = "CPF não pode ser nulo")
	private String cpf;

	@NotNull(message = "CEP não pode ser nulo")
	private String cep;

	@NotNull(message = "Estado não pode ser nulo")
	private String estado;

	@NotNull(message = "Cidade não pode ser nulo")
	private String cidade;

	@NotNull(message = "Bairro não pode ser nulo")
	private String bairro;

	@NotNull(message = "Rua não pode ser nule")
	private String rua;

	private Integer numero;

	private String complemento;

	public UsuarioLoginDTO() {
	}

	public UsuarioLoginDTO(@NotNull(message = "Nome não pode ser nulo") String nomeCompleto,
			@NotNull(message = "Idade não pode ser nulo") Integer idade,
			@NotNull(message = "Email não pode ser nulo") @Email(message = "Email deve ser válido") String email,
			@NotNull(message = "Senha não pode ser nula") String senha,
			@NotNull(message = "Telefone não pode ser nulo") String telefone,
			@CPF(message = "CPF deve conter pontuação e hífen") @NotNull(message = "CPF não pode ser nulo") String cpf,
			@NotNull(message = "CEP não pode ser nulo") String cep,
			@NotNull(message = "Estado não pode ser nulo") String estado,
			@NotNull(message = "Cidade não pode ser nulo") String cidade,
			@NotNull(message = "Bairro não pode ser nulo") String bairro,
			@NotNull(message = "Rua não pode ser nule") String rua, Integer numero, String complemento) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.idade = idade;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
