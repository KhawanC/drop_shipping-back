package com.br.egypto.drop_shipping.DTO;

public class EmailConfirmacaoDTO {

	private String destinatario;
	private String codigo;

	public EmailConfirmacaoDTO() {
	}

	public EmailConfirmacaoDTO(String destinatario, String codigo) {
		super();
		this.destinatario = destinatario;
		this.codigo = codigo;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
