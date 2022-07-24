package com.br.egypto.drop_shipping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.DTO.EmailConfirmacaoDTO;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMail;
	
	public EmailConfirmacaoDTO enviarEmailConfirmacao(EmailConfirmacaoDTO dados) {
		
		SimpleMailMessage mensagem = new SimpleMailMessage();
		
		mensagem.setTo(dados.getDestinatario());
		mensagem.setSubject("Email de confirmação");
		mensagem.setText("Seu código de confirmação é: " + dados.getCodigo());
		javaMail.send(mensagem);
		
		return dados;
	}
}
