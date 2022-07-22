package com.br.egypto.drop_shipping.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id;

	@Column(name = "super_usuario")
	private Boolean isSuperUsuario;

	@Column(name = "nome_completo", unique = true)
	private String nomeCompleto;

	@Column(name = "idade")
	private Integer idade;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "telefone", unique = true)
	private String telefone;

	@Column(name = "cpf", unique = true)
	private String cpf;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@Column(name = "id_endereco")
	private List<Endereco> endereco;

	public Usuario() {
	}

	public Usuario(Integer id, Boolean isSuperUsuario, String nomeCompleto, Integer idade, String email, String senha,
			String telefone, String cpf, List<Endereco> endereco) {
		super();
		this.id = id;
		this.isSuperUsuario = isSuperUsuario;
		this.nomeCompleto = nomeCompleto;
		this.idade = idade;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsSuperUsuario() {
		return isSuperUsuario;
	}

	public void setIsSuperUsuario(Boolean isSuperUsuario) {
		this.isSuperUsuario = isSuperUsuario;
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

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
