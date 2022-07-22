package com.br.egypto.drop_shipping.exceptions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

	private final int status;
	private final String mensagem;
	private List<String> detalhes;

	public ErrorResponse(int status, String mensagem) {
		super();
		this.status = status;
		this.mensagem = mensagem;
	}

	public ErrorResponse(int status, String mensagem, List<String> detalhes) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public int getStatus() {
		return status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public List<String> getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(List<String> detalhes) {
		this.detalhes = detalhes;
	}

}
