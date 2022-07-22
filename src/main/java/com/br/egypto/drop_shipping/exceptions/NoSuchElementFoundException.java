package com.br.egypto.drop_shipping.exceptions;

public class NoSuchElementFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSuchElementFoundException(String mensagem) {
		super(mensagem);
	}
}
