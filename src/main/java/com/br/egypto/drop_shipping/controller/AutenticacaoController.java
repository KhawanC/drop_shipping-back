package com.br.egypto.drop_shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.egypto.drop_shipping.security.AuthPedido;
import com.br.egypto.drop_shipping.service.UsuarioService;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody AuthPedido login) throws Exception {
		return new ResponseEntity<>(usuarioService.autenticarUsuario(login), HttpStatus.ACCEPTED);
	}
}
