package com.br.egypto.drop_shipping.security;

public class AuthResposta {

	private String email;
	private String tokenAuth;

	public AuthResposta() {
		super();
	}

	public AuthResposta(String email, String tokenAuth) {
		this.email = email;
		this.tokenAuth = tokenAuth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTokenAuth() {
		return tokenAuth;
	}

	public void setTokenAuth(String tokenAuth) {
		this.tokenAuth = tokenAuth;
	}

}
