package com.br.egypto.drop_shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.egypto.drop_shipping.DTO.EmailConfirmacaoDTO;
import com.br.egypto.drop_shipping.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public ResponseEntity<EmailConfirmacaoDTO> enviarEmail(@RequestBody EmailConfirmacaoDTO emailDTO) {
		return new ResponseEntity<>(emailService.enviarEmailConfirmacao(emailDTO), HttpStatus.CREATED);
	}

}
